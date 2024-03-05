package com.example.notepad.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.Adapter.AdapterNote;
import com.example.notepad.ViewModel.DataViewModel;
import com.example.notepad.Interface.IData;
import com.example.notepad.Model.Note;
import com.example.notepad.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private   View view ;
    private RecyclerView rcvHome ;
    private ArrayList<Note> notes ;
    private AdapterNote apdaterNote ;
    IData iData ;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view =inflater.inflate(R.layout.fragment_home, container, false);

        notes = new ArrayList<>();
        apdaterNote = new AdapterNote(notes,getContext());
        rcvHome = view.findViewById(R.id.rcvHome);

        rcvHome.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvHome.setAdapter(apdaterNote);
        apdaterNote.notifyDataSetChanged();

        DataViewModel dataViewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);

        dataViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Note>>() {
             @Override
             public void onChanged(ArrayList<Note> noteArrayList) {
                 Log.d("fasdfas",noteArrayList.size() + " ");
                 notes.clear();
                 notes.addAll(noteArrayList);
                 apdaterNote.notifyDataSetChanged();
             }
         });




        return view;

    }

    public void getData(List<Note> noteArrayList)
    {
         noteArrayList.addAll(noteArrayList);
         apdaterNote.notifyDataSetChanged();
    }



}
