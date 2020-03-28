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

    }

    public void searchTutor_action(View view) {

        Intent searchTutorIntent = new Intent(MainPageActivity.this, SearchTutorActivity.class);
        MainPageActivity.this.startActivity(searchTutorIntent);

    }

    public void tutorList_action(View view) {

        Intent tutorListIntent = new Intent(MainPageActivity.this, tutorAccountListActivity.class);
        MainPageActivity.this.startActivity(tutorListIntent);

    }

    public void notifications_action(View view) {

        Intent notificationIntent = new Intent(MainPageActivity.this, NotificationsActivity.class);
        MainPageActivity.this.startActivity(notificationIntent);
    }

    public void groupChat_action(View view) {

        Intent groupChatIntent = new Intent(MainPageActivity.this, GroupChatActivity.class);
        MainPageActivity.this.startActivity(groupChatIntent);
    }

    //feedback activity code

    public void feedback_action(View view) {

        Intent feedbackIntent = new Intent(MainPageActivity.this, feedbackActivity.class);
        MainPageActivity.this.startActivity(feedbackIntent);
    }


    //message activity code

    public void message_action(View view) {

        Intent messagesListIntent = new Intent(MainPageActivity.this, messageActivity.class);
        MainPageActivity.this.startActivity(messagesListIntent);
    }


}
