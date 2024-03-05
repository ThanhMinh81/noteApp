package com.example.notepad.Model;

public class Note {


    int idNote ;
    String title ;
    String content ;
    String timeEdit ;

    public Note() {
    }

    public Note(int idNote, String title, String content, String timeEdit) {
        this.idNote = idNote;
        this.title = title;
        this.content = content;
        this.timeEdit = timeEdit;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeEdit() {
        return timeEdit;
    }

    public void setTimeEdit(String timeEdit) {
        this.timeEdit = timeEdit;
    }

}
