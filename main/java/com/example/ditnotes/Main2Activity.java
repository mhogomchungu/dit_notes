package com.example.ditnotes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    String Tablename = "MY_NOTES";

    TextView textView;
    TextView textView2;
    EditText editText;
    EditText editText2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String path = Main2Activity.this.getFilesDir().getAbsolutePath() + "/MYSQL.sqlite";

                SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(path, null);

                String string = String.format("Create table if not exists %s (NOTES TEXT)", Tablename);
                sqLiteDatabase.execSQL(string);

                String str = writeNotes(editText.getText().toString());

                sqLiteDatabase.execSQL(str);
            }
            String writeNotes (String notes){

                return String.format("insert into %s (NOTES) values (\"%s\")", Tablename, notes);
            }
        });
    }

}
//  BufferedWriter bufferedWriter = new BufferedWriter();
 //   SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
   // ContentValues contentValues = new ContentValues();