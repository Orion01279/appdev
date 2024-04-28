package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment_class_4 extends Fragment {
    private EditText orderEditText;
    private EditText editCodeEditText;
    private Spinner spinnerCat;
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
        spinnerCat = Fragment4View.findViewById(R.id.spinnerCat);
        btnSave = Fragment4View.findViewById(R.id.btnSave);
        btnDelete = Fragment4View.findViewById(R.id.btnDelete);
        outputTextView = Fragment4View.findViewById(R.id.Output);

        database = getActivity().openOrCreateDatabase("ShoppingListDB", Context.MODE_PRIVATE, null);
        createTable();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItem();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();
            }
        });
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();



        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_class_4, container, false);

        return Fragment4View;
    }
    private void createTable() {
        database.execSQL("CREATE TABLE IF NOT EXISTS ShoppingList (OrderNumber TEXT, ProductQuantity TEXT, Category TEXT);");
    }

    private void saveItem() {
        String order = orderEditText.getText().toString();
        String code = editCodeEditText.getText().toString();
        String category = spinnerCat.getSelectedItem().toString();

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


}
