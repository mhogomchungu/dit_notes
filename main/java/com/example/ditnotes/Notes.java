package com.example.ditnotes;

import java.util.ArrayList;

public class Notes {

    public interface notes {

        void addNote(String title,String body);

        String getNote(String title);

        void deleteNote(String title);

        ArrayList<String> getTitles();
    }

    enum ENGINE {MEMORY, SQLITE}

    private static notes NOTES = null;

    static boolean useMemoryStorage(){
        return true;
    }
    public static notes instance() {

        if(useMemoryStorage()){
            return instance(ENGINE.MEMORY);
        }else{
            return instance(ENGINE.SQLITE);
        }
    }

    public static notes instance(ENGINE e) {

        if(NOTES == null){
            if (e == ENGINE.MEMORY) {
                NOTES = ArrayNotes.instance();
            } else if( e == ENGINE.SQLITE){
                NOTES = SqliteNotes.instance();
            }
        }
        return NOTES;
    }
}