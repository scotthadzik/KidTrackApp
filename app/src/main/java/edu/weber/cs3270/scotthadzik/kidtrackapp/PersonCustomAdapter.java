package edu.weber.cs3270.scotthadzik.kidtrackapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import at.markushi.ui.CircleButton;

/**
 * Created by Joe on 7/1/2015.
 */
public class PersonCustomAdapter extends BaseAdapter {
    Context context;
    List<PersonRowItem> rowItem;
    CircleButton editButton;

    PersonCustomAdapter(Context context, List<PersonRowItem> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.person_list_item, null);
        }

        TextView txtName = (TextView) convertView.findViewById(R.id.name);
        CircleButton deleteButton = (CircleButton) convertView.findViewById(R.id.deleteButton);
        editButton = (CircleButton) convertView.findViewById(R.id.editButton);


        final PersonRowItem row_pos = rowItem.get(position);
        // setting the name and position
        txtName.setText(row_pos.getName());
//        txtType.setText(row_pos.getType());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, row_pos.getName() + " was Deleted", Toast.LENGTH_LONG).show();
                removeItem(row_pos.getId(), getItemId(position));
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, row_pos.getName() + " was Edited", Toast.LENGTH_LONG).show();
                editItem(row_pos.getId(), getItemId(position));
            }
        });

        return convertView;

    }

    public void removeItem(int id, long position) {
        Person person = Person.load(Person.class, id);

        rowItem.remove((int) position);
        person.delete();
        this.notifyDataSetChanged();
    }

    public void editItem(int id, long position){
        Person person = Person.load(Person.class, id);
        ParentDashboardFragment parentDashboardFragment = new ParentDashboardFragment();
        parentDashboardFragment.editPerson(person);
    }


}
