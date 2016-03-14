package com.example.user.fallsrisk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ChooseScale extends AppCompatActivity {

    private Vibrator myVib;
    private static Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_scale);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        model.setTinetti(false);
        model.setFRAT(false);
        model.setEfficacy(false);
        model.setMorse(false);
        set();

        //If Tinetti check box selected, then return true
        model.getCheckTinetti().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.getCheckTinetti().isChecked()) {
                    model.setTinetti(true);
                } else {
                    model.setTinetti(false);
                }
            }
        });

        //If FRAT check box selected, then return true
        model.getCheckFRAT().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.getCheckFRAT().isChecked()) {
                    model.setFRAT(true);
                } else {
                    model.setFRAT(false);
                }
            }
        });

        //If Efficacy check box selected, then return true
        model.getCheckEfficacy().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.getCheckEfficacy().isChecked()) {
                    model.setEfficacy(true);
                } else {
                    model.setEfficacy(false);
                }
            }
        });

        //If Morse check box selected, then return true
        model.getCheckMorse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (model.getCheckMorse().isChecked()) {
                    model.setMorse(true);
                } else {
                    model.setMorse(false);
                }
            }
        });

        //submit button
        //here I want to go through scales selected
        model.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                //go to chosen scale
                scale();
            }

        });
    }

    private void set(){
        model.setT((TextView) findViewById(R.id.title));
        model.setCheckMorse((CheckBox) findViewById(R.id.checkMorse));
        model.setCheckTinetti((CheckBox) findViewById(R.id.checkTinetti));
        model.setCheckEfficacy((CheckBox) findViewById(R.id.checkEfficacy));
        model.setCheckFRAT((CheckBox) findViewById(R.id.checkFRAT));
        model.setButton((Button) findViewById(R.id.button));
    }

    public void scale(){
        //if(model.getTinetti() == true)
            //beginbalannce();
       // ;
        //else if(model.getEfficacy() == true)
            //beginEfficacy();
        if(model.getMorse() == true)
            beginMorse();
        else if(model.getFRAT() == true)
            beginFRAT();
        //else display score
    }

    //Morse Falls
    public void beginMorse() {
        // Start intent here
        Intent intent = new Intent(this, MorseFalls.class);
        intent.putExtra("intVariableName", 0);
        startActivity(intent);
    }

    //FRAT
    public void beginFRAT() {
        // Start intent here
        Intent intent = new Intent(this, FRAT.class);
        intent.putExtra("FRAT", true);
        startActivity(intent);
    }


    /*
    //Falls Efficacy Scale
    public void beginEfficacy() {
        // Start intent here
        Intent intent = new Intent(this, FallsEfficacyScale.class);
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
    }*/

}
