package com.example.tutorprototype1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SearchTutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tutor);
    }

    public void goToTutorList (View view) {

        Intent goToTutorList = new Intent(SearchTutorActivity.this, tutorAccountListActivity.class);
        SearchTutorActivity.this.startActivity(goToTutorList);
    }
}
