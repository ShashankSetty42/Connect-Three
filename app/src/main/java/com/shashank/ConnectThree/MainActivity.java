package com.shashank.ConnectThree;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int[] grid = {2,2,2,2,2,2,2,2,2};
    int player = 0; //0 is player 1 and 1 is player 2
    int displayPl;

    public void setPlayer(){
        TextView currentPlayer = (TextView) findViewById(R.id.currentPlayer);
        if(player == 0){
            currentPlayer.setText(R.string.playerTwo);
        }
        else
            currentPlayer.setText(R.string.playerOne);
    }

    public boolean isEmpty(int check){
        if(grid[check]<2)
            return false;
        else
            return true;
    }

    public boolean isEq(int a, int b, int c){
        if((a<2) && (b<2) && (c<2)){
            if((a == b) && (b == c)) {
                    Log.i("values", a + " " + b + " " + c + "");
                    return true;
                }
        }

            return false;
    }

    public boolean isWin(){
        int winner = player + 1;
        if(isEq(grid[0],grid[3],grid[6])) {
            Log.i("if statment of","0,3,6");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }
        if(isEq(grid[0],grid[4],grid[8])) {
            Log.i("if statment of", "0,4,8");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }
        if(isEq(grid[0],grid[1],grid[2])) {
            Log.i("if statment of","0,1,2");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }
        if(isEq(grid[1],grid[4],grid[7])) {
            Log.i("if statment of","1,4,7");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }
        if(isEq(grid[2],grid[5],grid[8])) {
            Log.i("values","grid[2] = " + grid [2] + " " + "grid[5] = " + grid[5] + " " + "grid[8] = " + grid[8]);
            Log.i("if statment of","2,5,8");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }
        if(isEq(grid[2],grid[4],grid[6])) {
            Log.i("if statment of","2,4,6");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }
        if(isEq(grid[3],grid[4],grid[5])) {
            Log.i("if statment of","3,4,5");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }
        if(isEq(grid[6],grid[7],grid[8])) {
            Log.i("if statment of","6,7,8");
            Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }

        return false;

    }

    public boolean isDraw(){
        int flag = 0;

        for(int i=0; i<9; i++){
            if(grid[i] == 2) {
                flag = 0;
                break;
            }
            else
                flag = 1;
        }

        if(flag == 1){
            Toast.makeText(this, "Round Draw", Toast.LENGTH_LONG).show();
            return true;
        }
        else
        return false;
    }

    public void clickedLayout(View view){
        ImageView clicked = (ImageView) view;
        if(isEmpty(Integer.parseInt(clicked.getTag().toString()))) {
                if (player == 0) {
                    grid[Integer.parseInt(clicked.getTag().toString())] = 0;
                    clicked.setImageResource(R.drawable.x);
                    clicked.animate().rotation(180).setDuration(500);
                    if(isWin()) {
                        endGame();
                        return;
                    }
                    if(isDraw()) {
                        endGame();
                        return;
                    }
                    setPlayer();
                    player = 1;
                } else {
                    grid[Integer.parseInt(clicked.getTag().toString())] = 1;
                    clicked.setImageResource(R.drawable.o);
                    clicked.animate().rotation(180).setDuration(500);
                    if(isWin()) {
                        endGame();
                        return;
                    }
                    if(isDraw()) {
                        endGame();
                        return;
                    }
                    setPlayer();
                    player = 0;
                }
        }
    }

    public void endGame(){

        ImageView one = (ImageView) findViewById(R.id.one);
        ImageView two = (ImageView) findViewById(R.id.two);
        ImageView three = (ImageView) findViewById(R.id.three);
        ImageView four = (ImageView) findViewById(R.id.four);
        ImageView five = (ImageView) findViewById(R.id.five);
        ImageView six = (ImageView) findViewById(R.id.six);
        ImageView seven = (ImageView) findViewById(R.id.seven);
        ImageView eight = (ImageView) findViewById(R.id.eight);
        ImageView nine = (ImageView) findViewById(R.id.nine);

        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
    }

    public void resetBtn(View view){
        for(int i=0; i<9; i++){
            grid[i]=2;
        }

        player = 0;
        setPlayer();
        ImageView one = (ImageView) findViewById(R.id.one);
        ImageView two = (ImageView) findViewById(R.id.two);
        ImageView three = (ImageView) findViewById(R.id.three);
        ImageView four = (ImageView) findViewById(R.id.four);
        ImageView five = (ImageView) findViewById(R.id.five);
        ImageView six = (ImageView) findViewById(R.id.six);
        ImageView seven = (ImageView) findViewById(R.id.seven);
        ImageView eight = (ImageView) findViewById(R.id.eight);
        ImageView nine = (ImageView) findViewById(R.id.nine);

        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);

        one.setImageResource(R.drawable.transp);
        one.animate().rotation(0);
        two.setImageResource(R.drawable.transp);
        two.animate().rotation(0);
        three.setImageResource(R.drawable.transp);
        three.animate().rotation(0);
        four.setImageResource(R.drawable.transp);
        four.animate().rotation(0);
        five.setImageResource(R.drawable.transp);
        five.animate().rotation(0);
        six.setImageResource(R.drawable.transp);
        six.animate().rotation(0);
        seven.setImageResource(R.drawable.transp);
        seven.animate().rotation(0);
        eight.setImageResource(R.drawable.transp);
        eight.animate().rotation(0);
        nine.setImageResource(R.drawable.transp);
        nine.animate().rotation(0);


    }

}
