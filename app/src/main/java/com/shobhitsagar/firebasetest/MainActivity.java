package com.shobhitsagar.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button loadButton;
    Button deleteButton;
    EditText editText1;
    private ListView listView;

    private ArrayList<String> listArray= new ArrayList<>();

    private int i=1;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("USERS");

        listView = (ListView) findViewById(R.id.mLoadLV);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listArray);
        listView.setAdapter(arrayAdapter);

        editText1 = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button);
        loadButton = (Button) findViewById(R.id.loadBtn);
        deleteButton = (Button) findViewById(R.id.deleteBtn);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String value = dataSnapshot.getValue(String.class);

                        listArray.add(value);

                        arrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                return;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addArtist();

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.setValue(null);

            }
        });
    }

    private void addArtist() {
        String name = editText1.getText().toString();

        if (!TextUtils.isEmpty(name)) {

            databaseReference.push().setValue(name);
            i++;
            Toast.makeText(this, "Artist Added!", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "You should enter a name", Toast.LENGTH_SHORT).show();
        }
    }
}