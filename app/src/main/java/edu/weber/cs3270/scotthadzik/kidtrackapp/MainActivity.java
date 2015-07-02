package edu.weber.cs3270.scotthadzik.kidtrackapp;


import android.app.Activity;
import android.app.Fragment;
import android.app.ActionBar;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseUser;

import at.markushi.ui.CircleButton;

public class MainActivity extends ActionBarActivity{

    //Fragments
    private ParentDashboardFragment parentDashboardFragment;
    private AddPersonFragment addPersonFragment;
    private TaskListFragment taskListFragment;
    FragmentManager fragmentManager;

    //Fragment classe names
    private String addPersonFragmentName;

    //Containers
    private int fragmentContainer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragments
        parentDashboardFragment = new ParentDashboardFragment();
        addPersonFragment = new AddPersonFragment();
        taskListFragment = new TaskListFragment();

        //Fragment class names
        addPersonFragmentName = addPersonFragment.getClass().getName();

        //Containers
        fragmentContainer = R.id.fragmentContainer;

        if (savedInstanceState != null)
            return;
        setFragment(parentDashboardFragment);
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentById(fragmentContainer) == null) {
            fragmentManager.beginTransaction()
                    .add(fragmentContainer, fragment)
                    .commit();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addButton:
                addPersonFragment = new AddPersonFragment();
                replaceFragment(addPersonFragment);
                return true;
            case R.id.logoutButton:
            /*
             * Log current user out using ParseUser.logOut()
			 */
                ParseUser.logOut();
                Intent intent = new Intent(this, LoginOrSignupActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void replaceFragment(Fragment fragment) {

        String fragmentTag = fragment.getClass().getName();
        Fragment oldFragment = getFragmentManager().findFragmentById(fragmentContainer);
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.hide(oldFragment);
        ft.add(fragmentContainer, fragment, fragmentTag);
        ft.commit();

    }

    public void personAdded() {
        parentDashboardFragment = new ParentDashboardFragment();
        replaceFragment(parentDashboardFragment);
    }

    public void refreshList() {

//        ParentDashboardFragment tempFrag = new ParentDashboardFragment();
//        getFragmentManager().beginTransaction()
//                .replace(fragmentContainer, tempFrag)
//                .commit();
    }

//    public void editPerson(Person person){
//        EditPersonFragment editPersonFragment = new EditPersonFragment();
//        editPersonFragment.setPerson(person);
//        getFragmentManager().beginTransaction()
//                .replace(fragmentContainer, editPersonFragment)
//                .commit();
//    }

}
