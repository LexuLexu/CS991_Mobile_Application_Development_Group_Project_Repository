package com.example.tutorprototype1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {

    private String[] emailAddresses;

    private EditText pass1;
    private EditText pass2;

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        pass1 = findViewById(R.id.passwordInput);
        pass2 = findViewById(R.id.passwordConfirm);

        ImageView passToggle = findViewById(R.id.passVisibleToggle);

        dbHandler = new MyDBHandler(this, null, null, 1);

        passToggle.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        pass1.setInputType(InputType.TYPE_CLASS_TEXT);
                        pass2.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        pass1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }
        });
    }

    public void registerButton(View view) {

        if (isEmailValid() && isEmailUni() && doPasswordsMatch() && isEmailAvailable() && isNameEntered() && isCitySelected()) {

            EditText emailView = findViewById(R.id.emailInput);
            String inputEmail = emailView.getText().toString();
            EditText passView = findViewById(R.id.passwordInput);
            String inputPass = passView.getText().toString();

            Account newAccount = new Account(inputEmail, inputPass);
            dbHandler.addAccount(newAccount);
            System.out.println(dbHandler.databaseToString());

            Intent loginIntent = new Intent(RegisterActivity.this, MainPageActivity.class);
            RegisterActivity.this.startActivity(loginIntent);
        }

    }

    public boolean isEmailValid() {

        EditText inputView = findViewById(R.id.emailInput);
        String inputEmail = inputView.getText().toString();

        int iEL = inputEmail.length();

        if (iEL > 6 && inputEmail.contains("@")) {
            return true;
        }

        else {
            inputView.startAnimation(shakeError());
            inputView.setError("Please input a valid email address");
            return false;
        }

    }

    public boolean doPasswordsMatch() {

        pass1 = findViewById(R.id.passwordInput);
        pass2 = findViewById(R.id.passwordConfirm);

        String pass1Text = pass1.getText().toString();
        String pass2Text = pass2.getText().toString();

        if (pass1Text.equals(pass2Text) && !pass1Text.equals("")) {
            return true;
        }

        pass1.startAnimation(shakeError());
        pass2.startAnimation(shakeError());
        pass1.setError("Passwords do not match");
        pass2.setError("Passwords do not match");
        return false;

    }

    public boolean isEmailUni() {

        EditText inputView = findViewById(R.id.emailInput);
        String inputEmail = inputView.getText().toString();

        int iEL = inputEmail.length();

        if (inputEmail.substring(iEL-6, iEL).equals(".ac.uk")) {
            return true;
        }

        inputView.startAnimation(shakeError());
        inputView.setError("Please input a valid university email address");
        return false;

    }

    public boolean isEmailAvailable() {

        EditText inputView = findViewById(R.id.emailInput);
        String inputEmail = inputView.getText().toString();

        emailAddresses = this.getResources().getStringArray(R.array.emailAddresses);

        for (String email : emailAddresses) {

            if (inputEmail.equals(email)) {

                inputView.startAnimation(shakeError());
                inputView.setError("This email is already registered");
                return false;

            }
        }

        return true;
    }

    public boolean isNameEntered() {

        EditText nameInput = findViewById(R.id.nameInput);
        String nameText = nameInput.getText().toString();

        if (nameText.equals("")) {
            nameInput.startAnimation(shakeError());
            nameInput.setError("Please enter your name");
            return false;
        }

        return true;
    }

    public boolean isCitySelected() {

        Spinner cityInput = findViewById(R.id.citySpinner);
        String citySelection = cityInput.getSelectedItem().toString();

        if (citySelection.equals("- Where are you? -")) {
            cityInput.startAnimation(shakeError());
            return false;
        }

        return true;

    }

    public TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 8, 0, 0);
        shake.setDuration(400);
        shake.setInterpolator(new CycleInterpolator(5));
        return shake;
    }
}
