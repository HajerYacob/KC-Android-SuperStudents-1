package com.example.myrps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {
    Button brock, bpaper, bscisser;
    TextView score;
    ImageView user, computer;
    int HumanScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // find viwe
        //buttons
        brock = findViewById(R.id.brock);
        bpaper = findViewById(R.id.bpaper);
        bscisser = findViewById(R.id.bscisser);
//text viwe
        score = findViewById(R.id.score);
// image
        user = findViewById(R.id.user);
        computer = findViewById(R.id.computer);


// set click
        brock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setImageResource(R.drawable.rock);
             String message = play_turn(" rock ");
                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
  score.setText(" Human score "+Integer.toString(HumanScore), TextView.BufferType.valueOf(" computer " + Integer.toString(ComputerScore)));
            }
        });


        bpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setImageResource(R.drawable.paper);
                String message = play_turn(" paper ");
                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
   score.setText(" Human score "+Integer.toString(HumanScore), TextView.BufferType.valueOf(" Computer Score " + Integer.toString(ComputerScore)));

            }
        });


        bscisser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setImageResource(R.drawable.scissors);
                String message = play_turn(" scisser ");
                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
   score.setText(" Human score "+Integer.toString(HumanScore), TextView.BufferType.valueOf(" computer " + Integer.toString(ComputerScore)));

            }
        });

    }

    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();

        // choose 1 2 or 3
        int computer_choise_number = r.nextInt(3) + 1;

        if (computer_choise_number == 1) {
            computer_choice = " rock";
        } else if (computer_choise_number == 2) {
            computer_choice = " paper ";
        } else if (computer_choise_number == 3) {
            computer_choice = " scisser ";
        }

// set computer image
        if (computer_choice == "rock") {
            computer.setImageResource(R.drawable.rock);
        } else if (computer_choice == "paper") {
            computer.setImageResource(R.drawable.paper);
        } else if (computer_choice == "scisser") {
            computer.setImageResource(R.drawable.scissors);
        }
// whos win !!

        if (computer_choice == player_choice) {
            return " Draw , No one win !! ";
        } else if (player_choice == "rock" && computer_choice == " scisser ") {
            HumanScore++;
            return " you win !! ";

        } else if (player_choice == "rock" && computer_choice == " paper ") {
            ComputerScore++;
            return " computer win !! ";

        } else if (player_choice == "paper" && computer_choice == " scisser ") {
            ComputerScore++;
            return " computer win !! ";

        } else if (player_choice == "paper" && computer_choice == " rock ") {
            HumanScore++;
            return " you win !! ";

        } else if (player_choice == "scisser" && computer_choice == " paper ") {
            HumanScore++;
            return " you win !! ";

        }else if (player_choice == "scisser" && computer_choice == " rock ") {
            ComputerScore++;
            return " computer win !! ";}

            else return "";
    }




    }
