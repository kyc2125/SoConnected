package com.example.kaseyclark.soconnected2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowAnswers extends AppCompatActivity {
    private TextView tv_question1;
    private  TextView tv_question2;
    private   TextView tv_question3;
    private TextView tv_question4;
    private  TextView tv_question5;
    private  TextView tv_answer1;
    private  TextView tv_answer2;
    private   TextView tv_answer3;
    private TextView tv_answer4;
    private  TextView tv_answer5;
    TextView tv_questions[] ={ tv_question1, tv_question2, tv_question3, tv_question4, tv_question5};
    TextView tv_answers[] ={ tv_answer1, tv_answer2, tv_answer3, tv_answer4, tv_answer5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answers);
        tv_question1 = (TextView)findViewById(R.id.tv_q1);
        tv_question2 = (TextView)findViewById(R.id.tv_q2);
        tv_question3 = (TextView)findViewById(R.id.tv_q3);
        tv_question4 = (TextView)findViewById(R.id.tv_q4);
        tv_question5 = (TextView)findViewById(R.id.tv_q5);
        tv_answer1 = (TextView)findViewById(R.id.tv_a1);
        tv_answer2 = (TextView)findViewById(R.id.tv_a2);
        tv_answer3 = (TextView)findViewById(R.id.tv_a3);
        tv_answer4 = (TextView)findViewById(R.id.tv_a4);
        tv_answer5 = (TextView)findViewById(R.id.tv_a5);
        SoConnectedUser user = (SoConnectedUser)getIntent().getSerializableExtra("user");
       Question questions []= user.getQuestions();
       for (int i = 0; i< questions.length;++i){
           Question question = questions [i];
           tv_questions [i].setText(question.getQuestion());
           tv_answers [i].setText((question.getAnswer()));
       }

    }
}

