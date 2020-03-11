package com.example.tutorprototype1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    @Override
    public void onBackPressed () {
        return;
    }

    public void rateTutor_action(View view) {

        Intent rateTutorIntent = new Intent(MainPageActivity.this, rateTutorActivity.class);
        MainPageActivity.this.startActivity(rateTutorIntent);
        return;
    }

    public void searchTutor_action(View view) {

        Intent searchTutorIntent = new Intent(MainPageActivity.this, SearchTutorActivity.class);
        MainPageActivity.this.startActivity(searchTutorIntent);
        return;
    }



}
