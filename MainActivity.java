package com.example.quiz;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


//code as of 10:47 9/22

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] qList;
    private ArrayList<ArrayList<Double>> ansChoices;

    //progress bar stuff
    private int currentProgress = 0;
    private ProgressBar progressBar;

    private Button submit;
    private boolean isSubmit;
    private TextView q;
    private Button[] choices;
    private boolean[] choiceClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the variables
        progressBar = findViewById(R.id.progressBar);
        submit = findViewById(R.id.submit);
        isSubmit = true;
        q = findViewById(R.id.question);

        // initialize the choice buttons
        choices = new Button[4];
        choiceClicked = new boolean[4]; // shows which button is selected
        for(boolean test : choiceClicked){
            System.out.println(test);
        }

        for(int i = 0; i < choices.length; i++) {
            // cant just use this string in the find view by ide function because it doesn't accept a string
            String btnID = "choice" + i;

            //this part of code is to get a button by an id that we determine using the string above
            int resourceID = getResources().getIdentifier(btnID, "id",
                    getPackageName());
            choices[i] = (Button) findViewById(resourceID);
            choices[i].setBackgroundColor(Color.parseColor("#d4d4d4"));
            //what to do when the button is pressed
            choices[i].setOnClickListener(this);
            choiceClicked[i] = false;
        }

        // initialize questions and answers list
        qList = new String[10];
        ansChoices = new ArrayList<ArrayList<Double>>();

        //generate the question list
        Test ques;
        for(int i = 0; i < 10; i++)
        {
            ques = new Test();
            // add the question and ans choices to their lists
            qList[i] = ques.toString();
            ansChoices.add(ques.answerChoices()); // add the ans choices for each question
        }


    }

    /*
  https://www.youtube.com/watch?v=vFziVSSIX6Q&list=PLxzIyQWl5sMNvkLJ3yARdx7n7xSlRviI5&index=8
    */
    @Override
    public void onClick(View v) {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkAns(); //
            }
        });
    }
}