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


/**
 * A simple {@link Fragment} subclass.
 */
public class EditPersonFragment extends Fragment {


    private EditText edtxtPersonName;
    private RadioGroup radioPersonType;
    private RadioButton radioPosition;
    private Button btnSavePerson;
    private View view;
    private MainActivity mainActivity;
    private Person person;


    public EditPersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_edit_person, container, false);

        mainActivity = (MainActivity) getActivity();

        edtxtPersonName = (EditText) view.findViewById(R.id.edtxtPersonName);
        radioPersonType = (RadioGroup) view.findViewById(R.id.radioPersonType);
        btnSavePerson = (Button) view.findViewById(R.id.btnSavePerson);

        // Inflate the layout for this fragment
        return view;
    }

    public void setPerson(Person person){
        this.person = person;
//        edtxtPersonName.setText(person.name);
    }

}
