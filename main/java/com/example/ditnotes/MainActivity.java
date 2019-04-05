package com.example.ditnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkActivity = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(linkActivity);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, button2);

                Menu menu = popupMenu.getMenu();

                ArrayList<String> arrayList = Notes.instance().getTitles();
                for (String string : arrayList){
                    menu.add(string);
                }

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem i1) {

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
/* Intent linkActivity = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(linkActivity);*/

   /* MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.uppop, menu);
                return true;*/

   /* */