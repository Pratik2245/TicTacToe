package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDailog extends Dialog {
    private final  String message;
    private final MainActivity mainActivity;
    public WinDailog(@NonNull Context context,String message,MainActivity mainActivity) {
        super(context);
        this.mainActivity=mainActivity;
        this.message=message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dailog_layout);
        final TextView msgText=findViewById(R.id.msgText);
        final Button startAgain=findViewById(R.id.startAgain);
        msgText.setText(message);
        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mainActivity.restartMatch();
            dismiss();
            }
        });

    }

}
