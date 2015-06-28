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
public class TaskListFragment extends ListFragment implements AdapterView.OnItemClickListener {


    String[] menutitles;
    TypedArray menuIcons;

    TaskCustomAdapter adapter;
    private List<TaskRowItem> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_task_list, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.taskTitles);
        menuIcons = getResources().obtainTypedArray(R.array.taskIcons);

        rowItems = new ArrayList<TaskRowItem>();

        for (int i = 0; i < menutitles.length; i++) {
            TaskRowItem items = new TaskRowItem(menutitles[i], menuIcons.getResourceId(
                    i, -1));

            rowItems.add(items);
        }

        adapter = new TaskCustomAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
                .show();

    }

}
