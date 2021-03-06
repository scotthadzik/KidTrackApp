package edu.weber.cs3270.scotthadzik.kidtrackapp;


import android.app.Activity;
import android.app.ListFragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParentDashboardFragment extends ListFragment {

    private static PersonCustomAdapter adapter;
    private List<PersonRowItem> rowItems;
    Activity activity;

    CommunicationChannel mCommChListner = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_parent_dashboard, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        buildList();
        adapter = new PersonCustomAdapter(getActivity(), rowItems, ParentDashboardFragment.this);
        setListAdapter(adapter);
//        getListView().setOnItemClickListener(adapter.editButton);
    }

    public void buildList(){
        rowItems = new ArrayList<PersonRowItem>();


        List<Person> people = Person.getAllPeople();

        for (Person person: people){
            PersonRowItem items = new PersonRowItem(person.name, person.personType, person.getId());
            rowItems.add(items);
        }
    }

    public void editPerson(Person person){
        sendMessage(person);
    }

    interface CommunicationChannel
    {
        public void setCommunication(Person person);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if(activity instanceof CommunicationChannel)
        {
            mCommChListner = (CommunicationChannel)activity;
        }
        else
        {
            throw new ClassCastException();
        }

    }
    public void sendMessage(Person person)
    {
        Toast.makeText(getActivity(), "Person2 = " + person.name, Toast.LENGTH_LONG).show();
        mCommChListner.setCommunication(person);
    }

}
