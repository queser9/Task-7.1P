package com.example.lostandfoundapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class CreateAdvertActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        dbHelper = new DatabaseHelper(this);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final EditText editName = findViewById(R.id.edit_name);
        final EditText editPhone = findViewById(R.id.edit_phone);
        final EditText editDescription = findViewById(R.id.edit_description);
        final EditText editDate = findViewById(R.id.edit_date);
        final EditText editLocation = findViewById(R.id.edit_location);
        Button saveButton = findViewById(R.id.btn_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String type = selectedRadioButton.getText().toString();
                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();
                String description = editDescription.getText().toString();
                String date = editDate.getText().toString();
                String location = editLocation.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_TYPE, type);
                values.put(DatabaseHelper.COLUMN_NAME, name);
                values.put(DatabaseHelper.COLUMN_PHONE, phone);
                values.put(DatabaseHelper.COLUMN_DESCRIPTION, description);
                values.put(DatabaseHelper.COLUMN_DATE, date);
                values.put(DatabaseHelper.COLUMN_LOCATION, location);

                long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);
                if (newRowId != -1) {
                    Toast.makeText(CreateAdvertActivity.this, "Advert saved", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CreateAdvertActivity.this, "Error saving advert", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
