package com.example.kaseyclark.soconnected2;

import com.example.kaseyclark.soconnected2.Question;

import java.io.Serializable;

/**
 * Created by kaseyclark on 5/2/18.
 */

public class SoConnectedUser implements Serializable {
    private Question questions[];

    public SoConnectedUser() {
        questions=Question.getRandomQuestions();
    }

    public Question[] getQuestions() {
        return questions;
    }
    public void setAnswersToQuestions (String answersToQuestions[]){
        for(int i =0 ; i< answersToQuestions.length; ++i){
            String answer=answersToQuestions[i];
            Question question = questions[i];
            question.setAnswer(answer);
        }
    }
}