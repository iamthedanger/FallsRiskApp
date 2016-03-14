package com.example.user.fallsrisk;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by user on 07/03/2016.
 */
public class Model {

    public static TextView T, A, B, C, D, E, F, G, H, CC, DD, cs, score, unticked, username, pass;
    public static EditText IDNum, passfield, userfield;
    public static Button next_test, button, newpatient, oldpatient;
    public static RadioGroup r;
    public static CheckBox checkTinetti, checkEfficacy, checkFRAT, checkMorse;
    public static Boolean FRAT, Tinetti, Efficacy, Morse;
    public static Vibrator myVib;


    public static EditText getPassfield() {
        return passfield;
    }

    public static void setPassfield(EditText passfield) {
        Model.passfield = passfield;
    }

    public static EditText getUserfield() {
        return userfield;
    }

    public static void setUserfield(EditText userfield) {
        Model.userfield = userfield;
    }

    public static EditText getIDNum() {
        return IDNum;
    }

    public static void setIDNum(EditText IDNum) {
        Model.IDNum = IDNum;
    }

    public static TextView getUsername() {
        return username;
    }

    public static void setUsername(TextView username) {
        Model.username = username;
    }

    public static TextView getPass() {
        return pass;
    }

    public static void setPass(TextView pass) {
        Model.pass = pass;
    }


    public static Vibrator getMyVib() {
        return myVib;
    }

    public static void setMyVib(Vibrator myVib) {
        Model.myVib = myVib;
    }

    public static Boolean getFRAT() {
        return FRAT;
    }

    public static void setFRAT(Boolean FRAT) {
        Model.FRAT = FRAT;
    }

    public static Boolean getTinetti() {
        return Tinetti;
    }

    public static void setTinetti(Boolean tinetti) {
        Tinetti = tinetti;
    }

    public static Boolean getEfficacy() {
        return Efficacy;
    }

    public static void setEfficacy(Boolean efficacy) {
        Efficacy = efficacy;
    }

    public static Boolean getMorse() {
        return Morse;
    }

    public static void setMorse(Boolean morse) {
        Morse = morse;
    }


    public static TextView getT() {
        return T;
    }

    public static void setT(TextView t) {
        T = t;
    }

    public static TextView getA() {
        return A;
    }

    public static void setA(TextView a) {
        A = a;
    }

    public static TextView getB() {
        return B;
    }

    public static void setB(TextView b) {
        B = b;
    }

    public static TextView getC() {
        return C;
    }

    public static void setC(TextView c) {
        C = c;
    }

    public static TextView getD() {
        return D;
    }

    public static void setD(TextView d) {
        D = d;
    }

    public static TextView getE() {
        return E;
    }

    public static void setE(TextView e) {
        E = e;
    }

    public static TextView getF() {
        return F;
    }

    public static void setF(TextView f) {
        F = f;
    }

    public static TextView getG() {
        return G;
    }

    public static void setG(TextView g) {
        G = g;
    }

    public static TextView getH() {
        return H;
    }

    public static void setH(TextView h) {
        H = h;
    }

    public static TextView getCC() {
        return CC;
    }

    public static void setCC(TextView CC) {
        Model.CC = CC;
    }

    public static TextView getDD() {
        return DD;
    }

    public static void setDD(TextView DD) {
        Model.DD = DD;
    }

    public static TextView getCs() {
        return cs;
    }

    public static void setCs(TextView cs) {
        Model.cs = cs;
    }

    public static TextView getScore() {
        return score;
    }

    public static void setScore(TextView score) {
        Model.score = score;
    }

    public static TextView getUnticked() {
        return unticked;
    }

    public static void setUnticked(TextView unticked) {
        Model.unticked = unticked;
    }

    public static Button getNext_test() {
        return next_test;
    }

    public static void setNext_test(Button next_test) {
        Model.next_test = next_test;
    }

    public static Button getButton() {
        return button;
    }

    public static void setButton(Button button) {
        Model.button = button;
    }

    public static Button getNewpatient() {
        return newpatient;
    }

    public static void setNewpatient(Button newpatient) {
        Model.newpatient = newpatient;
    }

    public static Button getOldpatient() {
        return oldpatient;
    }

    public static void setOldpatient(Button oldpatient) {
        Model.oldpatient = oldpatient;
    }

    public static RadioGroup getR() {
        return r;
    }

    public static void setR(RadioGroup r) {
        Model.r = r;
    }

    public static CheckBox getCheckTinetti() {
        return checkTinetti;
    }

    public static void setCheckTinetti(CheckBox checkTinetti) {
        Model.checkTinetti = checkTinetti;
    }

    public static CheckBox getCheckEfficacy() {
        return checkEfficacy;
    }

    public static void setCheckEfficacy(CheckBox checkEfficacy) {
        Model.checkEfficacy = checkEfficacy;
    }

    public static CheckBox getCheckFRAT() {
        return checkFRAT;
    }

    public static void setCheckFRAT(CheckBox checkFRAT) {
        Model.checkFRAT = checkFRAT;
    }

    public static CheckBox getCheckMorse() {
        return checkMorse;
    }

    public static void setCheckMorse(CheckBox checkMorse) {
        Model.checkMorse = checkMorse;
    }
}
