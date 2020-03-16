package com.example.tutorprototype1.dummy;

import android.graphics.drawable.Drawable;

import com.example.tutorprototype1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Content {

    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    // What is displayed

    public static class DummyItem {
        public final String name;
        public final String email;
        public final String details;
        public final String extended_details;
        public final int profile_pic;

        public DummyItem(String name, String email, String details, String extended_details, int profile_pic) {
            this.name = name;
            this.email = email;
            this.details = details;
            this.extended_details = extended_details;
            this.profile_pic = profile_pic;
        }
    }

    static {
        addItem(new DummyItem("Kostas L", "k.liaskos@strath.ac.uk",
                "PhD in Computer Science", "Hi, I'm a lecturer at the University of Strathclyde. My hobbies include extreme ironing and immunological approaches to automatic test-data generation.", R.drawable.kostas_l));
        addItem(new DummyItem("Sophie P", "sophie_p95@hotmail.com",
                "Masters in Legal Practice", "My name is Sophie and I have lots of spare time to help you with your law studies!", R.drawable.sophie_p));
        addItem(new DummyItem("Gordon J", "example@email.com",
                "Bachelors in Italian and Japanese", "If you have a 'domanda' or a 'mondai', I'm the one to ask!", R.drawable.gordon_j));
        addItem(new DummyItem("Marcus R", "another@email.com",
                "Bachelors in Mechanical Engineering", "Hi, I'm a recent graduate of Glasgow University and I do a lot of Arduino projects!", R.drawable.marcus_r));
    }
}
