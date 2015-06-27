package edu.weber.cs3270.scotthadzik.kidtrackapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;


public class AddTaskActivity extends ActionBarActivity {

    public static final String KEY_URL = "url";
    public static final String KEY_NOTES = "notes";
    public static final String POSTS = "Post";

    protected EditText mUrlField;
    protected EditText mNotesField;
    protected Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_link);

        mUrlField = (EditText) findViewById(R.id.editText1);
        mNotesField = (EditText) findViewById(R.id.editText2);
        mSaveButton = (Button) findViewById(R.id.button1);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mUrlField.getText().toString();
                String notes = mNotesField.getText().toString();

                if (!url.equals("")) {
					/*
					 * Save Post ParseObject
					 */
                    ParseObject post = new ParseObject(POSTS);
                    post.put(KEY_URL, url);
                    post.put(KEY_NOTES, notes);
                    post.saveInBackground();

                    finish();
                }
            }
        });
    }
}
