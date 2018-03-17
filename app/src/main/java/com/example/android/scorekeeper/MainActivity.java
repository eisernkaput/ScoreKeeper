package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scorePointsA;
    int scorePointsB;
    int setNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addOnePointA(View view) {
        scorePointsA++;
        displaySetNum(scorePointsA, scorePointsB);
    }

    public void redCardA(View view) {
        if (scorePointsA > 0) {
            scorePointsA--;
        }
        displayForTeamA(scorePointsA);


    }

    public void addOnePointB(View view) {
        scorePointsB++;
        displaySetNum(scorePointsA, scorePointsB);

    }

    public void redCardB(View view) {
        if (scorePointsB > 0) {
            scorePointsB--;
        }
        displayForTeamB(scorePointsB);
    }


    public void resetScore(View view) {
        scorePointsA = 0;
        scorePointsB = 0;
        displayForTeamA(scorePointsA);
        displayForTeamB(scorePointsB);

        setNum = 1;

        String message = getString(R.string.setNum);
        TextView setView = findViewById(R.id.setNumber);
        setView.setText(message);

        String score = getString(R.string.emptySpace);

        TextView setOneA = findViewById(R.id.textScoreASetOne);
        setOneA.setText(score);
        TextView setOneB = findViewById(R.id.textScoreBSetOne);
        setOneB.setText(score);

        TextView setTwoA = findViewById(R.id.textScoreASetTwo);
        setTwoA.setText(score);
        TextView setTwoB = findViewById(R.id.textScoreBSetTwo);
        setTwoB.setText(score);

        TextView setThreeA = findViewById(R.id.textScoreASetThree);
        setThreeA.setText(score);
        TextView setThreeB = findViewById(R.id.textScoreBSetThree);
        setThreeB.setText(score);


    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_Score_A);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the given score for Team B.
     */

    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_Score_B);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Changing the set number, and  results in table.
     */

    public void displaySetNum(int a, int b) {

        displayForTeamA(scorePointsA);
        displayForTeamB(scorePointsB);

        String message = getString(R.string.setNum1) + setNum;

        TextView setView = findViewById(R.id.setNumber);
        setView.setText(message);

        String scoreA = String.valueOf(scorePointsA);
        String scoreB = String.valueOf(scorePointsB);

        TextView setOneA = findViewById(R.id.textScoreASetOne);
        TextView setOneB = findViewById(R.id.textScoreBSetOne);

        TextView setTwoA = findViewById(R.id.textScoreASetTwo);
        TextView setTwoB = findViewById(R.id.textScoreBSetTwo);

        TextView setThreeA = findViewById(R.id.textScoreASetThree);
        TextView setThreeB = findViewById(R.id.textScoreBSetThree);


        if ((a >= 25 || b >= 25) && (((a - b) >= 2) || ((a - b) <= -2))) {


            setNum++;
            setView.setText(message);

            if (setNum == 2) {

                setOneA.setText(scoreA);
                setOneB.setText(scoreB);

                if (scorePointsA > scorePointsB) {
                    setOneA.setTextColor(getResources().getColor((R.color.text_color_green)));
                    setOneB.setTextColor(getResources().getColor((R.color.text_color_red)));
                } else {
                    setOneA.setTextColor(getResources().getColor((R.color.text_color_red)));
                    setOneB.setTextColor(getResources().getColor((R.color.text_color_green)));

                }

            }

            if (setNum == 3) {

                setTwoA.setText(scoreA);
                setTwoB.setText(scoreB);

                if (scorePointsA > scorePointsB) {
                    setTwoA.setTextColor(getResources().getColor((R.color.text_color_green)));
                    setTwoB.setTextColor(getResources().getColor((R.color.text_color_red)));
                } else {
                    setTwoA.setTextColor(getResources().getColor((R.color.text_color_red)));
                    setTwoB.setTextColor(getResources().getColor((R.color.text_color_green)));

                }

            }

            scorePointsA = 0;
            scorePointsB = 0;
            displayForTeamA(scorePointsA);
            displayForTeamB(scorePointsB);


            if (setNum > 3) {
                setNum = 1;
                setView.setText(message);

                setThreeA.setText(scoreA);
                setThreeB.setText(scoreB);

                if (scorePointsA > scorePointsB) {
                    setThreeA.setTextColor(getResources().getColor((R.color.text_color_green)));
                    setThreeB.setTextColor(getResources().getColor((R.color.text_color_red)));
                } else {
                    setThreeA.setTextColor(getResources().getColor((R.color.text_color_red)));
                    setThreeB.setTextColor(getResources().getColor((R.color.text_color_green)));

                }

                scorePointsA = 0;
                scorePointsB = 0;
                displayForTeamA(scorePointsA);
                displayForTeamB(scorePointsB);
            }
        }
    }

}





