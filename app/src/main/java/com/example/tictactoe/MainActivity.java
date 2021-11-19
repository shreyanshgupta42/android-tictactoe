package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int conditions[]={2,2,2,2,2,2,2,2,2};
    int winningcondition[][]={{0,3,6},{1,4,7},{2,5,8},{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};
    boolean gameActive=true;
    int activeplayer=0;

    //0-X,1-Y,2-empty

    public void onclick(View view){
        ImageView counter=(ImageView)view;
        int tag=Integer.parseInt(counter.getTag().toString());
        if(conditions[tag]==2 && gameActive){
            conditions[tag]=activeplayer;
            if(activeplayer==0){
                counter.setImageResource(R.drawable.c2);
                activeplayer=1;
            }else{
                counter.setImageResource(R.drawable.c3);
                activeplayer=0;
            }
            counter.animate().rotation(360).setDuration(1000);
        }
        String winner="";
        for(int[] winningcond :winningcondition){
            if(conditions[winningcond[0]]==conditions[winningcond[1]] && conditions[winningcond[1]]==conditions[winningcond[2]] && conditions[winningcond[0]]!=2){
                if(conditions[winningcond[0]]==0){
                    winner="X";
                }
                else{
                    winner="0";
                }
                gameActive=false;
                Toast.makeText(this,winner+" has won the game",Toast.LENGTH_LONG).show();
                Button button=(Button)findViewById(R.id.playAgainButton);
                button.setVisibility(View.VISIBLE);


            }
        }
        int z=0;
        for(int i=0;i<9;i++){
            if(conditions[i]!=2){
                z++;
            }
        }
        if(z==9){
            Toast.makeText(this,"nobody has won the game, play again",Toast.LENGTH_LONG).show();
            Button button=(Button)findViewById(R.id.playAgainButton);
            button.setVisibility(View.VISIBLE);
        }

    }
    public void playAgain(View view) {

        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

        playAgainButton.setVisibility(View.INVISIBLE);

        androidx.gridlayout.widget.GridLayout gridLayout = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageResource(0);

        }

        for (int i=0; i<conditions.length; i++) {

            conditions[i] = 2;

        }

        activeplayer = 0;

        gameActive = true;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
