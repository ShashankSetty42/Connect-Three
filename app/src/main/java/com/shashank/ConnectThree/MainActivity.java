package com.shashank.ConnectThree;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //default funct
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tx = (TextView)findViewById(R.id.gametitile);
        TextView tx1 = (TextView)findViewById(R.id.singleplayertext);
        TextView tx2 = (TextView)findViewById(R.id.multiplayertext);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/typobold.otf");
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(),  "fonts/typoreg.otf");

        tx.setTypeface(custom_font);
        tx1.setTypeface(custom_font2);
        tx2.setTypeface(custom_font2);
    }


    public void sPlayer (View view){

        startActivity(new Intent(MainActivity.this, singlePlayer.class));

    }
    public void mPlayer (View view){

        startActivity(new Intent(MainActivity.this, pvp.class));
    }




    //exit dialog
    @Override
    public void onBackPressed() {
        ExitDiag exitDialog = new ExitDiag();
        exitDialog.show(getSupportFragmentManager(), "exit");
    }

    public void exitBtn(View view){
        ExitDiag exitDialog = new ExitDiag();
        exitDialog.show(getSupportFragmentManager(), "exit");
    }

}
