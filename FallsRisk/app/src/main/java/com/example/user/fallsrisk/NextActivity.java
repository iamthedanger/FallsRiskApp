package com.example.user.fallsrisk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 13/03/2016.
 */
public class NextActivity extends AppCompatActivity{

    //Morse Falls
    public void beginMorse() {
        // Start intent here
        Intent intent = new Intent(this, MorseFalls.class);
        startActivity(intent);
    }
    /*public void beginFRAT() {
        // Start intent here
        Intent intent = new Intent(this, FRAT.class);
        intent.putExtra("intVariableName", 0);
        startActivity(intent);
    }



    //Falls Efficacy Scale
    public void beginEfficacy() {
        // Start intent here
        Intent intent = new Intent(this, FallsEfficacyScale.class);
        intent.putExtra("intVariableName", 0);
        startActivity(intent);
    }

    public void IDnumber() {
        // Start intent here
        Intent intent = new Intent(this, IDnumber.class);
        intent.putExtra("intVariableName", 0);
        startActivity(intent);
    }

    public void beginbalannce() {
        // Start intent here
        Intent intent = new Intent(this, Tinetti_Balance.class);
        //intent.putExtra("intVariableName", s);
        startActivity(intent);
    }

    public void beginGAIT() {
        // Start intent here
        Intent intent = new Intent(this, Tinetti_GAIT.class);
        //intent.putExtra("intVariableName", s);
        startActivity(intent);
    }

    public void LogIn() {
        // Start intent here
        Intent intent = new Intent(this, LogIn.class);
        //intent.putExtra("intVariableName", s);
        startActivity(intent);
    }

    protected void scale(){
        if(MainActivity.Tinetti == true)
            beginbalannce();
        else if(MainActivity.FRAT == true)
            beginFRAT();
        else if(MainActivity.Efficacy == true)
            beginEfficacy();
        else if(MainActivity.Morse == true)
            beginMorse();
        //else display score
    }*/


}
