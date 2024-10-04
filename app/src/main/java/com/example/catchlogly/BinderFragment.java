package com.example.catchlogly;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BinderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BinderFragment extends Fragment {
    Button test;
    TextInputLayout note;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_binder, container, false);

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
        return view;

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_binder, container, false);
    }

    private void createNoteView(final Note note) {
        View noteView = getLayoutInflater().inflate(R.layout.note_item,null);
        //TextView titleTextView = noteView.findViewById(R.id.titleTextView);
        //TextView contentTextView = noteView.findViewById(R.id.contentTextView);
        //TextView dateView = noteView.findViewById(R.id.dateTextView);


        //titleTextView.setText(note.getTitle());
        //contentTextView.setText(note.getContent());
        //dateView.setText(note.getDate());




//        noteView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                showDeleteDialog(note);
//                return true;
//            }
//        });

//        notesContainer.addView(noteView);
    }








    //dont delete below
}