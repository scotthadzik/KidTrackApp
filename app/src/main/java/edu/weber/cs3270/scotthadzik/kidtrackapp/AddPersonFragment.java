package edu.weber.cs3270.scotthadzik.kidtrackapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddPersonFragment extends Fragment {


    private EditText edtxtPersonName;
    private RadioGroup radioPersonType;
    private RadioButton radioPosition;
    private Button btnSavePerson;
    private View view;


    public AddPersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_person, container, false);

        edtxtPersonName = (EditText) view.findViewById(R.id.edtxtPersonName);
        radioPersonType = (RadioGroup) view.findViewById(R.id.radioPersonType);
        btnSavePerson = (Button) view.findViewById(R.id.btnSavePerson);

        addSaveButtonListener();

        return view;
    }

    public void addSaveButtonListener(){
        btnSavePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = radioPersonType.getCheckedRadioButtonId();
                radioPosition = (RadioButton) view.findViewById(selectedID);

                Toast.makeText(getActivity(), "Type " + radioPosition.getText() , Toast.LENGTH_LONG).show();

                Person newPerson = new Person();
                newPerson.name = edtxtPersonName.getText().toString();
                newPerson.personType = radioPosition.getText().toString();
                newPerson.save();

                List<Person> people = newPerson.getAllPeople();

                for (Person person: people){
                    Toast.makeText(getActivity(), "name" + person.name + " type " + person.personType , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
