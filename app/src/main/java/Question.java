/**
 * Created by kaseyclark on 5/2/18.
 */
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class Question {

    private static final Question[] questionList ={
           new Question( "What was the last book you read?"),
            new Question ("Where is the farthest place you have traveled?"),
            new Question("Who is your favorite sports team?"),
           new Question("If I could change one thing about myself it would be_________."),
            new Question("One of the things I find most annoying is…"),
             new Question("Where did you grow up?"),
                new Question("On Friday nights I am usually…"),
                    new Question("I spend too much money on..."),
                 new Question( "Advice to my younger self…"),
                 new Question("My mom would describe me as..."),
                   new Question( "Facts about me that surprises people…"),
                    new Question("My last meal would be ________."),
                    new Question("Let’s debate this topic…"),
                    new Question("My ideal fake sick day would be ________."),
                    new Question("I know the best spot in town for ________."),
                    new Question("My go to karaoke song is _______. ") ,
                    new Question("The place I never want to go back to is _______.") ,
                    new Question("My favorite playlist consists of…"),
                    new Question("If I could live in any movie’s universe, it would be __________."),
                    new Question("If I could change one thing about the world it would be _______.")
    };
   private String question;
    private String answer;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;

    }

    public static Question[] getRandomQuestions(){
        Random rand = new Random();
        int  index = rand.nextInt(questionList.length-1) ;
        List <Question> randomQuestionList= new ArrayList<>();
        int counter =0;
        while (counter < 5) {
            Question q = questionList[index];
            index ++;
            if (index == questionList.length)
                index= 0;
            randomQuestionList.add(q);
            counter++;
        }
        Question[] randomQuestionArr = new Question[randomQuestionList.size()];
        randomQuestionArr = randomQuestionList.toArray(randomQuestionArr);
        return randomQuestionArr;
    }
    public String toString(){
        return "Question:" + this.getQuestion() + "\nAnswer:" + this.getAnswer();
    }

}




