package com.example.martabeveridge.stabagotchi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private Game game;
    private Pet pet;
//  App layout
    private ProgressBar healthBar;
    private TextView level;
    private TextView lovePoints;
    private TextView petName;
    private ImageButton petButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

//      Start up the game
        healthBar = findViewById(R.id.healthBarID);
        level = findViewById(R.id.levelTextViewID);
        lovePoints = findViewById(R.id.lovePointsTextViewID);
        petName = findViewById(R.id.petNameTextViewID);

//      Load previous status TODO

//      Refresh the screen for health to go down TODO

    }

}

