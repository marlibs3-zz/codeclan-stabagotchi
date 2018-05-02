package com.example.martabeveridge.stabagotchi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private Game game;
    private Pet pet;
//  App layout
    private ProgressBar healthBar;
    private TextView level;
    private TextView lovePoints;
    private TextView name;
    private ImageView petImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pet = new Pet("Taco");
        game = new Game(pet);

//      Start up the game
        healthBar = findViewById(R.id.healthBarID);
        level = findViewById(R.id.levelTextViewID);
        lovePoints = findViewById(R.id.lovePointsTextViewID);
        name = findViewById(R.id.nameTextViewID);
        petImage = findViewById(R.id.petImageID);

//      Set up the food buttons
        Button feedTreat = findViewById(R.id.feedTreatID);
        feedTreat.setTag(Foods.TREAT);
        Button feedBowl = findViewById(R.id.feedBowlID);
        feedBowl.setTag(Foods.BOWL);
        Button feedBigBowl = findViewById(R.id.feedBigBowlID);
        feedBigBowl.setTag(Foods.BIGBOWL);
        Button feedRibs = findViewById(R.id.feedRibsID);
        feedRibs.setTag(Foods.RIBS);
        Button feedChicken = findViewById(R.id.feedChickenID);
        feedChicken.setTag(Foods.CHICKEN);
        Button feedSteak = findViewById(R.id.feedSteakID);
        feedSteak.setTag(Foods.STEAK);

//      Add the pet data which cannot change
        String levelString = ""+pet.getLevel();
        level.setText(levelString);
        name.setText(pet.getName());

//      Add the pet data which can change
        healthBar.setProgress(pet.getHealthPoints());
        String loveString = ""+pet.getLovePoints();
        lovePoints.setText(loveString);

//      Load previous status TODO

//      Refresh the screen for health to go down TODO

    }

    public void onFoodButtonClicked(View foodButton){
        Foods foodClicked = (Foods) foodButton.getTag();
        game.feed(foodClicked);
    }

}

