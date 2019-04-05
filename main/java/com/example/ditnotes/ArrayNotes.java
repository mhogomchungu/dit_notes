package com.example.ditnotes;

import java.util.ArrayList;

public class ArrayNotes implements Notes.notes {

    private ArrayList<NoteEntry> notes = new ArrayList<>();

    ArrayNotes() {
        notes.add(new NoteEntry("title 1", "body 1"));
        notes.add(new NoteEntry("title 2", "body 2"));
        notes.add(new NoteEntry("title 3", "body 3"));
        notes.add(new NoteEntry("title 4", "body 4"));
    }

    class NoteEntry {
        String title;
        String body;
        NoteEntry(String title, String body) {
            this.title = title;
            this.body = body;
        }
    }

    public static ArrayNotes instance(){
        return new ArrayNotes();
    }
    @Override
    public void addNote(String title, String body) {
        notes.add(new NoteEntry(title, body));
    }

    @Override
    public String getNote(String title) {
        for (NoteEntry e : notes) {
            if (e.title.equals(title)) {
                return e.body;
            }
        }
        return null;
    }

    @Override
    public void deleteNote(String title) {
        for (NoteEntry e : notes) {
            if (e.title.equals(title)) {
                notes.remove(e);
                break;
            }
        }
    }

    @Override
    public ArrayList<String> getTitles() {
        ArrayList<String> s = new ArrayList<>();
        for (NoteEntry e : notes) {
            s.add(e.title);
        }
        return s;
    }
}
