package com.example.catchlogly;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import java.time.LocalDate;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeskFragment extends Fragment {
    Button bind;
    String testDate1 = "2024-10-03";

    boolean inLogly = false;

    private ItemViewModel viewModel; //to access condition Catch or Log

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
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_desk, container, false);

        //Set up the listener to receive data from BinderFragment (Fragment to Fragment)
        getParentFragmentManager().setFragmentResultListener("dataFromBinder", this,
                new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(String requestKey, Bundle result) {
                        // Retrieve the string from the Bundle
                        String receivedNote = result.getString("editNote");

                        // Find the TextInputLayout (or any view) and set the text
                        TextInputLayout note = view.findViewById(R.id.note);
                        if (note.getEditText() != null) {
                            note.getEditText().setText(receivedNote); // Update the EditText with the received message
                        }
                    }
        });

        bind = (Button) view.findViewById(R.id.Bind);
        TextInputLayout noteLine = (TextInputLayout) view.findViewById(R.id.note);
        EditText titleLine = (EditText) view.findViewById(R.id.titleLine);
        //method to store note
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = String.valueOf(noteLine.getEditText().getText());
                String title = String.valueOf(titleLine.getText());
                Note toStore = new Note(inLogly, content, testDate1, title);

                
            }
        });
        return view;
        //return inflater.inflate(R.layout.fragment_desk, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize viewModel to collect data from Main Activity (passed through Intents)
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);


        // Collect what string from MainActivity2 (passed through Intents)
        viewModel.getSelectedString().observe(getViewLifecycleOwner(), label -> {
            TextInputLayout editText = (TextInputLayout) view.findViewById(R.id.note);
            //TextView date = (TextView) view.findViewById(R.id.date);
            //date.setText("Note");

            if(label.equals("Log.ly")){

                editText.setHint("I am thankful for ");
                inLogly = true;
            }
            else editText.setHint("I had this dream where ");
            if(!editText.getEditText().getText().equals(""))editText.setHint(label);
        });



    }

//    public void bind(View V){
//        //Button bind = (Button) V.findViewById(R.id.Bind);
//        V.setEnabled(false);
//    }
}