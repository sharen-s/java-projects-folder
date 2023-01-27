package dao;
import model.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcQuizQuestionDao implements QuizQuestionDao {
        private JdbcTemplate jdbcTemplate;

        public JdbcQuizQuestionDao(DataSource dataSource){
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

        @Override

        public List<QuizQuestion> getQuestionsForQuiz (String theme) {
            String sql =  "SELECT questions.questions_id, question_text, correct_answer, answer_1, answer_2, answer_3 " +
                    "FROM questions " +
                    "JOIN answers ON answers.questions_id = questions.questions_id " +
                    "JOIN quiz ON quiz.quiz_id = questions.quiz_id " +
                    "WHERE questions.theme = ? " +
                    "ORDER BY questions_id asc";

            SqlRowSet questionRows = jdbcTemplate.queryForRowSet(sql, theme);
            List<QuizQuestion> results = new ArrayList<>();
            while (questionRows.next()){
                results.add(mapRowToQuizQuestion(questionRows));
            }
            return results;
        }

    private QuizQuestion mapRowToQuizQuestion(SqlRowSet row) {
        QuizQuestion question = new QuizQuestion();
        question.setQuestionId(row.getInt("questions_id"));
        question.setQuestionText(row.getString("question_text"));
        question.setCorrectAnswer(row.getString("correct_answer"));

        List<String> answers = new ArrayList<>();
        answers.add(row.getString("answer_1"));
        answers.add(row.getString("answer_2"));
        answers.add(row.getString("answer_3"));
        question.setAnswers(answers);

        return question;
    }
}
