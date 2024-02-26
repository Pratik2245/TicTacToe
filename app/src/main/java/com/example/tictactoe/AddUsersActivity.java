package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUsersActivity extends AppCompatActivity {
EditText playerOneName,playerTwoName;
Button startGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users);
        playerOneName=findViewById(R.id.playerOneName);
        playerTwoName=findViewById(R.id.playerTwoName);
        startGame=findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String pl1=playerOneName.getText().toString();
              String pl2=playerTwoName.getText().toString();
//             if(pl1.equals("") || pl2.equals(""))
             if(pl1.isEmpty() || pl2.isEmpty())
             {
                 Toast.makeText(AddUsersActivity.this, "Enter valid Players Names", Toast.LENGTH_SHORT).show();
             }
             else {
                 Intent i=new Intent(AddUsersActivity.this,MainActivity.class);
                 i.putExtra("player1",pl1);
                 i.putExtra("player2",pl2);
                 startActivity(i);
                 finish();
             }
            }
        });
    }
}