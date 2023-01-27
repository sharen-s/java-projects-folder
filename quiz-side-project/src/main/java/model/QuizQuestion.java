package model;
import java.util.List;

public class QuizQuestion {
    private List<QuizQuestion> quiz;
    private int questionId;
    private String quizName;
    private String questionText;
    private int numberRight;
    private List<String> answers;
    private String correctAnswer;
    private boolean isAnswerCorrect;

    public QuizQuestion(){
    }

    public QuizQuestion(int questionId, String quizName, String questionText, int numberRight, String correctAnswer) {
        this.questionId = questionId;
        this.quizName = quizName;
        this.questionText = questionText;
        this.numberRight = numberRight;
        this.correctAnswer = correctAnswer;
    }

    public QuizQuestion(List<QuizQuestion> quiz) {
        this.quiz = quiz;
    }

    public String getQuizName() {
        return quizName;
    }

    public List<QuizQuestion> getQuiz() {
        return quiz;
    }

    public int getNumberRight() {
        return numberRight;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setNumberRight(int numberRight) {
        this.numberRight = numberRight;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public boolean isAnswerCorrect(int answer) {
        return this.correctAnswer.equals(this.answers.get(answer - 1));
    }

    //can you have multiple tostrings (yes we can -sharen) and can we input the number for a potential answer
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(questionText).append("\n");
        for (int i = 0; i < answers.size(); i++) {
            sb.append(i + 1).append(") ").append(answers.get(i)).append("\n");
        }
        return sb.toString();
    }
}
