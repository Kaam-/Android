package com.Goals.Test.Activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Goals.Test.DataClasses.User;
import com.Goals.Test.MainActivity;
import com.Goals.Test.R;
import com.Goals.Test.SteveTheFetcher.Fetcher;

import java.util.Calendar;

/**
 * Created by Drew on 1/19/14.
 */
public class SignUpActivity extends Activity {

    private EditText name, email, password;
    private Button signup, facebook, twitter;
    private Fetcher steve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signUpButton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        steve = new Fetcher(getApplicationContext());

        ActionBar actionBar = getActionBar();
        actionBar.hide();
    }

    public void twitterButton(View v)
    {
        createAccountWithTwitter();
    }

    public void facebookButton(View v)
    {
        createAccountWithFacebook();
    }

    public void createUser()
    {
        String[] names = name.getText().toString().split(" ");
        User user = new User(names[0], names[1], "", "", password.getText().toString(), email.getText().toString(), 0, 0, 0, Calendar.getInstance().getTime().toString(), Calendar.getInstance().getTime().toString());
        User user2 = steve.setUser(user);
        Intent gotoMain = new Intent(this, MainActivity.class);
        startActivity(gotoMain);
    }

    private void createAccountWithFacebook() {
        Toast.makeText(getApplicationContext(), "Creating account from facebook", Toast.LENGTH_SHORT).show();

    }

    private void createAccountWithTwitter() {
        Toast.makeText(getApplicationContext(), "Creating account from twitter", Toast.LENGTH_SHORT).show();
    }
}
