package com.cynobit.alc40_phase1;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        // Back Arrow on Action Bar.
        if (getActionBar() != null) getActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Name TextView to BOLD.
        ((TextView) findViewById(R.id.nameTextView)).setTypeface(null, Typeface.BOLD);
    }
}
