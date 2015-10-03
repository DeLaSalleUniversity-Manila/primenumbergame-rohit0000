package com.example.rohit.primenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();

    }

    private int number = 0;
    private int score = 0;

    public void onClickPrime(View view){
        if(isPrime(number)){
            //toast here
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
            score++;
        }
        else{
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
            score -= 5;
            Toast.makeText(this, "Last number was " + number, Toast.LENGTH_SHORT).show();
        }

        start();

    }

    public void onClickComposite(View view){
        if(!isPrime(number)){
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
            score++;
        }
        else{
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
            score -= 5;
            Toast.makeText(this, "Last number was " + number, Toast.LENGTH_SHORT).show();
        }

        start();
    }


    private boolean isPrime(int value){
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    private void displayRandomNumber(){
        Random random = new Random();
        number = 2 + random.nextInt(999);
        TextView tnum = (TextView) findViewById(R.id.number);
        tnum.setText("" + number);
    }

    private void displayScore(){
        TextView tscore = (TextView) findViewById(R.id.score);
        tscore.setText("Score: " + score);

    }
    private void start(){
            displayScore();
            displayRandomNumber();
    }
}
