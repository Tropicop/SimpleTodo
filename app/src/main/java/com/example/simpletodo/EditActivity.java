package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    EditText et_item;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        et_item = findViewById(R. id.et_item);
        btn_save = findViewById(R. id.btn_save);

        getSupportActionBar().setTitle("Edit item");

        et_item.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an intent which will contain the results
                Intent intent = new Intent();

                //Pass the data (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, et_item.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //Set the result of the intent
                setResult(RESULT_OK, intent);

                //Finish activity, close the screen and go back
                finish();
            }
        });
    }
}
