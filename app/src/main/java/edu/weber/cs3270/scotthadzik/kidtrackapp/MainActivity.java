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
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends ActionBarActivity {

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

//        fragmentManager = getFragmentManager();


        Log.d("test", "back stack count before onCreate = " + getFragmentManager().getBackStackEntryCount());

        Log.d("test", "fragment Container " + fragmentContainer);


        getFragmentManager().beginTransaction()
                .add(fragmentContainer, parentDashboardFragment, "PDF")

                .commit();

        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fr = getFragmentManager().findFragmentById(fragmentContainer);

                if (fr != null) {
                    Log.d("test", "Back stack listenerfragment= " + fr.getClass().getName());
                } else {
                    Log.d("test", "null");
                }
            }

        });

        Log.d("test", "back stack count after onCreate = " + getFragmentManager().getBackStackEntryCount());


    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("test", "back stack count in OnResume = " + getFragmentManager().getBackStackEntryCount());
//        getLatestPosts();
    }

//    protected void getLatestPosts() {
//        mProgressBar.setVisibility(View.VISIBLE);
//
//		/*
//		 * Use ParseQuery to get latest posts
//		 */
//        ParseQuery query = new ParseQuery(AddLinkActivity.POSTS);
//        query.setLimit(100);
//        query.orderByDescending("createAt");
//        query.findInBackground(new FindCallback() {
//            public void done(List<ParseObject> results, ParseException e) {
//                mProgressBar.setVisibility(View.INVISIBLE);
//
//                if (e == null) {
//                    ArrayList<HashMap<String, String>> articles = new ArrayList<HashMap<String, String>>();
//                    for (ParseObject result : results) {
//                        HashMap<String, String> article = new HashMap<String, String>();
//                        article.put(AddLinkActivity.KEY_NOTES,
//                                result.getString(AddLinkActivity.KEY_NOTES));
//                        article.put(AddLinkActivity.KEY_URL,
//                                result.getString(AddLinkActivity.KEY_URL));
//                        articles.add(article);
//                    }
//                    SimpleAdapter adapter = new SimpleAdapter(
//                            MainActivity.this, articles,
//                            android.R.layout.simple_list_item_2, new String[] {
//                            AddLinkActivity.KEY_NOTES,
//                            AddLinkActivity.KEY_URL }, new int[] {
//                            android.R.id.text1, android.R.id.text2 });
//                    setListAdapter(adapter);
//                } else {
//                    Log.e(TAG, "Exception caught!", e);
//                }
//            }
//        });
//    }

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        TextView urlLabel = (TextView) v.findViewById(android.R.id.text2);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse(urlLabel.getText().toString()));
//        startActivity(intent);
//    }

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
                Log.d("test", "in add button back stack count = " + getFragmentManager().getBackStackEntryCount());
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

        Log.d("test", "back stack count = " + getFragmentManager().getBackStackEntryCount());

        Fragment oldFragment = getFragmentManager().findFragmentById(fragmentContainer);

        Log.d("test", "old Fragment = " + oldFragment);
        Log.d("test", "Old Fragment Tag = " + oldFragment.getTag());
        Log.d("test", "New Fragment = " + fragment);
        Log.d("test", "New Fragment Tag = " + fragmentTag);

        for (int i = 0; i < getFragmentManager().getBackStackEntryCount(); i++) {
            Log.d("test", "Stack = " + getFragmentManager().getBackStackEntryAt(i).getId());
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.hide(oldFragment);
        ft.add(fragmentContainer, fragment, fragmentTag);
        ft.commit();


        for (int i = 0; i < getFragmentManager().getBackStackEntryCount(); i++) {
            Log.d("test", "Stack = " + getFragmentManager().getBackStackEntryAt(i).getId());
        }

        Log.d("test", "back stack count after replace = " + getFragmentManager().getBackStackEntryCount());
    }
}
