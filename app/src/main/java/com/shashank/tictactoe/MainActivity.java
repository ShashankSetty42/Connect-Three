package com.shashank.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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

    public boolean checkDraw (){
        int flag = 0;
        for (int i=0; i<9; i++){
            if(grid[i] == 2) {
                flag = 0;
                break;
            }
            else
                flag = 1;

        }
        if(flag==1) {
            Toast.makeText(this, "It's a Draw!", Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }

    public int isWin(){

        if((grid[0] == grid[3]) && (grid[3] == grid[6]))
                return grid[0];
        else if((grid[0] == grid[4]) & (grid[4] == grid[8]))
                    return grid[0];
        else if((grid[0] == grid[1]) && (grid[1] == grid[2]))
                    return grid[0];
        else if((grid[1] == grid[4]) && (grid[4] == grid[7]))
                    return grid[1];
        else if((grid[2] == grid[5]) && (grid[5] == grid[8]))
                    return grid[2];
        else if((grid[2] == grid[4]) && (grid[4] == grid[6]))
                    return grid[2];
        else if((grid[3] == grid[4]) && (grid[4] == grid[5]))
                    return grid[3];
        else if((grid[6] == grid[7]) && (grid[7] == grid[8]))
                    return grid[6];
        else
            return -1;
    }

    public boolean isClicked(){
        int flag=0;
        for(int j=0; j<9; j++) {
            if (grid[j] != 2){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            return false;
        else
            return true;
    }

    //check if spot is used and if player = 0
    public boolean isClicked(int i){
            if (grid[i] < 2)
                return false;
            else
                return true;
    }

    public void setDisable(){
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

    //First
    public void oneG (View view){
        ImageView one = (ImageView) findViewById(R.id.one);
        if(isClicked(0)) {
            if (isClicked()) {
                grid[0] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500).start();
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2 )) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[0] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //Second
    public void twoG (View view){
        ImageView one = (ImageView) findViewById(R.id.two);
        if(isClicked(1)) {
            if (isClicked()) {
                grid[1] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if(check >= 0 && check <2 ) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[1] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //Third
    public void threeG (View view){
        ImageView one = (ImageView) findViewById(R.id.three);
        if(isClicked(2)) {
            if (isClicked()) {
                grid[2] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0 ) && (check <2 )) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2 )) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[2] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //Fourth
    public void fourG (View view){
        ImageView one = (ImageView) findViewById(R.id.four);
        if(isClicked(3)) {
            if (isClicked()) {
                grid[3] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[3] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //Fifth
    public void fiveG (View view){
        ImageView one = (ImageView) findViewById(R.id.five);
        if(isClicked(4)) {
            if (isClicked()) {
                grid[4] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[4] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //sixth
    public void sixG (View view){
        ImageView one = (ImageView) findViewById(R.id.six);
        if(isClicked(5)) {
            if (isClicked()) {
                grid[5] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[5] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //Seventh
    public void sevenG (View view){
        ImageView one = (ImageView) findViewById(R.id.seven);
        if(isClicked(6)) {
            if (isClicked()) {
                grid[6] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[6] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //eight
    public void eightG (View view){
        ImageView one = (ImageView) findViewById(R.id.eight);
        if(isClicked(7)) {
            if (isClicked()) {
                grid[7] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[7] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    //nineth
    public void nineG (View view){
        ImageView one = (ImageView) findViewById(R.id.nine);
        if(isClicked(8)) {
            if (isClicked()) {
                grid[8] = player;
                int check = isWin();
                if (player == 0) {
                    one.setImageResource(R.drawable.x);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 1;
                }
                else{
                    one.setImageResource(R.drawable.o);
                    one.animate().rotation(180).setDuration(500);
                    displayPl = player + 1;
                    if((check >= 0) && (check <2)) {
                        Toast.makeText(this, "The Winner is, Player " + displayPl, Toast.LENGTH_LONG).show();
                        setDisable();
                    }
                    if(checkDraw())
                        one.setEnabled(false);
                    player = 0;
                }
            }
            else {
                grid[8] = 0;
                player = 1;
                one.setImageResource(R.drawable.x);
                one.animate().rotation(180).setDuration(500);
            }
        }
    }

    public void resetBtn(View view){
        for(int i=0; i<9; i++){
            grid[i]=2;
        }
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
        two.setImageResource(R.drawable.transp);
        three.setImageResource(R.drawable.transp);
        four.setImageResource(R.drawable.transp);
        five.setImageResource(R.drawable.transp);
        six.setImageResource(R.drawable.transp);
        seven.setImageResource(R.drawable.transp);
        eight.setImageResource(R.drawable.transp);
        nine.setImageResource(R.drawable.transp);


    }

}
