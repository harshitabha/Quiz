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
    private int qNum; // index of the question we are on in the qList
    private ArrayList<ArrayList<Double>> ansChoices;

    //progress bar stuff
    private int currentProgress = 0;
    private ProgressBar progressBar;

    private Button submit;
    private boolean isSubmit;
    private TextView q;
    private Button[] choices;
    private ArrayList<Boolean> choiceClicked = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the variables
        progressBar = findViewById(R.id.progressBar);
        submit = findViewById(R.id.submit);
        isSubmit = true;
        q = findViewById(R.id.question);
        qNum = 0;

        // initialize the choice buttons
        choices = new Button[4];
        choiceClicked = new ArrayList<Boolean>(); // shows which button is selected


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
            choiceClicked.add(false); // initialize the choice clicked array
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
        
        // setting up what that page looks like when it opens
        q.setText(qList[qNum]);


    }

    @Override
    public void onClick(View v) {
        /* Start Button */


        /* selecting an ans choice */

        String choiceID = v.getResources().getResourceEntryName(v.getId()); // get the id of the clicked button
        int choiceIndex = Integer.parseInt(choiceID.substring(choiceID.length() - 1)); // the index of the button in the list

        // if an answer was already picked
        if(choiceClicked.contains(true)){
            // reset the list
            for(int f = 0; f < choiceClicked.size(); f++)
            {
                choiceClicked.set(f, false);
                choices[f].setBackgroundColor(Color.parseColor("#d4d4d4"));
            }
        }
        choiceClicked.set(choiceIndex, true); // update the choice clicked array
        choices[choiceIndex].setBackgroundColor(Color.parseColor("#9e9e9e")); // make the selected choice button darker


        /* Onclick listener for the submit button */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkAns(); //
            }
        });
    }
}