package com.shashank.ConnectThree;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class singlePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        ImageView player = (ImageView) findViewById(R.id.currentPlayer); //set current player 1 after reset
        player.setImageResource(R.drawable.x);

        TextView tx = (TextView)findViewById(R.id.title);
        TextView tx1 = (TextView)findViewById(R.id.gametitile);


        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/typobold.otf");
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(),  "fonts/typoreg.otf");

        tx.setTypeface(custom_font);
        tx1.setTypeface(custom_font2);
    }

    //global initialisation
    int[] grid = {2,2,2,2,2,2,2,2,2};
    int player = 0; //0 is player 1 and 1 is player 2
    int displayPl;
    //set current player
    public void setPlayer(){
        ImageView currentPlayer = (ImageView) findViewById(R.id.currentPlayer);
        if(player == 0){
            currentPlayer.setImageResource(R.drawable.o);
        }
        else
            currentPlayer.setImageResource(R.drawable.x);
    }
    //check if current grid is empty
    public boolean isEmpty(int check){
        if(grid[check]<2)
            return false;
        else
            return true;
    }
    //check equal for win condition
    public boolean isEq(int a, int b, int c){
        if((a<2) && (b<2) && (c<2)){
            if((a == b) && (b == c)) {
                Log.i("values", a + " " + b + " " + c + "");
                return true;
            }
        }

        return false;
    }
    //check if someone won
    public boolean isWin(){
        ImageView board = (ImageView) findViewById(R.id.grid);
        int winner = player + 1;
        if(isEq(grid[0],grid[3],grid[6])) {
            board.setImageResource(R.drawable.zerothreesix);
            return true;
        }
        if(isEq(grid[0],grid[4],grid[8])) {
            board.setImageResource(R.drawable.zerofoureight);
            return true;
        }
        if(isEq(grid[0],grid[1],grid[2])) {
            board.setImageResource(R.drawable.zeroonetwo);
            return true;
        }
        if(isEq(grid[1],grid[4],grid[7])) {
            board.setImageResource(R.drawable.onefourseven);
            return true;
        }
        if(isEq(grid[2],grid[5],grid[8])) {
            board.setImageResource(R.drawable.twofiveeight);
            return true;
        }
        if(isEq(grid[2],grid[4],grid[6])) {
            board.setImageResource(R.drawable.twofoursiz);
            return true;
        }
        if(isEq(grid[3],grid[4],grid[5])) {
            board.setImageResource(R.drawable.threefourfive);
            return true;
        }
        if(isEq(grid[6],grid[7],grid[8])) {
            board.setImageResource(R.drawable.sixseveneight);
            //Toast.makeText(this, "winner is player " + winner, Toast.LENGTH_LONG).show();
            return true;
        }

        return false;

    }
    //check draw condition
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


    public void botTurn(){
        Random randomvar = new Random();
        int number = randomvar.nextInt(9);
        Log.i("random number generated","random number is :" + number);
        ImageView one = (ImageView) findViewById(R.id.one);
        ImageView two = (ImageView) findViewById(R.id.two);
        ImageView three = (ImageView) findViewById(R.id.three);
        ImageView four = (ImageView) findViewById(R.id.four);
        ImageView five = (ImageView) findViewById(R.id.five);
        ImageView six = (ImageView) findViewById(R.id.six);
        ImageView seven = (ImageView) findViewById(R.id.seven);
        ImageView eight = (ImageView) findViewById(R.id.eight);
        ImageView nine = (ImageView) findViewById(R.id.nine);
        if(grid[number] < 2 ){
            botTurn();
        }
        else {
            switch (number) {
                case 0:
                    if (isEmpty(Integer.parseInt(one.getTag().toString()))) {
                        grid[0] = 1;
                        one.setImageResource(R.drawable.o);
                        one.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 1:
                    if (isEmpty(Integer.parseInt(two.getTag().toString()))) {
                        grid[1] = 1;
                        two.setImageResource(R.drawable.o);
                        two.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 2:
                    if (isEmpty(Integer.parseInt(three.getTag().toString()))) {
                        grid[2] = 1;
                        three.setImageResource(R.drawable.o);
                        three.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 3:
                    if (isEmpty(Integer.parseInt(four.getTag().toString()))) {
                        grid[3] = 1;
                        four.setImageResource(R.drawable.o);
                        four.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 4:
                    if (isEmpty(Integer.parseInt(five.getTag().toString()))) {
                        grid[4] = 1;
                        five.setImageResource(R.drawable.o);
                        five.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 5:
                    if (isEmpty(Integer.parseInt(six.getTag().toString()))) {
                        grid[5] = 1;
                        six.setImageResource(R.drawable.o);
                        six.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 6:
                    if (isEmpty(Integer.parseInt(seven.getTag().toString()))) {
                        grid[6] = 1;
                        seven.setImageResource(R.drawable.o);
                        seven.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 7:
                    if (isEmpty(Integer.parseInt(eight.getTag().toString()))) {
                        grid[7] = 1;
                        eight.setImageResource(R.drawable.o);
                        eight.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
                case 8:
                    if (isEmpty(Integer.parseInt(nine.getTag().toString()))) {
                        grid[8] = 1;
                        nine.setImageResource(R.drawable.o);
                        nine.animate().rotation(180).setDuration(500);
                        if (isWin()) {
                            endGame();
                            return;
                        }
                        if (isDraw()) {
                            draw = 1;
                            endGame();
                            return;
                        }
                        setPlayer();
                        player = 0;
                        break;
                    }
            }
        }
    }





    //main logic to set clicked player
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
                    draw = 1;
                    endGame();
                    return;
                }
                setPlayer();
                player = 1;

                //bot's turn
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        botTurn();
                    }
                }, 500);

            }
        }
    }

    //reset board
    public void resetBoard(){
        for(int i=0; i<9; i++){
            grid[i]=2;
        }
        draw = 0;

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

        ImageView player = (ImageView) findViewById(R.id.currentPlayer);
        player.setImageResource(R.drawable.x);

        ImageView gridImg = (ImageView) findViewById(R.id.grid);
        gridImg.setImageResource(R.drawable.grid);
    }

    int draw = 0;
    //set everything to unclickable
    public void endGame(){
        int winner = player + 1;
        player = 0;
        ImageView one = (ImageView) findViewById(R.id.one);
        ImageView two = (ImageView) findViewById(R.id.two);
        ImageView three = (ImageView) findViewById(R.id.three);
        ImageView four = (ImageView) findViewById(R.id.four);
        ImageView five = (ImageView) findViewById(R.id.five);
        ImageView six = (ImageView) findViewById(R.id.six);
        ImageView seven = (ImageView) findViewById(R.id.seven);
        ImageView eight = (ImageView) findViewById(R.id.eight);
        ImageView nine = (ImageView) findViewById(R.id.nine);

        ImageView player = (ImageView) findViewById(R.id.currentPlayer);
        player.setImageResource(R.drawable.transp);



        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);

        if(draw == 1) {

            DrawDialogSingle draw = new DrawDialogSingle();;
            draw.show(getSupportFragmentManager(), "draw diag");

        }
        else{

            if(winner == 1) {
                PlayerOneWinDialogSingle oneDialog = new PlayerOneWinDialogSingle();
                oneDialog.show(getSupportFragmentManager(), "oneWIn diag");
            }
            else {
                PlayerTwoWinDialogSingle twoDialog = new PlayerTwoWinDialogSingle();
                twoDialog.show(getSupportFragmentManager(), "twoWin diag");
            }

        }
    }
    //reset grid and images
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

        ImageView player = (ImageView) findViewById(R.id.currentPlayer);
        player.setImageResource(R.drawable.x);

        ImageView gridImg = (ImageView) findViewById(R.id.grid);
        gridImg.setImageResource(R.drawable.grid);
    }

    @Override
    public void onBackPressed() {
        BackToMainMenu backDialog = new BackToMainMenu();
        backDialog.show(getSupportFragmentManager(), "backdiag");
    }

    public void backBtn (View view){
        BackToMainMenu backDialog = new BackToMainMenu();
        backDialog.show(getSupportFragmentManager(), "backdiag");
    }
}
