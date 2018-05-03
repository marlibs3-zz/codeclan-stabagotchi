package com.example.martabeveridge.stabagotchi;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity {

    private Game game;
    private Pet pet;
//  App layout
    private ProgressBar healthBar;
    private TextView level;
    private TextView lovePoints;
    private TextView name;
    private ImageView petImage;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        vibrator = (Vibrator) GameActivity.this.getSystemService(Context.VIBRATOR_SERVICE);

        pet = new Pet("Taco");
        game = new Game(pet);

//      Start up the game
        healthBar = findViewById(R.id.healthBarID);
        level = findViewById(R.id.levelTextViewID);
        lovePoints = findViewById(R.id.lovePointsTextViewID);
        name = findViewById(R.id.nameTextViewID);
        petImage = findViewById(R.id.petImageID);

        refresh();

//      Load previous status TODO

//      Refresh the screen for health to go down TODO

    }

    public void refresh() {
        String levelString = ""+pet.getLevel();
        level.setText(levelString);
        name.setText(pet.getName());

        healthBar.setProgress(pet.getHealthPoints());
        String loveString = ""+pet.getLovePoints();
        lovePoints.setText(loveString);
    }

public void onPetClicked(View view) {
        vibrator.vibrate(25);
//        Toast.makeText(this, "Woof!", Toast.LENGTH_SHORT).show();
        pet.addLovePoint();
        refresh();
    }

    public void onFeedTreatClicked(View view) {
        if (pet.canAffordThisFood(Foods.TREAT.getCostOfFood())) {
            Toast.makeText(this, "A yummy treat for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.TREAT);
        }
        refresh();
    }

    public void onFeedBowlClicked(View view) {
        if (pet.canAffordThisFood(Foods.BOWL.getCostOfFood())) {
            Toast.makeText(this, "A bowl of chow for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.BOWL);
        }
        refresh();
    }

    public void onFeedBigBowlClicked(View view) {
        if (pet.canAffordThisFood(Foods.BIGBOWL.getCostOfFood())) {
            Toast.makeText(this, "A massive bowl for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.BIGBOWL);
        }
        refresh();
    }

    public void onFeedRibsClicked(View view) {
        if (pet.canAffordThisFood(Foods.RIBS.getCostOfFood())) {
            Toast.makeText(this, "Some tasty ribs for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.RIBS);
        }
        refresh();
    }

    public void onFeedChickenClicked(View view) {
        if (pet.canAffordThisFood(Foods.CHICKEN.getCostOfFood())) {
            Toast.makeText(this, "A chicken drumstick for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.CHICKEN);
        }
        refresh();
    }

    public void onFeedSteakClicked(View view) {
        if (pet.canAffordThisFood(Foods.STEAK.getCostOfFood())) {
            Toast.makeText(this, "A juicy steak for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.STEAK);
        }
        refresh();
    }




}

