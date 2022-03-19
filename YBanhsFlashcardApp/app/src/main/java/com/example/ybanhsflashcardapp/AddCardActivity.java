package com.example.ybanhsflashcardapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    public EditText question_box;
    public EditText answer_box;
//    public EditText wronganswer1_box;
//    public EditText wronganswer2_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ImageView cancel_button = findViewById(R.id.cancel_button);
        ImageView save_button = findViewById(R.id.save_button);

        question_box = findViewById(R.id.question_box);
        answer_box = findViewById(R.id.answer_box);
//        wronganswer1_box = findViewById(R.id.wronganswer1_box);
//        wronganswer2_box = findViewById(R.id.wronganswer2_box);



        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get data from EditText
                String question = question_box.getText().toString();
                String answer = answer_box.getText().toString();
//                String wronganswer1 = wronganswer1_box.getText().toString();
//                String wronganswer2 = wronganswer2_box.getText().toString();

                // Put data in the intent
                Intent intent = new Intent();
                intent.putExtra( "QUESTION_KEY",question);
                intent.putExtra( "ANSWER_KEY",answer);
//                intent.putExtra("WRONG_ANSWER1",wronganswer1);
//                intent.putExtra("WRONG_ANSWER2",wronganswer2);
                setResult(RESULT_OK,intent);
                // Must use equals() method
                if (question.equals("") || answer.equals("")) {
                    Toast.makeText(getApplicationContext(), "Must enter both Question and Answer?", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                }
            }
        });

        String currentQuestion = getIntent().getStringExtra("flashcard_question");
        String currentAnswer = getIntent().getStringExtra("flashcard_answer");
        question_box.setText(currentQuestion);
        answer_box.setText(currentAnswer);



    }
}