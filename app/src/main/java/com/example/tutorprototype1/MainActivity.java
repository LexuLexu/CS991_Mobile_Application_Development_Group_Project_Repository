package com.example.tutorprototype1;

// RACHELS TEST COMMENT

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    // test comment

    private TextView emailEntry;
    private TextView passwordEntry;

    private String[] emailAddresses;
    private String[] passwords;

    private LinkedHashMap<String, String> loginMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEntry = findViewById(R.id.emailInput);
        passwordEntry = findViewById(R.id.passwordInput);

        emailAddresses = this.getResources().getStringArray(R.array.emailAddresses);
        passwords = this.getResources().getStringArray(R.array.passwords);

        loginMap = new LinkedHashMap<>();

        for (int i = 0; i < Math.min(emailAddresses.length, passwords.length); i++) {
            loginMap.put(emailAddresses[i], passwords[i]);
        }

        ImageView passToggle = findViewById(R.id.passVisibleToggle);

        passToggle.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        passwordEntry.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        passwordEntry.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }
        });
}

    public void login_action(View view) {

        String inputtedEmail = emailEntry.getText().toString();
        String inputtedPassword = passwordEntry.getText().toString();

        if (loginMap.containsKey(inputtedEmail)) {

            if (loginMap.get(inputtedEmail).equals(inputtedPassword)) {

                System.out.println("Password matches");

                Intent loginIntent = new Intent(MainActivity.this, MainPageActivity.class);
                MainActivity.this.startActivity(loginIntent);
                return;

            }
        }
        showLoginError();
    }

    private void showLoginError() {

        EditText errorEmail = findViewById(R.id.emailInput);
        EditText errorPassword = findViewById(R.id.passwordInput);

        errorEmail.startAnimation(shakeError());
        errorPassword.startAnimation(shakeError());

        errorEmail.setError("Incorrect username or password");
        errorPassword.setError("Incorrect username or password");

        System.out.println("Incorrect username or password");

    }

    public TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 8, 0, 0);
        shake.setDuration(400);
        shake.setInterpolator(new CycleInterpolator(5));
        return shake;
    }

    public void register_action(View view) {

        Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
        MainActivity.this.startActivity(registerIntent);
        return;

    }

}

// hi


