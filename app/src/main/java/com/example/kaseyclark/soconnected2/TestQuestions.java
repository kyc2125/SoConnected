package com.example.kaseyclark.soconnected2;

/**
 * Created by kaseyclark on 5/2/18.
 */

public class TestQuestions {
    public static void main(String[]args){
        Question questionList[]=Question.getRandomQuestions();
        for (Question question:questionList){
            System.out.println(question.getQuestion());
        }
        String answers [] ={"abc", "jk", "lol", "89", "lk"};
        SoConnectedUser user = new SoConnectedUser();
        user.setAnswersToQuestions(answers);
        Question userquestions[] = user.getQuestions();
        for (Question question: userquestions){
            System.out.println(question.toString());
        }
    }

}
