package com.example.catchlogly;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeskFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeskFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeskFragment newInstance(String param1, String param2) {
        DeskFragment fragment = new DeskFragment();
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

        Intent intent = getActivity().getIntent();
        String title_text = intent.getStringExtra("title");

        Date today = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        View view = inflater.inflate(R.layout.fragment_desk, container, false);

        TextView noteTextView = view.findViewById(R.id.note);
        noteTextView.setText("Note " + dateFormat.format(today));

        return view;





        //return inflater.inflate(R.layout.fragment_desk, container, false);
    }

    public void bind(View view){
        Button bind = (Button) view.findViewById(R.id.bind);
        bind.setEnabled(false);

    }







}