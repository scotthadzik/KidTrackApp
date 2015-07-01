package edu.weber.cs3270.scotthadzik.kidtrackapp;


import android.app.ListFragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.app.Fragment;
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
public class ParentDashboardFragment extends ListFragment{//} implements AdapterView.OnItemClickListener{

    private static PersonCustomAdapter adapter;
    private List<PersonRowItem> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_parent_dashboard, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);



        buildList();

        adapter = new PersonCustomAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
//        getListView().setOnItemClickListener(this);
    }

    public void buildList(){
        rowItems = new ArrayList<PersonRowItem>();


        List<Person> people = Person.getAllPeople();

        for (Person person: people){
            PersonRowItem items = new PersonRowItem(person.name, person.personType, person.getId());
            rowItems.add(items);
        }
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//    }

    public static void refreshList(){
        adapter.notifyDataSetChanged();
    }




}
