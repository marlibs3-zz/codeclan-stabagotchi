package com.example.martabeveridge.stabagotchi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private Game game;
    private Pet pet;
    private TextView petNameTextView;
    private ProgressBar healthBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        healthBar = findViewById(R.id.healthBarID);

    }

}

//public class GameActivity extends AppCompatActivity {
//    //Game variables
//    private Game game;
//    private Player player;
//    //Player view
//    private TextView playerNameTextView;
//    private ProgressBar anxietyBar;
//    private ProgressBar sleepBar;
//    private ProgressBar socialLifeBar;
//    private ProgressBar moneyBar;
//    //Card text
//    private TextView cardNameTextView;
//    private TextView cardProjectCardTextView;
//    private TextView cardDescriptionTextView;
//    private TextView cardFirstOptionTextView;
//    private TextView cardSecondOptionTextView;
//    //Database
//    private GamelogDatabase db;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game);
//
//        //Initialize player views
//        playerNameTextView = findViewById(R.id.endPlayerNameId);
//        anxietyBar = findViewById(R.id.anxietyBarId);
//        sleepBar = findViewById(R.id.sleepBarId);
//        socialLifeBar = findViewById(R.id.socialLifeBarId);
//        moneyBar = findViewById(R.id.moneyBarId);
//
//        //Initialize card views
//        cardNameTextView = findViewById(R.id.endSceneTitleTextViewId);
//        cardProjectCardTextView = findViewById(R.id.cardProjectTextViewId);
//        cardDescriptionTextView = findViewById(R.id.winLoseDescriptionTextViewId);
//        cardFirstOptionTextView = findViewById(R.id.cardFirstOptionTextViewId);
//        cardSecondOptionTextView = findViewById(R.id.cardSecondOptionTextViewId);
//
//        //Load game
//        game = loadGame();
//        player = game.getPlayer();
//
//        //Refresh the screen
//        refreshView();
//
//    }
