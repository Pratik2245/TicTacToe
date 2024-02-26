package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<int[]> list;
    int[] boxPositions={0,0,0,0,0,0,0,0,0};
    int playerTurn=1;
    int totalBoxSelected=1;
TextView playerOneName,playerTwoName;
LinearLayout playerOneLayout,playerTwoLayout;
ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneLayout=findViewById(R.id.playerOneLayout);
        playerTwoLayout=findViewById(R.id.playerTwoLayout);
        playerOneName=findViewById(R.id.playerOneName);
        playerTwoName=findViewById(R.id.playerTwoName);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);
        image6=findViewById(R.id.image6);
        image7=findViewById(R.id.image7);
        image8=findViewById(R.id.image8);
        image9=findViewById(R.id.image9);
        list=new ArrayList<>();

        list.add(new int[]{0,1,2});
        list.add(new int[]{3,4,5});
        list.add(new int[]{6,7,8});
        list.add(new int[]{0,3,6});
        list.add(new int[]{1,4,7});
        list.add(new int[]{2,5,8});
        list.add(new int[]{0,4,8});
        list.add(new int[]{2,4,6});

        //getting name of player from intent
        String getPlayerOneName=getIntent().getStringExtra("player1");
        String getPlayerTwoName=getIntent().getStringExtra("player2");
        //setting name of players to mainactivity
        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        //image1
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           if(isBoxSelectable(0)){
               performAction((ImageView) v,0);
           }
            }
        });
        //image2
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(1)){
                    performAction((ImageView) v,1);
                }
            }
        });
        //image3
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(2)){
                    performAction((ImageView) v,2);
                }
            }
        });
        //image4
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(3)){
                    performAction((ImageView) v,3);
                }
            }
        });
        //image5
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(4)){
                    performAction((ImageView) v,4);
                }
            }
        });
        //image6
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(5)){
                    performAction((ImageView) v,5);
                }
            }
        });
        //image7
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(6)){
                    performAction((ImageView) v,6);
                }
            }
        });
        //image8
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(7)){
performAction((ImageView) v,7);
                }
            }
        });
        //image9
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBoxSelectable(8)){
                    performAction((ImageView) v,8);
                }
            }
        });

    }


    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.close);
            if (checkPlayerWin()) {
                WinDailog winDailog = new WinDailog(MainActivity.this, playerOneName.getText().toString() + " Has Won The Match", MainActivity.this);
                winDailog.setCancelable(false);
                winDailog.show();
            } else if (totalBoxSelected == 9) { // Check if all boxes are selected
                WinDailog winDailog = new WinDailog(MainActivity.this, "Match Draw", MainActivity.this);
                winDailog.setCancelable(false);
                winDailog.show();
            } else {
                changePlayerTurn(2);
            }
        } else {
            imageView.setImageResource(R.drawable.o);
            if (checkPlayerWin()) {
                WinDailog winDailog = new WinDailog(MainActivity.this, playerTwoName.getText().toString() + " Has Won The Match", MainActivity.this);
                winDailog.setCancelable(false);
                winDailog.show();
            } else if (totalBoxSelected == 9) { // Check if all boxes are selected
                WinDailog winDailog = new WinDailog(MainActivity.this, "Match Draw", MainActivity.this);
                winDailog.setCancelable(false);
                winDailog.show();
            } else {
                changePlayerTurn(1);
            }
        }
        totalBoxSelected++; // Increment totalBoxSelected after each selection
    }

    private void changePlayerTurn(int currentPlyerTurn)
    {
        playerTurn=currentPlyerTurn;
        if(playerTurn==1)
        {
            playerOneLayout.setBackgroundResource(R.drawable.main_round_back);
            playerTwoLayout.setBackgroundResource(R.drawable.player_name);
        }else{
            playerOneLayout.setBackgroundResource(R.drawable.player_name);
            playerTwoLayout.setBackgroundResource(R.drawable.main_round_back);
        }
    }

    private  boolean checkPlayerWin()
    {
        boolean response=false;
        for(int i=0;i<list.size();i++)
        {
            final int[] combination=list.get(i);
            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn)
            {
                 response=true;
            }
        }
        return  response;
    }
    private boolean isBoxSelectable(int boxPosition)
    {
        boolean response=false;
        if(boxPositions[boxPosition]==0)
        {
            response=true;
        }
        return response;
    }

void restartMatch() {
    for (int i = 0; i < boxPositions.length; i++) {
        boxPositions[i] = 0;
    }
    playerTurn = 1; // Update class-level variable
    totalBoxSelected = 1; // Update class-level variable

    // Reset image views
    image1.setImageResource(android.R.color.transparent);
    image2.setImageResource(android.R.color.transparent);
    image3.setImageResource(android.R.color.transparent);
    image4.setImageResource(android.R.color.transparent);
    image5.setImageResource(android.R.color.transparent);
    image6.setImageResource(android.R.color.transparent);
    image7.setImageResource(android.R.color.transparent);
    image8.setImageResource(android.R.color.transparent);
    image9.setImageResource(android.R.color.transparent);
}

}