package com.example.martabeveridge.stabagotchi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;


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
    private int dogImageFrameIndex;

    Handler handler = new Handler();

// Start the initial runnable task by posting through the handler


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pet = new Pet("Taco");
        game = new Game(pet);

        vibrator = (Vibrator) GameActivity.this.getSystemService(Context.VIBRATOR_SERVICE);

//      Start up the game
        healthBar = findViewById(R.id.healthBarID);
        level = findViewById(R.id.levelTextViewID);
        lovePoints = findViewById(R.id.lovePointsTextViewID);
        name = findViewById(R.id.nameTextViewID);
        petImage = findViewById(R.id.petImageID);

        refresh();

        handler.post(runnableCode);

        dogImageFrameIndex = 0;
        handler.postDelayed(updateDogImageFrameRunnable, 100);

//      Load previous status TODO

    }

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            Log.d("Handlers", "Called on main thread");
            pet.decreaseHealthByOne();
            handler.postDelayed(runnableCode, 1000);
            if (pet.getHealthPoints() <= 0) {
                finish();
            }
            refresh();
        }
    };

    private Runnable updateDogImageFrameRunnable = new Runnable() {
        @Override
        public void run() {
            ImageView dogImageView = findViewById(R.id.petImageID);

            dogImageFrameIndex++;

            if (dogImageFrameIndex > 3) {
                dogImageFrameIndex = 0;
            }

            int dogImageFrameResourceId = getResources().getIdentifier("frame_" + dogImageFrameIndex + "_vectormagic_inkscape_svg2android", "drawable", getPackageName());
            dogImageView.setImageResource(dogImageFrameResourceId);

            handler.postDelayed(updateDogImageFrameRunnable, 100);
        }
    };

    public void refresh() {
        String levelString = ""+pet.getLevel();
        level.setText(levelString);
        if (pet.getLevel() == 5){
            name.setText("Evil " + pet.getName());
        } else{
            name.setText(pet.getName());
        }

        healthBar.setProgress(pet.getHealthPoints());
        String loveString = ""+pet.getLovePoints();
        lovePoints.setText(loveString);
    }

public void onPetClicked(View view) {
        vibrator.vibrate(25);
        if (pet.getLevel() == 5){
            pet.decreaseHealthByOne();
            Toast.makeText(this, "Why are you stabbing him?!", Toast.LENGTH_SHORT).show();
        } else {
            pet.addLovePoint();
        }
        refresh();
    }

    public void onFeedTreatClicked(View view) {
        if (pet.canAffordThisFood(Foods.TREAT.getCostOfFood())) {
            Toast.makeText(this, "A yummy treat for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.TREAT);
        } else {
            Toast.makeText(this, "You can't afford this yet", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void onFeedBowlClicked(View view) {
        if (pet.canAffordThisFood(Foods.BOWL.getCostOfFood())) {
            Toast.makeText(this, "A bowl of chow for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.BOWL);
        } else {
            Toast.makeText(this, "You can't afford this yet", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void onFeedBigBowlClicked(View view) {
        if (pet.canAffordThisFood(Foods.BIGBOWL.getCostOfFood())) {
            Toast.makeText(this, "A massive bowl of chow for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.BIGBOWL);
        } else {
            Toast.makeText(this, "You can't afford this yet", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void onFeedRibsClicked(View view) {
        if (pet.canAffordThisFood(Foods.RIBS.getCostOfFood())) {
            Toast.makeText(this, "Some tasty ribs for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.RIBS);
        } else {
            Toast.makeText(this, "You can't afford this yet", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void onFeedChickenClicked(View view) {
        if (pet.canAffordThisFood(Foods.CHICKEN.getCostOfFood())) {
            Toast.makeText(this, "A couple of chicken drumsticks for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.CHICKEN);
        } else {
            Toast.makeText(this, "You can't afford this yet", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void onFeedSteakClicked(View view) {
        if (pet.canAffordThisFood(Foods.STEAK.getCostOfFood())) {
            Toast.makeText(this, "A juicy steak for " + pet.getName(), Toast.LENGTH_SHORT).show();
            game.feed(Foods.STEAK);
        } else {
            Toast.makeText(this, "You can't afford this yet", Toast.LENGTH_SHORT).show();
        }
        refresh();
    }

    public void onLevelUpClicked(View view) {
        if (pet.getLovePoints() >= 100) {
            pet.levelUp();
            if (pet.getLevel() == 5){
                View backgroundLayout = findViewById(R.id.backgroundLayoutID);
                backgroundLayout.setBackground(getResources().getDrawable(R.drawable.backgrounddark));
                pet.setLovePoints(0);
            }
            Toast.makeText(this, pet.getName() + " is now level " + pet.getLevel() + "!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You need 100 love points to level up " + pet.getName(), Toast.LENGTH_SHORT).show();
        }

        refresh();
    }

    //Loading and Saving game
    private Game loadGame() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        String gameSaved = sharedPref.getString("saved_game", "{}");
        Gson gson = new Gson();
        Game myGame = gson.fromJson(gameSaved, Game.class);
        return myGame;
    }

    private void saveGame(Game game) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        editor.putString("saved_game", gson.toJson(game));
        editor.apply();
    }

}

