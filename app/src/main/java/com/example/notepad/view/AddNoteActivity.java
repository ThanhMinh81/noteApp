package com.example.notepad.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.notepad.Database.DBManager;
import com.example.notepad.Model.Note;
import com.example.notepad.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    Toolbar toolbar ;
    EditText edTitle , edContent ;
    TextView tvSave ;
    DBManager databaseHandler ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        databaseHandler = new DBManager(this);
        databaseHandler.open();

        edTitle = findViewById(R.id.edTitleNote);
        edContent = findViewById(R.id.edContentNote);
        tvSave = this.<TextView>findViewById(R.id.saveNote);

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String s =  dateFormat.format(date) ;

                Note note = new Note();
                note.setTitle(edTitle.getText().toString());
                note.setContent(edContent.getText().toString());
                note.setTimeEdit(s.toString());

                databaseHandler.addNote(note);
                finish();


            }
        });



    }
}
