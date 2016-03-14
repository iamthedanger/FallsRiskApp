package com.example.user.fallsrisk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MorseFalls extends AppCompatActivity {

    private int score = 0; //answer score
    private int PreviousScore;
    private int i = 1;
    private Vibrator myVib;
    private static Model model = new Model();
    public static NextActivity NextAct = new NextActivity();
    private Boolean FRAT = false;
    private Boolean MORSE = false;
    private Boolean TINETTI = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse_falls);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //passing intent
        Bundle bundle = getIntent().getExtras();
        FRAT = bundle.getBoolean("FRAT");

        //declaring visibility of textviews and buttons
        //main.set();
        set();
        declaration();
        //model.getT().setVisibility(View.VISIBLE);
        //model.getCs().setText("Tester Cs");
        //model.getT().setText("Tester");
        model.getCs().setVisibility(View.GONE);
        model.getCC().setVisibility(View.GONE);
        model.getDD().setVisibility(View.GONE);
        findViewById(R.id.button).setVisibility(View.VISIBLE);

        //Morse Falls question one
        questionOne();
        PreviousScore = score;
        //button listener, when button clicked, produce output on textfield "Score"
        model.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                PreviousScore = score;

                //Score.setText(String.valueOf(action()));
                model.getScore().setText(String.valueOf(score));
                model.getCs().setText(String.valueOf(score));
                i++;

                /*/If answer not selected display "Please select answer
                if (model.getR().getCheckedRadioButtonId() == -1) {
                    model.getUnticked().setVisibility(View.VISIBLE);
                    model.getUnticked().setText("Please Select An Answer");
                } else {*/
                    //Loop through questions
                    if (i == 1)
                        questionOne();
                    if (i == 2)
                        questionTwo();
                    if (i == 3)
                        questionThree();
                    if (i == 4)
                        questionFour();
                    if (i == 5)
                        questionFive();
                    if (i == 6)
                        questionSix();
                    if (i == 7)
                        MorseFinish();
                //}

                //For testing purpose keep displaying score after each answer
                model.getR().clearCheck();
                model.getCs().setText("Current Score: " + String.valueOf(score));


            }

        });

        //set Morse to false then call scalr question which shows which scale to complete next
        model.getNext_test().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                Model.setMorse(false);
                scale();
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_morse_falls, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void declaration(){
        model.getNext_test().setText("Continue");
        model.getR().setVisibility(View.VISIBLE);
        model.getB().setVisibility(View.VISIBLE);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
    }


    //scoring system
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        myVib.vibrate(70);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.AnswerA:
                if (checked)
                    score = PreviousScore;
                break;
            case R.id.AnswerB:
                if (checked)
                    score = PreviousScore + 15;
                break;
            case R.id.AnswerC:
                if (checked)
                    score = PreviousScore + 30;
                break;
            case R.id.AnswerD:
                if (checked)
                    score = PreviousScore + 25;
                break;
            //question 4 part B
            case R.id.AnswerF:
                if (checked)
                    score = PreviousScore + 20;
                break;
            //question 5 part C
            case R.id.AnswerE:
                if (checked)
                    score = PreviousScore + 10;
                break;
        }
    }

    /*
    Questions
     */
    private void questionOne(){
        String[] question = getResources().getStringArray(R.array.Morse_Question);
        String[] answerA = getResources().getStringArray(R.array.Morse_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.Morse_AnswerB);
        model.getT().setText(question[0]);
        model.getA().setText(answerA[0]);
        model.getD().setText(answerB[0]);
        model.getT().setVisibility(View.VISIBLE);
        model.getA().setVisibility(View.VISIBLE);
        model.getD().setVisibility(View.VISIBLE);
        model.getC().setVisibility(View.GONE);
        model.getB().setVisibility(View.GONE);
        model.getE().setVisibility(View.GONE);
        model.getF().setVisibility(View.GONE);
        model.getG().setVisibility(View.GONE);
        model.getH().setVisibility(View.GONE);
    }

    //A = 0, B = 15, C = 30, D = 25, F = 20, E = 10
    private void questionTwo(){
        String[] question = getResources().getStringArray(R.array.Morse_Question);
        String[] answerA = getResources().getStringArray(R.array.Morse_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.Morse_AnswerB);
        model.getT().setText(question[1]);
        model.getA().setText(answerA[1]);
        model.getB().setText(answerB[1]);
        model.getB().setVisibility(View.VISIBLE);
        model.getD().setVisibility(View.GONE);
        model.getE().setVisibility(View.GONE);
        model.getF().setVisibility(View.GONE);
        model.getG().setVisibility(View.GONE);
        model.getH().setVisibility(View.GONE);
    }

    //A = 0, B = 15, C = 30, D = 25, F = 20, E = 10
    private void questionThree(){
        String[] question = getResources().getStringArray(R.array.Morse_Question);
        String[] answerA = getResources().getStringArray(R.array.Morse_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.Morse_AnswerB);
        String[] answerC = getResources().getStringArray(R.array.Morse_AnswerC);
        model.getT().setText(question[2]);
        model.getA().setText(answerA[2]);
        model.getB().setText(answerB[2]);
        model.getC().setText(answerC[2]);
        model.getA().setVisibility(View.VISIBLE);
        model.getD().setVisibility(View.VISIBLE);
        model.getC().setVisibility(View.VISIBLE);
        model.getD().setVisibility(View.GONE);
        model.getE().setVisibility(View.GONE);
        model.getF().setVisibility(View.GONE);
        model.getG().setVisibility(View.GONE);
        model.getH().setVisibility(View.GONE);
    }

    //A = 0, B = 15, C = 30, D = 25, F = 20, E = 10
    private void questionFour(){
        String[] question = getResources().getStringArray(R.array.Morse_Question);
        String[] answerA = getResources().getStringArray(R.array.Morse_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.Morse_AnswerB);
        model.getT().setText(question[3]);
        model.getA().setText(answerA[3]);
        model.getF().setText(answerB[3]);
        model.getA().setVisibility(View.VISIBLE);
        model.getF().setVisibility(View.VISIBLE);
        model.getC().setVisibility(View.GONE);
        model.getB().setVisibility(View.GONE);
        model.getD().setVisibility(View.GONE);
    }

    //A = 0, B = 15, C = 30, D = 25, F = 20, E = 10
    private void questionFive(){
        String[] question = getResources().getStringArray(R.array.Morse_Question);
        String[] answerA = getResources().getStringArray(R.array.Morse_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.Morse_AnswerB);
        String[] answerC = getResources().getStringArray(R.array.Morse_AnswerC);
        model.getT().setText(question[4]);
        model.getA().setText(answerA[4]);
        model.getE().setText(answerB[4]);
        model.getF().setText(answerC[4]);
        model.getE().setVisibility(View.VISIBLE);
        model.getF().setVisibility(View.VISIBLE);
    }

    //A = 0, B = 15, C = 30, D = 25, F = 20, E = 10
    private void questionSix(){
        String[] question = getResources().getStringArray(R.array.Morse_Question);
        String[] answerA = getResources().getStringArray(R.array.Morse_AnswerA);
        String[] answerB = getResources().getStringArray(R.array.Morse_AnswerB);
        model.getT().setText(question[5]);
        model.getA().setText(answerA[5]);
        model.getB().setText(answerB[5]);
        model.getB().setVisibility(View.VISIBLE);
        model.getE().setVisibility(View.GONE);
        model.getF().setVisibility(View.GONE);
    }

    //Display Morse Score and show advance button
    private void MorseFinish(){
        model.getA().setVisibility(View.GONE);
        model.getB().setVisibility(View.GONE);
        model.getButton().setVisibility(View.GONE);
        model.getT().setText("Final Morse Score");
        model.getNext_test().setVisibility(View.VISIBLE);
        model.getScore().setVisibility(View.VISIBLE);
        model.getButton().setVisibility(View.VISIBLE);
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
        //intent.putExtra("FRAT", model.getFRAT().booleanValue());
        startActivity(intent);
    }

    public void scale(){
        //if(model.getTinetti() == true)
        //beginbalannce();
        //
        //else if(model.getEfficacy() == true)
        //beginEfficacy();
        if(MORSE == true)
            beginMorse();
        else if(FRAT == true)
            beginFRAT();
        //else display score
    }

}
