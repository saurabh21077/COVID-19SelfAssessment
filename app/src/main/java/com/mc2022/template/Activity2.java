package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{

    private TextView recommendation;
    private Button testingNeeded;
    private User user;
    private String savedState = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedState.equals("")){
            Log.i("Create", "State of activity "+getClass().getSimpleName()+" changed from Activity Launched to Created.");
            Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from Activity Launched to Created.", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i("Create", "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Created");
            Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Created", Toast.LENGTH_SHORT).show();
        }
        savedState = "Created";

        setContentView(R.layout.activity_2);

        user = (User) getIntent().getSerializableExtra("user record");

        TextView displayForm = (TextView) findViewById(R.id.textView6);
        displayForm.setText(user.getUsername());

        for(Question q : user.getSymptoms()){
            if(q.getQue().equals(getString(R.string.que1))){
                displayForm = (TextView) findViewById(R.id.textView8);
                displayForm.setText(q.getAns()?"Yes":"No");
            } else if(q.getQue().equals(getString(R.string.que2))){
                displayForm = (TextView) findViewById(R.id.textView10);
                displayForm.setText(q.getAns()?"Yes":"No");
            } else if(q.getQue().equals(getString(R.string.que3))){
                displayForm = (TextView) findViewById(R.id.textView12);
                displayForm.setText(q.getAns()?"Yes":"No");
            } else if(q.getQue().equals(getString(R.string.que4))){
                displayForm = (TextView) findViewById(R.id.textView14);
                displayForm.setText(q.getAns()?"Yes":"No");
            } else if(q.getQue().equals(getString(R.string.que5))){
                displayForm = (TextView) findViewById(R.id.textView16);
                displayForm.setText(q.getAns()?"Yes":"No");
            } else if(q.getQue().equals(getString(R.string.que6))){
                displayForm = (TextView) findViewById(R.id.textView18);
                displayForm.setText(q.getAns()?"Yes":"No");
            } else if(q.getQue().equals(getString(R.string.que7))){
                displayForm = (TextView) findViewById(R.id.textView20);
                displayForm.setText(q.getAns()?"Yes":"No");
            }
        }

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

    @Override
    protected void onSaveInstanceState(Bundle storeState) {
        storeState.putString("recommendation", recommendation!=null? recommendation.getText().toString() : "");
        super.onSaveInstanceState(storeState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState){
        super.onRestoreInstanceState(savedState);
        recommendation = findViewById(R.id.textView3);
        recommendation.setText(savedState.getString("recommendation"));
    }

    private int countPositives() {
        int count=0;
        for(Question q : user.getSymptoms()){
            if(q.getAns()){
                count++;
            }
        }
        return count;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Start", "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Started");
        Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Started", Toast.LENGTH_SHORT).show();
        savedState = "Started";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Resume", "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Resumed");
        Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Resumed", Toast.LENGTH_SHORT).show();
        savedState = "Resumed";
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Pause", "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Paused");
        Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Paused", Toast.LENGTH_SHORT).show();
        savedState = "Paused";
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Stop", "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Stopped");
        Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Stopped", Toast.LENGTH_SHORT).show();
        savedState = "Stopped";
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Restart", "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Restarted");
        Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Restarted", Toast.LENGTH_SHORT).show();
        savedState = "Restarted";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy", "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Destroyed");
        Toast.makeText(this, "State of activity "+getClass().getSimpleName()+" changed from "+savedState+" to Destroyed", Toast.LENGTH_SHORT).show();
        savedState = "Destroyed";
    }

}