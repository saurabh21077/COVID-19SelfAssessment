package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{

    private TextView report;
    private TextView recommendation;
    private Button testingNeeded;
    private List<Question> record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        report = findViewById(R.id.textView6);

        record = (List<Question>) getIntent().getSerializableExtra("record");
        String s = "";
        for(Question q : record){
            s = s.concat(q.getQue()+" - "+String.valueOf(q.getAns())+"\n");
        }
        report.setText(s);

        testingNeeded = findViewById(R.id.button2);
        testingNeeded.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.button2){
            recommendation = findViewById(R.id.textView3);
            if(countPositives()>3){
                recommendation.setText(R.string.test_needed);
            }
            else{
                recommendation.setText(R.string.test_not_needed);
            }
        }
    }

    private int countPositives() {
        int count=0;
        for(Question q : record){
            if(q.getAns()){
                count++;
            }
        }
        return count;
    }
}