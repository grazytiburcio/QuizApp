package com.example.grazy.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the SUBMIT button is clicked.
     */
    public void submitQuiz(View view) {
        // Figure out if the user hit QUESTION 1
        RadioButton emmaRadioButton = findViewById(R.id.emma_right_d);
        boolean answerEmma = emmaRadioButton.isChecked();

        // Figure out if the user hit QUESTION 2
        RadioButton rembrandtsRadioButton = findViewById(R.id.rembrandts_right_d);
        boolean answerRembrandts = rembrandtsRadioButton.isChecked();

        // Figure out if the user hit QUESTION 3
        RadioButton omgRadioButton = findViewById(R.id.omg_right_d);
        boolean answerOmg = omgRadioButton.isChecked();

        // Figure out if the user hit QUESTION 4
        RadioButton rossAndRachelRadioButton = findViewById(R.id.ross_rachel_right_c);
        boolean answerRossAndRachel = rossAndRachelRadioButton.isChecked();

        // Figure out if the user hit QUESTION 5
        RadioButton alPacinoRadioButton = findViewById(R.id.al_pacino_right_a);
        boolean answerAlPacino = alPacinoRadioButton.isChecked();

        // Figure out if the user hit QUESTION 6
        RadioButton murielRadioButton = findViewById(R.id.muriel_right_d);
        boolean answerMuriel = murielRadioButton.isChecked();

        // Figure out if the user hit QUESTION 7
        RadioButton monicaRadioButton = findViewById(R.id.monica_right_a);
        boolean answerMonica = monicaRadioButton.isChecked();

        // Figure out if the user hit QUESTION 8
        RadioButton twoRadioButton = findViewById(R.id.two_right_c);
        boolean answerTwo = twoRadioButton.isChecked();

        // Figure out if the user hit QUESTION 9
        EditText joeyEditText = findViewById(R.id.joey_name_field);
        String answerJoey = joeyEditText.getText().toString();

        // Figure out if the user hit QUESTION 10
        CheckBox rossRachelCheckBox = findViewById(R.id.ross_rachel_checkbox);
        boolean answerRossRachel = rossRachelCheckBox.isChecked();
        CheckBox chandlerMonicaCheckBox = findViewById(R.id.chandler_monica_checkbox);
        boolean answerChandlerMonica = chandlerMonicaCheckBox.isChecked();
        CheckBox rossEmilyCheckBox = findViewById(R.id.ross_emily_checkbox);
        boolean answerRossEmily = rossEmilyCheckBox.isChecked();
        CheckBox mikePhoebeCheckBox = findViewById(R.id.mike_phoebe_checkbox);
        boolean answerMikePhoebe = mikePhoebeCheckBox.isChecked();

        // Find the Friend user's name
        EditText friendNameField = findViewById(R.id.which_friend);
        String name = friendNameField.getText().toString().trim();

        // Calculate the score
        int score = calculateScore(answerEmma, answerRembrandts, answerOmg, answerRossAndRachel, answerAlPacino,
                answerMuriel, answerMonica, answerTwo, answerJoey, answerRossRachel, answerChandlerMonica,
                answerRossEmily, answerMikePhoebe);

        // Display the score summary on the screen
        String scoreMessage = createScoreSummary(name, score);
        displayMessage(scoreMessage);

        // Display a Toast message with the score on the screen
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();

        // Display a Toast message about the user performance on the Quiz
        if (score == 10) {
            Toast.makeText(this, "Congrats! You certainly have Unagi", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Try again! You should improve your Unagi", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Calculate the score
     *
     * @param answerEmma           is whether or not the user hit the right answer
     * @param answerRembrandts     is whether or not the user hit the right answer
     * @param answerOmg            is whether or not the user hit the right answer
     * @param answerRossAndRachel  is whether or not the user hit the right answer
     * @param answerAlPacino       is whether or not the user hit the right answer
     * @param answerMuriel         is whether or not the user hit the right answer
     * @param answerMonica         is whether or not the user hit the right answer
     * @param answerTwo            is whether or not the user hit the right answer
     * @param answerJoey           is whether or not the user hit the right answer
     * @param answerRossRachel     is whether or not the user hit the right answer
     * @param answerChandlerMonica is whether or not the user hit the right answer
     * @param answerRossEmily      is whether or not the user hit the right answer
     * @param answerMikePhoebe     is whether or not the user hit the right answer
     * @return total score
     */
    private int calculateScore(boolean answerEmma, boolean answerRembrandts, boolean answerOmg, boolean answerRossAndRachel,
                               boolean answerAlPacino, boolean answerMuriel, boolean answerMonica, boolean answerTwo,
                               String answerJoey, boolean answerRossRachel, boolean answerChandlerMonica, boolean answerRossEmily,
                               boolean answerMikePhoebe) {
        int baseScore = 0;
        // Add 1 point to right answer - QUESTION 1
        if (answerEmma) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 2
        if (answerRembrandts) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 3
        if (answerOmg) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 4
        if (answerRossAndRachel) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 5
        if (answerAlPacino) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 6
        if (answerMuriel) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 7
        if (answerMonica) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 8
        if (answerTwo) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 9
        if (answerJoey.equalsIgnoreCase("Joey")) {
            baseScore ++;
        }
        // Add 1 point to right answer - QUESTION 10
        if (answerRossRachel && answerChandlerMonica && answerRossEmily && answerMikePhoebe) {
            baseScore++;
        }
        return baseScore;
    }

    /**
     * Create summary of the Score.
     *
     * @param name  of the friend character
     * @param score of the quiz
     * @return text summary
     */
    private String createScoreSummary(String name, int score) {
        String scoreMessage = "How you doing " + name + "?";
        scoreMessage += "\nYou scored " + score + " / 10 questions correctly";
        scoreMessage += "\n";
        scoreMessage += "\nQ.1 Answer: Emma";
        scoreMessage += "\nQ.2 Answer: The Rembrandts";
        scoreMessage += "\nQ.3 Answer: Oh my God";
        scoreMessage += "\nQ.4 Answer: Ross and Rachel";
        scoreMessage += "\nQ.5 Answer: Al Pacino";
        scoreMessage += "\nQ.6 Answer: Muriel";
        scoreMessage += "\nQ.7 Answer: Monica";
        scoreMessage += "\nQ.8 Answer: 2";
        scoreMessage += "\nQ.9 Answer: Joey";
        scoreMessage += "\nQ.10 Answer: All the couples";
        return scoreMessage;
    }

    /**
     * This method displays the given Score on the screen.
     */
    private void displayMessage(String message) {
        TextView scoreSummaryTextView = findViewById(R.id.score_summary_text_view);
        scoreSummaryTextView.setText(message);
    }

    /**
     * This method will clear the quiz when the RESET button is clicked
     */
    public void resetQuiz(View view) {
        // Reset QUESTION 1
        RadioGroup question1RadioGroup = findViewById(R.id.question1);
        question1RadioGroup.clearCheck();

        // Reset QUESTION 2
        RadioGroup question2RadioGroup = findViewById(R.id.question2);
        question2RadioGroup.clearCheck();

        // Reset QUESTION 3
        RadioGroup question3RadioGroup = findViewById(R.id.question3);
        question3RadioGroup.clearCheck();

        // Reset QUESTION 4
        RadioGroup question4RadioGroup = findViewById(R.id.question4);
        question4RadioGroup.clearCheck();

        // Reset QUESTION 5
        RadioGroup question5RadioGroup = findViewById(R.id.question5);
        question5RadioGroup.clearCheck();

        // Reset QUESTION 6
        RadioGroup question6RadioGroup = findViewById(R.id.question6);
        question6RadioGroup.clearCheck();

        // Reset QUESTION 7
        RadioGroup question7RadioGroup = findViewById(R.id.question7);
        question7RadioGroup.clearCheck();

        // Reset QUESTION 8
        RadioGroup question8RadioGroup = findViewById(R.id.question8);
        question8RadioGroup.clearCheck();

        // Reset QUESTION 9
        EditText joeyEditText = findViewById(R.id.joey_name_field);
        joeyEditText.getText().clear();

        // Reset QUESTION 10
        CheckBox rossRachelCheckBox = findViewById(R.id.ross_rachel_checkbox);
        rossRachelCheckBox.setChecked(false);
        CheckBox chandlerMonicaCheckBox = findViewById(R.id.chandler_monica_checkbox);
        chandlerMonicaCheckBox.setChecked(false);
        CheckBox rossEmilyCheckBox = findViewById(R.id.ross_emily_checkbox);
        rossEmilyCheckBox.setChecked(false);
        CheckBox mikePhoebeCheckBox = findViewById(R.id.mike_phoebe_checkbox);
        mikePhoebeCheckBox.setChecked(false);

        // Reset the friend name
        EditText friendNameField = findViewById(R.id.which_friend);
        friendNameField.getText().clear();

        // Reset the Score Summary and show a Toast message
        TextView scoreSummary = findViewById(R.id.score_summary_text_view);
        scoreSummary.setText("");

        Toast.makeText(this, "This quiz has been reset!", Toast.LENGTH_LONG).show();
    }
}