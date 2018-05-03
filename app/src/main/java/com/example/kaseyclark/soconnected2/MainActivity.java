package com.example.kaseyclark.soconnected2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView userInput;
    TextView displayText;
    private ArrayList<String >textList=new ArrayList<>();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth auth =FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;
    private DatabaseReference userRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        displayText=(TextView) findViewById(R.id.textView_data);
        userInput =(EditText) findViewById(R.id.edittext_data);

        authListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user == null) {
                    startActivity(new Intent(MainActivity.this, Logon.class));
                } else {
                     userRef=database.getReference(user.getUid());
                     userRef.addChildEventListener(new ChildEventListener() {


                         @Override
                         public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            textList.add(dataSnapshot.getValue(String.class));
                            displayText();
                         }

                         @Override
                         public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                             Toast.makeText(MainActivity.this, dataSnapshot.getValue(String.class)+ "has changed", Toast.LENGTH_SHORT).show();

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
                }
            }
        };
    }

        public void logoutbutton (View view){
         auth.signOut();
         textList.clear();
         displayText.setText("");
         userInput.setText("");
        startActivity(new Intent(MainActivity.this, Logon.class));


    }
private void displayText(){
            String text="";
            for (String s : textList){
                text += s + "/n";
            }
            displayText.setText(text);
}
public void sendbutton (View view) {
    FirebaseUser user =auth.getCurrentUser();
    userRef=database.getReference(user.getUid());
    String userText = userInput.getText().toString();

    userRef.push().setValue(userText);

}
}
