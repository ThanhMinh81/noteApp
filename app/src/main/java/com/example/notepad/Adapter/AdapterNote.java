package com.example.notepad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.Model.Note;
import com.example.notepad.R;

import java.util.ArrayList;

public class AdapterNote extends  RecyclerView.Adapter<AdapterNote.ViewHolder> {

    private ArrayList<Note> noteArrayList ;
    private Context context ;


    public AdapterNote(ArrayList<Note> noteArrayList, Context context) {
        this.noteArrayList = noteArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

          Note note = noteArrayList.get(position);
          holder.tvTitle.setText(note.getTitle());
          holder.tvContent.setText(note.getTimeEdit());

    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

          public TextView tvTitle , tvContent ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvTime);

        }
    }
}
