package edu.andrews.cptr252.keatoncouncell.myfragmentslabexample;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class shopping_list_class extends AppCompatActivity {
    private EditText orderEditText;
    private EditText editCodeEditText;
    private Spinner spinnerCat;
    private Button btnSave;
    private Button btnDelete;
    private TextView outputTextView;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);

        orderEditText = findViewById(R.id.order);
        editCodeEditText = findViewById(R.id.editCode);
        spinnerCat = findViewById(R.id.spinnerCat);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        outputTextView = findViewById(R.id.Output);

        database = openOrCreateDatabase("ShoppingListDB", MODE_PRIVATE, null);
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
            Toast.makeText(this, "Failed to save item.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this."Item saved successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteItem() {
        int result = database.delete("ShoppingList", null, null);

        if (result == 0){
            Toast.makeText(this, "Failed to delete items.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Items deleted successfully", Toast.LENGTH_SHORT).show();
            outputTextView.setText("");
        }
    }
    @Override
    protected void onDestroy(){
        if (database != null){
            database.close();
        }
        super.onDestroy();
    }

}
