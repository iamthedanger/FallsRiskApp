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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FRAT extends AppCompatActivity {

    private int score = 0; //answer score
    private int PreviousScore;
    private int i = 1;
    private Vibrator myVib;
    private static Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        //model.setFRAT(getIntent().getExtras().getBoolean("FRAT"));
        //model.setFRAT(true);

        set();
        questionOne(); //call params for question

        //button listener, when button clicked, produce output on textfield "Score"
        model.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                PreviousScore = score;

                //Score.setText(String.valueOf(action()));
                //model.getScore().setText(String.valueOf(score));
//                model.getCs().setText(String.valueOf(score));
                i++;

                //If answer not selected
                if (model.getR().getCheckedRadioButtonId() == -1) {
                    model.getUnticked().setVisibility(View.VISIBLE);
                    model.getUnticked().setText("Please Select An Answer");
                } else
                    hide();
                question();


                model.getR().clearCheck();
//                model.getCs().setText("Current Score: " + String.valueOf(score));

            }

        });

        model.getNext_test().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                model.setFRAT(false);
                //main.scale();
            }

        });
    }

    private void questionOne(){
        String[] question = getResources().getStringArray(R.array.FRAT_Question);
        String[] answerA = getResources().getStringArray(R.array.FRAT_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.FRAT_AnswerB);
        String[] answerC = getResources().getStringArray(R.array.FRAT_AnswerC);
        String[] answerD = getResources().getStringArray(R.array.FRAT_AnswerD);

        model.getT().setText(question[i]);
        model.getE().setText(answerA[i]);
        model.getF().setText(answerB[i]);
        model.getG().setText(answerC[i]);
        model.getH().setText(answerD[i]);
        model.getE().setVisibility(View.VISIBLE);
        model.getF().setVisibility(View.VISIBLE);
        model.getG().setVisibility(View.VISIBLE);
        model.getH().setVisibility(View.VISIBLE);
        model.getD().setY(120);
        model.getR().setVisibility(View.VISIBLE);
        model.getA().setVisibility(View.GONE);
        model.getB().setVisibility(View.GONE);
        model.getC().setVisibility(View.GONE);
        model.getD().setVisibility(View.GONE);
        model.getCC().setVisibility(View.GONE);
        model.getDD().setVisibility(View.GONE);
    }

    private void question(){

        String[] question = getResources().getStringArray(R.array.FRAT_Question);
        String[] answerA = getResources().getStringArray(R.array.FRAT_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.FRAT_AnswerB);
        String[] answerC = getResources().getStringArray(R.array.FRAT_AnswerC);
        String[] answerD = getResources().getStringArray(R.array.FRAT_AnswerD);

        model.getUnticked().setVisibility(View.INVISIBLE);

        if(i+1 > question.length){
            model.getScore().setVisibility(View.VISIBLE);
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
//            model.getScore().setVisibility(View.GONE);
            model.getT().setText(question[i]);
            model.getA().setText(answerA[i]);
            model.getB().setText(answerB[i]);
            model.getC().setText(answerC[i]);
            model.getD().setText(answerD[i]);

            model.getC().setVisibility(View.VISIBLE);
            model.getD().setVisibility(View.VISIBLE);

            //if string is null hide answer
            if(answerC[i].equals("null"))
                model.getC().setVisibility(View.INVISIBLE);
            if(answerD[i].equals("null"))
                model.getD().setVisibility(View.INVISIBLE);
        }

    }


    //hiding buttons after questionOne
    private void hide(){
        model.getA().setVisibility(View.VISIBLE);
        model.getB().setVisibility(View.VISIBLE);
        model.getC().setVisibility(View.VISIBLE);
        model.getD().setVisibility(View.VISIBLE);
        model.getE().setVisibility(View.GONE);
        model.getF().setVisibility(View.GONE);
        model.getG().setVisibility(View.GONE);
        model.getH().setVisibility(View.GONE);
    }

    private void set(){
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        myVib.vibrate(50);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.AnswerA:
                if (checked)
                    score = PreviousScore + 1;
                break;
            case R.id.AnswerB:
                if (checked)
                    score = PreviousScore + 2;
                break;
            case R.id.AnswerC:
                if (checked)
                    score = PreviousScore + 3;
                break;
            case R.id.AnswerD:
                if (checked)
                    score = PreviousScore + 4;
                break;
            case R.id.AnswerE:
                if (checked)
                    score = PreviousScore + 2;
                break;
            case R.id.AnswerF:
                if (checked)
                    score = PreviousScore + 4;
                break;
            case R.id.AnswerG:
                if (checked)
                    score = PreviousScore + 6;
                break;
            case R.id.AnswerH:
                if (checked)
                    score = PreviousScore + 8;
                break;
        }
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
        intent.putExtra("FRAT", model.getFRAT().booleanValue());
        startActivity(intent);
    }


}


