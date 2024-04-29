package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment_class_4 extends Fragment {
    private EditText orderEditText;
    private EditText editCodeEditText;
    private Spinner categorySpinner;
    private Spinner itemSpinner;
    private Button btnSave;
    private Button btnDelete;
    private TextView outputTextView;
    private SQLiteDatabase database;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View Fragment4View = inflater.inflate(R.layout.fragment_4_edit, container,false);
        //TextView txtFragment1 = Fragment4View.findViewById(R.id.fragment_4_edit);

        orderEditText = Fragment4View.findViewById(R.id.order);
        editCodeEditText = Fragment4View.findViewById(R.id.editCode);
        categorySpinner = Fragment4View.findViewById(R.id.spinnerCat);
        itemSpinner = Fragment4View.findViewById(R.id.spinnerCat1);

        btnSave = Fragment4View.findViewById(R.id.btnSave);
        btnDelete = Fragment4View.findViewById(R.id.btnDelete);
        outputTextView = Fragment4View.findViewById(R.id.Output);

        String[] categories = {"Frozen", "Grocery", "Produce"};
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = (String) parent.getItemAtPosition(position);
                // Based on selected category, populate item spinner with corresponding items
                populateItemSpinner(selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItem();
                displaySavedList();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();
                displaySavedList();
            }
        });

        database = getActivity().openOrCreateDatabase("ShoppingListDB", Context.MODE_PRIVATE, null);
        createTable();
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();



        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_4, container, false);

        return Fragment4View;
    }

    private void populateItemSpinner(String category) {
        String[] items;
        switch (category) {
            case "Frozen":
                items = new String[]{"vegetarian meat", "french fries", "frozen meals",
                        "frozen pizza", "frozen spices","frozen fruit",
                        "frozen vegetables","popsicles","ice cream","waffles"};
                break;
            case "Grocery":
                items = new String[]{"canned goods", "cereal", "chips", "gatorade",
                        "granola bars","pasta", "popcorn","sauce","seasoning","cooking oil"};
                break;
            case "Produce":
                items = new String[]{"apples", "avocados", "bananas", "broccoli",
                        "grapes","lettuce", "onion",
                        "orange","peppers","pineapple"};
                break;
            default:
                items = new String[]{"default"};
                break;
        }
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, items);
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(itemAdapter);
    }

    private void createTable() {
        database.execSQL("CREATE TABLE IF NOT EXISTS ShoppingList (OrderNumber TEXT, ProductQuantity TEXT, Category TEXT);");
    }

    private void saveItem() {
        String order = orderEditText.getText().toString();
        String code = editCodeEditText.getText().toString();
        String category = categorySpinner.getSelectedItem().toString();
        String item = itemSpinner.getSelectedItem().toString();

        ContentValues values = new ContentValues();
        values.put("OrderNumber", order);
        values.put("ProductQuantity", code);
        values.put("Category", category);
        //values.put("Item", item);
        long result = database.insert("ShoppingList", null, values);

        if (result  == -1){
            Toast.makeText(getActivity(), "Failed to save item.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Item saved successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteItem() {
        int result = database.delete("ShoppingList", null, null);

        if (result == 0) {
            Toast.makeText(getActivity(), "Failed to delete items.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Items deleted successfully", Toast.LENGTH_SHORT).show();
            outputTextView.setText("");
        }
    }

    @Override
    public void onDestroy() {
        if (database != null) {
            database.close();
        }
        super.onDestroy();
    }
    private void displaySavedList() {
        Cursor cursor = database.rawQuery("SELECT * FROM ShoppingList", null);

        if (cursor != null && cursor.moveToFirst()) {
            StringBuilder itemList = new StringBuilder();

            int orderIndex = cursor.getColumnIndex("OrderNumber");
            int quantityIndex = cursor.getColumnIndex("ProductQuantity");
            int categoryIndex = cursor.getColumnIndex("Category");
            int itemIndex = cursor.getColumnIndex("Item");

            do {
                if (orderIndex >= 0 && quantityIndex >= 0 && categoryIndex >= 0) {
                    String order = cursor.getString(orderIndex);
                    String quantity = cursor.getString(quantityIndex);
                    String category = cursor.getString(categoryIndex);
                    //String item = cursor.getString(itemIndex);
                    String item = "apples";

                    // Check if the itemIndex is valid before accessing the item value
                    if (itemIndex >= 0) {
                        item = cursor.getString(itemIndex);
                    }

                    itemList.append("Order: ").append(order).append(", ")
                            .append("Quantity: ").append(quantity).append(", ")
                            .append("Category: ").append(category).append(", ")
                            .append("Item: ").append(item).append("\n");
                }
            } while (cursor.moveToNext());

            outputTextView.setText(itemList.toString());
            cursor.close();
        } else {
            outputTextView.setText("No items saved yet.");
        }
    }

}
