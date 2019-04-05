package com.example.ditnotes;

import java.util.ArrayList;

public class SqliteNotes implements Notes.notes  {

    public static SqliteNotes instance(){
        return new SqliteNotes();
    }
    @Override
    public void addNote(String title, String body) {

    }

    @Override
    public String getNote(String title) {
        return null;
    }

    @Override
    public void deleteNote(String title) {

    }

    @Override
    public ArrayList<String> getTitles() {
        return null;
    }
}
