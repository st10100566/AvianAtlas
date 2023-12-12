package com.example.Howler1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfile extends AppCompatActivity {
    TextInputLayout fullName, username,  email, password;
    TextView fullNameLabel, usernameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_profile);

        fullName = findViewById(R.id.full_name_profile);
        username = findViewById(R.id.username_profile);
        email = findViewById(R.id.email_profile);
        password = findViewById(R.id.password_profile);
        fullNameLabel = findViewById(R.id.full_name);
        usernameLabel = findViewById(R.id.username_label);

        showAllUserData();

    }

    private void showAllUserData() {
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("name");
        String user_username = intent.getStringExtra("username");
        String user_email = intent.getStringExtra("email");
        String user_password = intent.getStringExtra("password");

        fullNameLabel.setText(user_name);
        usernameLabel.setText(user_username);
        fullName.getEditText().setText(user_name);
        username.getEditText().setText(user_username);
        email.getEditText().setText(user_email);
        password.getEditText().setText(user_password);

    }
}