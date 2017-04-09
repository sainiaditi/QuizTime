package com.example.android.quiztime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {

        EditText text = (EditText) findViewById(R.id.name_field);
        String name = text.getText().toString();
        String name1 = getString(R.string.nameExample);

        EditText textAnswer = (EditText) findViewById(R.id.text_ans);
        String colourMatch = textAnswer.getText().toString();

        CheckBox ques1_option1 = (CheckBox) findViewById(R.id.ques1_option1);
        boolean ques1_option1_checked = ques1_option1.isChecked();

        CheckBox ques1_option2 = (CheckBox) findViewById(R.id.ques1_option2);
        boolean ques1_option2_checked = ques1_option2.isChecked();

        CheckBox ques1_option3 = (CheckBox) findViewById(R.id.ques1_option3);
        boolean ques1_option3_checked = ques1_option3.isChecked();

        CheckBox ques2_option1 = (CheckBox) findViewById(R.id.ques2_option1);
        boolean ques2_option1_checked = ques2_option1.isChecked();

        CheckBox ques2_option2 = (CheckBox) findViewById(R.id.ques2_option2);
        boolean ques2_option2_checked = ques2_option2.isChecked();

        CheckBox ques2_option3 = (CheckBox) findViewById(R.id.ques2_option3);
        boolean ques2_option3_checked = ques2_option3.isChecked();

        CheckBox ques4_option1 = (CheckBox) findViewById(R.id.ques4_option1);
        boolean ques4_option1_checked = ques4_option1.isChecked();

        CheckBox ques4_option2 = (CheckBox) findViewById(R.id.ques4_option2);
        boolean ques4_option2_checked = ques4_option2.isChecked();

        CheckBox ques4_option3 = (CheckBox) findViewById(R.id.ques4_option3);
        boolean ques4_option3_checked = ques4_option3.isChecked();

        RadioButton r1 = (RadioButton) findViewById(R.id.country_radio_button);
        boolean radio1 = r1.isChecked();

        RadioButton r2 = (RadioButton) findViewById(R.id.state_radio_button);
        boolean radio2 = r2.isChecked();

        RadioButton r3 = (RadioButton) findViewById(R.id.true_radio_button);
        boolean radio3 = r3.isChecked();

        RadioButton r4 = (RadioButton) findViewById(R.id.false_radio_button);
        boolean radio4 = r4.isChecked();

        int marks = calculateMarks(ques1_option1_checked, ques1_option2_checked, ques1_option3_checked, ques2_option1_checked, ques2_option2_checked, ques2_option3_checked, ques4_option1_checked, ques4_option2_checked, ques4_option3_checked, radio1, radio2, radio3, radio4, colourMatch);
        Toast.makeText(this, name1 + " your Score: " + marks, Toast.LENGTH_LONG).show();

        score = 0;


    }

    private int calculateMarks(boolean q1o1, boolean q1o2, boolean q1o3, boolean q2o1, boolean q2o2, boolean q2o3, boolean q4o1, boolean q4o2, boolean q4o3, boolean r1, boolean r2, boolean r3, boolean r4, String colourName) {

        if (colourName.equals("Black")) {
            score += 1;
        }

        if (q1o1 || q1o2) {
            score += 0;
        } else if (q1o3) {
            score += 1;
        }

        if (q2o2 || q2o3) {
            score += 0;
        } else if (q2o1) {
            score += 1;
        }

        if (r2) {
            score += 0;
        } else if (r1) {
            score += 1;
        }

        if (q4o1 || q4o3) {
            score += 0;
        } else if (q4o2) {
            score += 1;
        }

        if (r3) {
            score += 0;
        } else if (r4) {
            score += 1;
        }

        return score;
    }
}
