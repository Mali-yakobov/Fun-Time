package mali.funtime;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mali.funtime.R;

import static android.graphics.Color.YELLOW;

public class XO extends AppCompatActivity {
    public Button ButtonArray[]=new Button[10];
    public int Array[]=new int[10];
    private static Button button_newGame;
    private static int numOfMove;
    private static boolean c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListener();
        numOfMove=0;
        ButtonArray[1]=(Button) findViewById(R.id.button1);
        ButtonArray[2]=(Button) findViewById(R.id.button2);
        ButtonArray[3]=(Button) findViewById(R.id.button3);
        ButtonArray[4]=(Button) findViewById(R.id.button4);
        ButtonArray[5]=(Button) findViewById(R.id.button5);
        ButtonArray[6]=(Button) findViewById(R.id.button6);
        ButtonArray[7]=(Button) findViewById(R.id.button7);
        ButtonArray[8]=(Button) findViewById(R.id.button8);
        ButtonArray[9]=(Button) findViewById(R.id.button9);

    }
    public void OnClickButtonListener() {
        button_newGame = (Button) findViewById(R.id.button_newGame);
        button_newGame.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                }

        );}
    public void buttonClicked(View v){
        Button b=(Button) v;
        b.setText("X");
        switch (v.getId()) {
            case R.id.button1:
                Array[1]=1;
                computerMove(1);
                break;
            case R.id.button2:
                Array[2]=1;
                computerMove(2);
                break;
            case R.id.button3:
                Array[3]=1;
                computerMove(3);
                break;
            case R.id.button4:
                Array[4]=1;
                computerMove(4);
                break;
            case R.id.button5:
                Array[5]=1;
                computerMove(5);
                break;
            case R.id.button6:
                Array[6]=1;
                computerMove(6);
                break;
            case R.id.button7:
                Array[7]=1;
                computerMove(7);
                break;
            case R.id.button8:
                Array[8]=1;
                computerMove(8);
                break;
            case R.id.button9:
                Array[9]=1;
                computerMove(9);
                break;
        }

    }
    public boolean isEmpty(int num) {
        if(Array[num]==0) {
            ButtonArray[num].setText("O");
            Array[num]=2;
            return true;
        }
        return false;
    }
    public void computerMove(int location){

        if(gameOver())
            return;
        if(numOfMove==0) {
            if(!isEmpty(1)){ if(!isEmpty(7)){if(!isEmpty(3)){if(!isEmpty(7)){if(!isEmpty(5)) noChoice();}}}}
        }
        else if(numOfMove==4){
            Toast.makeText(this,"Tiko,start a new game!",Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        else{
            c=false;

            if(Array[1]==1&&Array[3]==1&&!c){c=isEmpty(2);}
            if(Array[1]==1&&Array[2]==1&&!c){c=isEmpty(3);}
            if(Array[1]==1&&Array[7]==1&&!c) c=isEmpty(4);
            if(Array[1]==1&&Array[9]==1&&!c)c=isEmpty(5);
            if(Array[1]==1&&Array[5]==1&&!c)c=isEmpty(9);
            if(Array[1]==1&&Array[4]==1&&!c)c=isEmpty(7);
            if(Array[2]==1&&Array[3]==1&&!c)c=isEmpty(1);
            if(Array[2]==1&&Array[5]==1&&!c)c=isEmpty(8);
            if(Array[2]==1&&Array[8]==1&&!c)c=isEmpty(5);
            if(Array[3]==1&&Array[7]==1&&!c)c=isEmpty(5);
            if(Array[3]==1&&Array[5]==1&&!c)c=isEmpty(7);
            if(Array[3]==1&&Array[6]==1&&!c)c=isEmpty(9);
            if(Array[3]==1&&Array[9]==1&&!c)c=isEmpty(6);
            if(Array[4]==1&&Array[7]==1&&!c)c=isEmpty(1);
            if(Array[4]==1&&Array[5]==1&&!c)c=isEmpty(6);
            if(Array[4]==1&&Array[6]==1&&!c)c=isEmpty(5);
            if(Array[5]==1&&Array[6]==1&&!c)c=isEmpty(4);
            if(Array[5]==1&&Array[9]==1&&!c)c=isEmpty(1);
            if(Array[5]==1&&Array[7]==1&&!c)c=isEmpty(3);
            if(Array[5]==1&&Array[8]==1&&!c)c=isEmpty(2);
            if(Array[6]==1&&Array[9]==1&&!c)c=isEmpty(3);
            if(Array[7]==1&&Array[9]==1&&!c)c=isEmpty(8);
            if(Array[7]==1&&Array[8]==1&&!c)c=isEmpty(9);
            if(Array[8]==1&&Array[9]==1&&!c)c=isEmpty(7);
            if(!c) noChoice();


        }
        if(gameOver())
            return;
        numOfMove++;
    }

    public void noChoice() {
        int i=1;
        while (i<10 &&(!isEmpty(i)) ){
            if(isEmpty(i)) return;
            i++;
        }
        gameOver();
    }

    public boolean gameOver(){
        if(Array[1]==Array[2]&&Array[2]==Array[3]&&Array[1]!=0){
            ButtonArray[1].setBackgroundColor(YELLOW);
            ButtonArray[2].setBackgroundColor(YELLOW);
            ButtonArray[3].setBackgroundColor(YELLOW);
            printToast(Array[1]);
            return true;
        }
        else if(Array[1]==Array[4]&&Array[4]==Array[7]&&Array[1]!=0){
            ButtonArray[1].setBackgroundColor(Color.YELLOW);
            ButtonArray[4].setBackgroundColor(Color.YELLOW);
            ButtonArray[7].setBackgroundColor(Color.YELLOW);
            printToast(Array[1]);
            return true;
        }
        else if(Array[2]==Array[5]&&Array[5]==Array[8]&&Array[5]!=0){
            ButtonArray[5].setBackgroundColor(Color.YELLOW);
            ButtonArray[2].setBackgroundColor(Color.YELLOW);
            ButtonArray[8].setBackgroundColor(Color.YELLOW);
            printToast(Array[2]);
            return true;
        }
        else if(Array[3]==Array[6]&&Array[6]==Array[9]&&Array[3]!=0){
            ButtonArray[6].setBackgroundColor(Color.YELLOW);
            ButtonArray[9].setBackgroundColor(Color.YELLOW);
            ButtonArray[3].setBackgroundColor(Color.YELLOW);
            printToast(Array[3]);
            return true;
        }
        else if(Array[4]==Array[5]&&Array[5]==Array[6]&&Array[4]!=0){
            ButtonArray[4].setBackgroundColor(Color.YELLOW);
            ButtonArray[5].setBackgroundColor(Color.YELLOW);
            ButtonArray[6].setBackgroundColor(Color.YELLOW);
            printToast(Array[4]);
            return true;
        }
        else if(Array[7]==Array[8]&&Array[8]==Array[9]&&Array[7]!=0){
            ButtonArray[7].setBackgroundColor(Color.YELLOW);
            ButtonArray[8].setBackgroundColor(Color.YELLOW);
            ButtonArray[9].setBackgroundColor(Color.YELLOW);
            printToast(Array[7]);
            return true;
        }
        else if(Array[1]==Array[5]&&Array[5]==Array[9]&&Array[1]!=0){
            ButtonArray[1].setBackgroundColor(Color.YELLOW);
            ButtonArray[5].setBackgroundColor(Color.YELLOW);
            ButtonArray[9].setBackgroundColor(Color.YELLOW);
            printToast(Array[1]);
            return true;
        }
        else if(Array[3]==Array[5]&&Array[5]==Array[7]&&Array[3]!=0){
            ButtonArray[7].setBackgroundColor(Color.YELLOW);
            ButtonArray[5].setBackgroundColor(Color.YELLOW);
            ButtonArray[3].setBackgroundColor(Color.YELLOW);
            printToast(Array[3]);
            return true;
        }
        else {

            for (int i = 1; i < 11; i++) {
                if (Array[i] == 0) {
                    return false;
                }
            }
            Toast.makeText(this, "Tiko", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    public void printToast(int player){
        if(player==1)
            Toast.makeText(this,"You Win",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"You Loos",Toast.LENGTH_SHORT).show();
    }
}
