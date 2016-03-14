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
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    private Vibrator myVib;
    private static Model model = new Model();
    private NextActivity next = new NextActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myVib =    (Vibrator)this.getSystemService(VIBRATOR_SERVICE);
        set();

        //button listener, when button clicked, produce output on textfield "Score"
        model.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVib.vibrate(70);
                //beginMorse();
                enterID();
            }
        });

        model.getNext_test().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginChooseScales();
            }
        });



    }

    public void beginChooseScales() {
        // Start intent here
        Intent intent = new Intent(this, ChooseScale.class);
        startActivity(intent);
    }

     public void enterID(){
         model.getT().setText("Enter Patient ID");
         model.getUsername().setVisibility(View.GONE);
         model.getPass().setVisibility(View.GONE);
         model.getUserfield().setVisibility(View.GONE);
         model.getPassfield().setVisibility(View.GONE);
         model.setIDNum((EditText) findViewById(R.id.IDNum));
         model.getIDNum().setVisibility(View.VISIBLE);
         model.getNext_test().setText("Submit");
         model.getNext_test().setVisibility(View.VISIBLE);
     }



    private void set(){
        model.setT((TextView) findViewById(R.id.title));
        model.setCs((TextView) findViewById(R.id.currentscore));
        model.setUnticked((TextView) findViewById(R.id.please_answer));
        model.setB((Button) findViewById(R.id.button));
        model.setOldpatient((Button) findViewById(R.id.oldtest));
        model.setNewpatient((Button) findViewById(R.id.newtest));
        model.setUsername((TextView) findViewById(R.id.username));
        model.setPass((TextView) findViewById(R.id.password));
        model.setUserfield((EditText) findViewById(R.id.usernamefield));
        model.setPassfield((EditText) findViewById(R.id.passwordfield));
        model.setButton((Button) findViewById(R.id.button));
        model.setNext_test((Button) findViewById(R.id.Next_Test));

    }

}
