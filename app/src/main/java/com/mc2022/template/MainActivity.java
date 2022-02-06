package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private User user;
    private EditText username;
    private TextView question;
    private RadioGroup ansRadioGroup;
    private RadioButton ansRadioButton;
    private Button next;
    private Button clear;
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

        setContentView(R.layout.activity_main);

        question = (TextView) findViewById(R.id.textView2);
        next = (Button) findViewById(R.id.button);
        clear = (Button) findViewById(R.id.button3);

        next.setOnClickListener((View.OnClickListener) this);
        clear.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.button){
            if(next.getText().toString().equals(getString(R.string.button_next))) {
                if (question.getText().toString().equals(getString(R.string.username))) {
                    username = (EditText) findViewById(R.id.editTextTextPersonName);
                    if(username.getText().toString().equals("")){
                        Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        user = new User(username.getText().toString());

                        username.setVisibility(View.GONE);
                        question.setText(R.string.que1);
                        ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                        ansRadioGroup.setVisibility(View.VISIBLE);

                        clear = (Button) findViewById(R.id.button3);
                        clear.setVisibility(View.VISIBLE);
                    }
                }
                else if (question.getText().toString().equals(getString(R.string.que1))) {
                    ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    int selectedRadioButtonID = ansRadioGroup.getCheckedRadioButtonId();
                    ansRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    user.getSymptoms().add(new Question(question.getText().toString(), ansRadioButton.getText().toString().equals("Yes")));
                    question.setText(R.string.que2);
                } else if (question.getText().toString().equals(getString(R.string.que2))) {
                    ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    int selectedRadioButtonID = ansRadioGroup.getCheckedRadioButtonId();
                    ansRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    user.getSymptoms().add(new Question(question.getText().toString(), ansRadioButton.getText().toString().equals("Yes")));
                    question.setText(R.string.que3);
                } else if (question.getText().toString().equals(getString(R.string.que3))) {
                    ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    int selectedRadioButtonID = ansRadioGroup.getCheckedRadioButtonId();
                    ansRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    user.getSymptoms().add(new Question(question.getText().toString(), ansRadioButton.getText().toString().equals("Yes")));
                    question.setText(R.string.que4);
                } else if (question.getText().toString().equals(getString(R.string.que4))) {
                    ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    int selectedRadioButtonID = ansRadioGroup.getCheckedRadioButtonId();
                    ansRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    user.getSymptoms().add(new Question(question.getText().toString(), ansRadioButton.getText().toString().equals("Yes")));
                    question.setText(R.string.que5);
                    next.setText(R.string.button_submit);
                }
            }
            else if(next.getText().toString().equals(getString(R.string.button_submit))){
                ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                int selectedRadioButtonID = ansRadioGroup.getCheckedRadioButtonId();
                ansRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                user.getSymptoms().add(new Question(question.getText().toString(), ansRadioButton.getText().toString().equals("Yes")));
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("user record", (Serializable) user);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.button3){
            user = new User(user.getUsername());
            username.setVisibility(View.GONE);
            question.setText(R.string.que1);
            ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            ansRadioGroup.setVisibility(View.VISIBLE);

            next.setText(R.string.button_next);
            clear = (Button) findViewById(R.id.button3);
            clear.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle storeState) {

        storeState.putSerializable("user", user);
        if(question.getText().toString().equals(getString(R.string.username))){
            storeState.putString("question", question.getText().toString());
            username = (EditText) findViewById(R.id.editTextTextPersonName);
            storeState.putString("username", username.getText().toString());
        }
        else {
            storeState.putString("question", question.getText().toString());
            storeState.putString("button", next.getText().toString());

            ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            int selectedRadioButtonID = ansRadioGroup.getCheckedRadioButtonId();
            ansRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
            storeState.putInt("radio", ansRadioButton.getId());
        }
        super.onSaveInstanceState(storeState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState){
        super.onRestoreInstanceState(savedState);

        user = (User) savedState.getSerializable("user");
        question = (TextView) findViewById(R.id.textView2);
        question.setText(savedState.getString("question"));

        if(question.getText().toString().equals(getString(R.string.username))){
            username = (EditText) findViewById(R.id.editTextTextPersonName);
            username.setText(savedState.getString("username"));
        }
        else {
            username = (EditText) findViewById(R.id.editTextTextPersonName);
            username.setVisibility(View.GONE);

            next = (Button) findViewById(R.id.button);
            next.setText(savedState.getString("button"));

            ansRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            ansRadioButton = (RadioButton) findViewById(savedState.getInt("radio"));
            ansRadioGroup.setVisibility(View.VISIBLE);
            ansRadioButton.setChecked(true);
        }
    }

    /*public void displayUser(){
        if(user == null){
            System.out.println("User object is null");
            return;
        }
        System.out.println(user.getUsername());
        for(Question q: user.getSymptoms()){
            System.out.println(q.getQue()+"\n"+q.getAns()+"\n");
        }
    }*/

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