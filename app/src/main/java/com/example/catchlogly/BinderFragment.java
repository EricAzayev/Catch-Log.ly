package com.example.catchlogly;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BinderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BinderFragment extends Fragment {
    private String label;
    private static final String KEY_NOTE_COUNT = "NoteCount";
    private LinearLayout notesContainer;

    //private String PREFS_NAME = "MyPrefs";
    private static final String KEY_NOTE_LIST = "NoteList";
    private List<Note> noteList = new ArrayList<>();
    Button test, test2;
    TextInputLayout note;
    private ItemViewModel viewModel;

    String toPass = "passed";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BinderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BinderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BinderFragment newInstance(String param1, String param2) {
        BinderFragment fragment = new BinderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    private void displayNotes() {
        for (Note note : noteList) {
            createNoteView(note);
        }
    }
    private void showEditDialog(Note note){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity()); //.this if in MainActivity
        builder.setTitle("Edit this note");
        builder.setMessage("Are you sure you want to edit this note?");
        builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Bundle fsSuccess = new Bundle(); //fs = fragment sent

                String title = note.getTitle(); //temp string for note to edit.
                String content = note.getContent();
                String date = note.getDate();

                fsSuccess.putString("editTitle", title); //bundle has many keys
                fsSuccess.putString("editContent", content);
                fsSuccess.putString("editDate", date);
                getParentFragmentManager().setFragmentResult("editUpload", fsSuccess); //Will be accessed in order of BundleKey -> ItemKey returns Item
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
    //private void sendNoteToDesk(){}


    private void loadNotesFromPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(label, Context.MODE_PRIVATE);
        int noteCount = sharedPreferences.getInt(KEY_NOTE_COUNT, 0);

        for (int i = 0; i < noteCount; i++) {
            String title = sharedPreferences.getString("note_title_" + i, "");
            String content = sharedPreferences.getString("note_content_" + i, "");
            String date = sharedPreferences.getString("date_content_" + i, "");

            Note note = new Note(title, content, date);
            note.setTitle(title);
            note.setContent(content);

            noteList.add(note);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_binder, container, false);
        notesContainer = view.findViewById(R.id.notesContainer);
        notesContainer.removeAllViews();
        loadNotesFromPreferences();
        displayNotes();


        test = (Button) view.findViewById(R.id.test); //I can define buttons from other activities
        //TextInputLayout editText = (TextInputLayout) view.findViewById(R.id.note);
        test.setOnClickListener(new View.OnClickListener() { //This button allows users to edit past notes
            @Override
            public void onClick(View v) {
                Bundle fsSuccess = new Bundle(); //fs = fragment sent

                String editNote = "Message sent successfully"; //temp string for note to edit.

                fsSuccess.putString("editNote", editNote); //bundle has many keys
                getParentFragmentManager().setFragmentResult("dataFromBinder", fsSuccess); //Will be accessed in order of BundleKey -> ItemKey returns Item


            }
        });
        test2 = (Button) view.findViewById(R.id.test2);
        //TextView testView = (TextView) view.findViewById(R.id.testView);
        test2.setOnClickListener(new View.OnClickListener() { //Test loading preferences
            @Override //temporary button
            public void onClick(View v) {
                notesContainer.removeAllViews();
                displayNotes();
                test2.setText(Integer.toString(noteList.size()));
//                for(Note g: noteList){
//
//                }
            }

        });
        loadNotesFromPreferences();
        displayNotes();
        //TextView testView = (TextView) view.findViewById(R.id.testView);
        //testView.setText("TestTestTest");


        return view;

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_binder, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        loadNotesFromPreferences(); //step 1 to show notes
        displayNotes(); //step 2 to show notes

        // Initialize viewModel to collect data from Main Activity (passed through Intents)
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);


        // Collect what string from MainActivity2 (passed through Intents)
        viewModel.getSelectedString().observe(getViewLifecycleOwner(), label -> {
            //TextInputLayout editText = (TextInputLayout) view.findViewById(R.id.note);
            //TextView date = (TextView) view.findViewById(R.id.date);
            //date.setText("Note");
            this.label = label;
        });
//        TextView testView = (TextView) view.findViewById(R.id.testView);
//        testView.setText("TestTestTest");

    }

    private void createNoteView(final Note note) {
        View noteView = getLayoutInflater().inflate(R.layout.note_item,null);
        TextView titleTextView = noteView.findViewById(R.id.titleTextView);
        TextView contentTextView = noteView.findViewById(R.id.contentTextView);
        TextView dateView = noteView.findViewById(R.id.dateTextView);


        titleTextView.setText(note.getTitle());
        contentTextView.setText(note.getContent());
        dateView.setText(note.getDate());
        noteView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {  //adds feature for if a note is clicked for a while (edit note)
                showEditDialog(note);
                return true;
            }
        });
        notesContainer.addView(noteView);
    }








    //dont delete below
}