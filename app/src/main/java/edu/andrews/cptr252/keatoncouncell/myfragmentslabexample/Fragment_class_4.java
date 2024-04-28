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
                items = new String[]{"canned goods", "cereal", "chips", "gatorade", "granola bars","pasta", "popcorn","sauce","seasoning","cooking oil"};
                break;
            case "Produce":
                items = new String[]{"apples", "avocados", "bananas", "broccoli",
                        "grapes","lettuce", "onion",
                        "orange","peppers","pineapple"};
                break;
            default:
                items = new String[]{};
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

        ContentValues values = new ContentValues();
        values.put("OrderNumber", order);
        values.put("ProductQuantity", code);
        values.put("Category", category);
        long result = database.insert("ShoppingList", null, values);

        if (result  == -1){
            Toast.makeText(getActivity(), "Failed to save item.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Item saved successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteItem() {
        // Your deleteItem() implementation
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
        // Query your database to retrieve the saved items
        Cursor cursor = database.rawQuery("SELECT * FROM ShoppingList", null);

        // Check if the cursor is not null and has data
        if (cursor != null && cursor.moveToFirst()) {
            StringBuilder itemList = new StringBuilder();

            // Iterate through the cursor to retrieve each item
            do {
                String order = cursor.getString(cursor.getColumnIndex("OrderNumber"));
                String quantity = cursor.getString(cursor.getColumnIndex("ProductQuantity"));
                String category = cursor.getString(cursor.getColumnIndex("Category"));

                // Append the item details to the itemList StringBuilder
                itemList.append("Order: ").append(order).append(", ")
                        .append("Quantity: ").append(quantity).append(", ")
                        .append("Category: ").append(category).append("\n");

            } while (cursor.moveToNext());

            // Set the formatted list to the TextView
            outputTextView.setText(itemList.toString());

            // Close the cursor
            cursor.close();
        } else {
            // If there are no saved items, display a message
            outputTextView.setText("No items saved yet.");
        }
    }



}
