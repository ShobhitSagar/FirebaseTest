package com.shobhitsagar.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button button1;
    EditText editText1;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("artists");

        editText1 = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addArtist();

            }
        });
    }

    private void addArtist() {
        String name = editText1.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {

            String id = databaseReference.push().getKey();

            Artist artist = new Artist(id, name);

            databaseReference.child(id).setValue(artist);
            Toast.makeText(this, "Artist Added!", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "You should enter a name", Toast.LENGTH_SHORT).show();
        }
    }
}
