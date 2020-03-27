package com.example.tutorprototype1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class rateTutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_tutor);
    }

    public void submitRating (View view) {

        Intent goToTutorList = new Intent(rateTutorActivity.this, tutorAccountListActivity.class);
        rateTutorActivity.this.startActivity(goToTutorList);
    }

}
