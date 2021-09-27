package com.example.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/*Creates a Question or mathematical problem along with the answer and three fake answers to choose from.*/
public class Test {
    Random r = new Random();
    /*terms in equation*/
    private int num1;
    private int num2;
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
        num1 = r.nextInt(20);
        num2 = r.nextInt(20);

        /*generates operation, then solves the expression*/
        op = r.nextInt(4);
        if(op==0){
            ans = num1+num2;
        }
        else if(op==1){
            ans = (1.0*num1)/num2;
        }
        else if(op==2){
            ans = num1*num2;
        }
        else{
            ans = num1-num2;
        }

        /*generate fake answers, then call the functions*/
    /*fake1 = retFakeAns();
    fake2 = retFakeAns();
    fake3 = retFakeAns();
    shuffles a list of 3 fakes and one correct ans
    */
        for(int i = 0; i<3; i++)
        {
            aofn.add(retFakeAns());
        }
        aofn.add(ans);
        Collections.shuffle(aofn);
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
        double rd = ans*r.nextDouble();
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