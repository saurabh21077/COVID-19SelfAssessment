package com.mc2022.template;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Question> records = new ArrayList<Question>();
    private TextView question;
    private RadioGroup ansRadioGroup;
    private RadioButton ansRadioButton;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView) findViewById(R.id.textView2);
        ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        System.out.println("Question text - "+question.getText());
        next = (Button) findViewById(R.id.button);
        next.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.button){
            int selectedRadioButtonID = ansRadioGroup.getCheckedRadioButtonId();
            ansRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
            records.add(new Question(question.getText().toString(), ansRadioButton.getText().toString().equals("Yes")));
            System.out.println("Question - "+question.getText());
            System.out.println("Displaying records");
            displayArray();

            if(next.getText().toString().equals(getString(R.string.button_next))) {
                if (question.getText().toString().equals(getString(R.string.que1))) {
                    question.setText(R.string.que2);
                } else if (question.getText().toString().equals(getString(R.string.que2))) {
                    question.setText(R.string.que3);
                } else if (question.getText().toString().equals(getString(R.string.que3))) {
                    question.setText(R.string.que4);
                } else if (question.getText().toString().equals(getString(R.string.que4))) {
                    question.setText(R.string.que5);
                    next.setText(R.string.button_submit);
                }
            }
            else if(next.getText().toString().equals(getString(R.string.button_submit))){
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("record", (Serializable) records);
                startActivity(intent);
            }
        }
    }

    public void displayArray(){
        for(Question q: records){
            System.out.println(q.getQue()+"\n"+q.getAns()+"\n");
        }
    }
}