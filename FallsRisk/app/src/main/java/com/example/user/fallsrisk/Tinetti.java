package com.example.user.fallsrisk;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Tinetti extends AppCompatActivity {

    protected int score = 0; //answer score
    protected int PreviousScore;
    private int i = 1;
    protected Vibrator myVib;
    protected static Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinetti);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        set(); //declaring text views and buttons
        declaration();
        question(); //call params for question

        //button listener, when button clicked, produce output on textfield "Score"
        model.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                PreviousScore = score;

                //Score.setText(String.valueOf(action()));
                //cs.setText(String.valueOf(score));
                //Score.setText(String.valueOf(score));
                i++;

                //If answer not selected
                /*if (r.getCheckedRadioButtonId() == -1)
                {
                    unticked.setVisibility(View.VISIBLE);
                    unticked.setText("Please Select An Answer");
                }
                else*/
                question();


                model.getR().clearCheck();
                //cs.setText("Current Score: " + String.valueOf(score));

            }

        });

        model.getNext_test().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                //main.beginGAIT();
            }

        });

    }


    private void question() {
        String[] question = getResources().getStringArray(R.array.Tinetti_Balance_question);
        String[] answerA = getResources().getStringArray(R.array.Tinetti_Balance_answerA);
        String[] answerB = getResources().getStringArray(R.array.Tinetti_Balance_answerB);
        String[] answerC = getResources().getStringArray(R.array.Tinetti_Balance_answerC);
        String[] answerD = getResources().getStringArray(R.array.Tinetti_Balance_answerD);

        model.getUnticked().setVisibility(View.INVISIBLE);

        if (i + 1 > question.length) {
            findViewById(R.id.Score).setVisibility(View.VISIBLE);
            model.getT().setText("Final Score");
            model.getT().setVisibility(View.VISIBLE);
            model.getA().setVisibility(View.INVISIBLE);
            model.getB().setVisibility(View.INVISIBLE);
            model.getC().setVisibility(View.INVISIBLE);
            model.getD().setVisibility(View.INVISIBLE);
            model.getNext_test().setVisibility(View.VISIBLE);
            model.getButton().setVisibility(View.INVISIBLE);
        } else {
            model.getScore().setVisibility(View.GONE);
            model.getT().setText(question[i]);
            model.getA().setText(answerA[i]);
            model.getB().setText(answerB[i]);
            model.getC().setText(answerC[i]);
            model.getD().setText(answerD[i]);

            model.getC().setVisibility(View.VISIBLE);
            model.getD().setVisibility(View.VISIBLE);

            //if string is null hide answer
            if (answerC[i].equals("null"))
                model.getC().setVisibility(View.INVISIBLE);
            if (answerD[i].equals("null"))
                model.getD().setVisibility(View.INVISIBLE);
        }

    }

    public void declaration() {

        model.getR().setVisibility(View.VISIBLE);
        model.getCC().setVisibility(View.GONE);
        model.getDD().setVisibility(View.GONE);
        model.getE().setVisibility(View.GONE);
        model.getF().setVisibility(View.GONE);
        model.getG().setVisibility(View.GONE);
        model.getH().setVisibility(View.GONE);
        model.getButton().setVisibility(View.VISIBLE);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        myVib.vibrate(50);

        // Check which radio button was clicked
        switch (view.getId()) {
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
        model.setCs((TextView) findViewById(R.id.currentscore));
        model.setScore((TextView) findViewById(R.id.Score));
        model.setUnticked((TextView) findViewById(R.id.please_answer));
        model.setCC((TextView) findViewById(R.id.Answer2C));
        model.setDD((TextView) findViewById(R.id.Answer2D));
        model.setE((TextView) findViewById(R.id.AnswerE));
        model.setF((TextView) findViewById(R.id.AnswerF));
        model.setG((TextView) findViewById(R.id.AnswerG));
        model.setH((TextView) findViewById(R.id.AnswerH));
        model.setMyVib((Vibrator) this.getSystemService(VIBRATOR_SERVICE));
        model.setNext_test((Button) findViewById(R.id.Next_Test));
        model.setR((RadioGroup) findViewById(R.id.radioGroup));
        model.setButton((Button) findViewById(R.id.button));
    }
}

    class Tinetti_GAIT extends Tinetti {

        private int i = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tinetti);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

            declaration();
            set();
            model.getNext_test().setVisibility(View.INVISIBLE);
            question(); //call params for question

            //button listener, when button clicked, produce output on textfield "Score"
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myVib.vibrate(70);
                    PreviousScore = score;

                    Score.setText(String.valueOf(action()));
                    cs.setText(String.valueOf(score));
                    i++;
                    //If answer not selected
                    if (r.getCheckedRadioButtonId() == -1) {
                        unticked.setVisibility(View.VISIBLE);
                        unticked.setText("Please Select An Answer");
                    } else {
                        if (j == 0) {
                            question2();
                            j++;
                        } else
                            question();

                        r.clearCheck();
                        cs.setText("Current Score: " + String.valueOf(score));

                        r.clearCheck();
                        cs.setText("Current Score: " + String.valueOf(score));

                    }

                }});

            next_test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myVib.vibrate(70);
                    main.Tinetti = false;
                    main.scale();
                }

            });

    }


        private void set() {
            model.setT((TextView) findViewById(R.id.Question));
            model.setA((TextView) findViewById(R.id.AnswerA));
            model.setB((TextView) findViewById(R.id.AnswerB));
            model.setC((TextView) findViewById(R.id.AnswerC));
            model.setD((TextView) findViewById(R.id.AnswerD));
            model.setCs((TextView) findViewById(R.id.currentscore));
            model.setScore((TextView) findViewById(R.id.Score));
            model.setUnticked((TextView) findViewById(R.id.please_answer));
            model.setCC((TextView) findViewById(R.id.Answer2C));
            model.setDD((TextView) findViewById(R.id.Answer2D));
            model.setE((TextView) findViewById(R.id.AnswerE));
            model.setF((TextView) findViewById(R.id.AnswerF));
            model.setG((TextView) findViewById(R.id.AnswerG));
            model.setH((TextView) findViewById(R.id.AnswerH));
            model.setMyVib((Vibrator) this.getSystemService(VIBRATOR_SERVICE));
            model.setNext_test((Button) findViewById(R.id.Next_Test));
            model.setR((RadioGroup) findViewById(R.id.radioGroup));
            model.setButton((Button) findViewById(R.id.button));
        }

    }


