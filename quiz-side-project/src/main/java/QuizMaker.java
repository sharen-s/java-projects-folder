import dao.JdbcQuizQuestionDao;
import dao.QuizQuestionDao;
import model.QuizQuestion;
import org.apache.commons.dbcp2.BasicDataSource;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {
    private final Scanner userInput = new Scanner(System.in);
    private QuizQuestionDao dao;

//    we need to add if user wants to try again, and if with the same theme or another theme, and if they
//    do a theme that does not exist let them know so they can insert correct one
//    another
//    if in you choose another number that is not in the choices make sure to say something like select an
//    actual answer

    public static void main(String[] args) {
        QuizMaker quizMaker = new QuizMaker();
        quizMaker.run();
    }
    public QuizMaker(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/QuizProjectDB");
        dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");
            dao = new JdbcQuizQuestionDao(dataSource);
        }

    private void run(){
        System.out.println("Welcome to Quiz Maker!");
        System.out.println("Please enter the theme of the quiz you would like to take: ");
        String name = userInput.nextLine();
        List<QuizQuestion> theme = dao.getQuestionsForQuiz(name);
        int numberRight = deliverQuiz(theme);
        System.out.println("You got " + numberRight + " answer(s) correct out of " +
                theme.size() + " question(s) asked.");
    }



    private int deliverQuiz(List<QuizQuestion> quizQuestions){
        int numberOfCorrectAnswers = 0;
        for (QuizQuestion quizQuestion : quizQuestions){
            int answerNum = promptForInt(quizQuestion + "Your Answer?");
            if(quizQuestion.isAnswerCorrect(answerNum)){
                System.out.println("Correct!");
                numberOfCorrectAnswers +=1;
            }
            else{
                System.out.println("Sorry that isn't correct!");
            }
        }
        return numberOfCorrectAnswers;
    }


    public int promptForInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
