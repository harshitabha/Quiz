package com.example.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/*Creates a Question or mathematical problem along with the answer and three fake answers to choose from.*/
public class Test {
    Random r = new Random();
    /*terms in equation*/
    private double num1;
    private double num2;
    /*expression's operation (+-/x)*/
    private int op;
    /*Correct answer to the questions*/
    private double ans;
    /*number of correct answers*/
    static int correct;
    /*number of questions answered*/
  /*Fake answers
  private double fake1;
  private double fake2;
  private double fake3;*/
    private ArrayList<Double> aofn;

  /*creates a problem and answer
  This should be called with the next or the start button
  */

    public Test(){
        // initilize aofn
        aofn = new ArrayList<Double>();

        /*generates two terms from 0 to 20*/
        num1 = roundAvoid(r.nextDouble()*21);
        num2 = roundAvoid(r.nextDouble()*21);

        /*generates operation, then solves the expression*/
        op = r.nextInt(4);
        if(op==0){
            ans = roundAvoid(num1+num2)*1.00;
        }
        else if(op==1){
            ans = roundAvoid((1.0*num1)/num2)*1.00;
        }
        else if(op==2){
            ans = roundAvoid(num1*num2)*1.00;
        }
        else{
            ans = roundAvoid(num1-num2)*1.00;
        }

        for(int i = 0; i<3; i++)
        {
            aofn.add(retFakeAns());
        }
        aofn.add(ans);
        Collections.shuffle(aofn);
    }
    public static double roundAvoid(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    /*receives an answer and checks if it is correct
    This should be called with the submit button*/
    public boolean checkAnswer(double check){
        if(check==ans){
            correct++;
            return true;
        }
        return false;
    }
    /*Generates other answers for the questions
    called when pressed next or start*/
    public double retFakeAns(){
        double rd = roundAvoid(ans*r.nextDouble());
        return rd;
    }

    /*operation into text
    called by the to string function*/
    public String operation(){
        if(op==0){
            return "+";
        }
        if(op==1){
            return "/";
        }
        if(op==2){
            return "x";
        }
        return "-";
    }

    /*returns all answer options for a question*/
    public ArrayList<Double> answerChoices(){
        return aofn;
    }
    /*Called when displaying the question*/
    public String toString(){
        return num1 + " " + operation() + " " + num2;
    }
}