package com.example.user.fallsrisk;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Efficacy extends AppCompatActivity {

    private int score = 0; //answer score
    private int PreviousScore;
    private int i = 1;
    private Vibrator myVib;
    private static Model model = new Model();
    public static NextActivity NextAct = new NextActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efficacy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        set();
        question(); //call params for question
        //button listener, when button clicked, produce output on textfield "Score"
        model.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                PreviousScore = score;

                //Score.setText(String.valueOf(action()));
                //Score.setText(String.valueOf(score));
                //cs.setText(String.valueOf(score));
                i++;

                //If answer not selected
                if (model.getR().getCheckedRadioButtonId() == -1) {
                    model.getUnticked().setVisibility(View.VISIBLE);
                    model.getUnticked().setText("Please Select An Answer");
                } else
                    question();

                model.getR().clearCheck();
                //cs.setText("Current Score: " + String.valueOf(score));

            }

        });

        model.getNext_test().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                //main.Efficacy = false;
                //main.scale();
            }

        });

    }



    public void question(){


        String[] question = getResources().getStringArray(R.array.Efficacy_Question);
        String[] answerA = getResources().getStringArray(R.array.Efficacy_Answer);

        model.getUnticked().setVisibility(View.INVISIBLE);

        if(i+1 > question.length){
            findViewById(R.id.Score).setVisibility(View.VISIBLE);
            model.getT().setText("Final Score");
            model.getT().setVisibility(View.VISIBLE);
            model.getA().setVisibility(View.INVISIBLE);
            model.getB().setVisibility(View.INVISIBLE);
            model.getC().setVisibility(View.INVISIBLE);
            model.getD().setVisibility(View.INVISIBLE);
            model.getNext_test().setVisibility(View.VISIBLE);
            model.getButton().setVisibility(View.INVISIBLE);
        }
        else {
            findViewById(R.id.Score).setVisibility(View.GONE);
            model.getT().setText(question[i]);
            model.getA().setText(answerA[0]);
            model.getB().setText(answerA[1]);
            model.getC().setText(answerA[2]);

        }

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        myVib.vibrate(50);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.AnswerA:
                if (checked)
                    score = PreviousScore;
                break;
            case R.id.AnswerB:
                if (checked)
                    score = PreviousScore + 1;
                break;
            case R.id.AnswerC:
                if (checked)
                    score = PreviousScore + 2;
                break;
        }
    }

    private void set() {
        model.setT((TextView) findViewById(R.id.Question));
        model.setA((TextView) findViewById(R.id.AnswerA));
        model.setB((TextView) findViewById(R.id.AnswerB));
        model.setC((TextView) findViewById(R.id.AnswerC));
        model.setD((TextView) findViewById(R.id.AnswerD));
        model.setScore((TextView) findViewById(R.id.Score));
        model.setUnticked((TextView) findViewById(R.id.please_answer));
        model.setNext_test((Button) findViewById(R.id.Next_Test));
        model.setR((RadioGroup) findViewById(R.id.radioGroup));
        model.setButton((Button) findViewById(R.id.button));
    }
}
