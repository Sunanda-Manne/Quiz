package com.project.quizApp.Service;

import com.project.quizApp.Dao.QuestionDao;
import com.project.quizApp.Dao.QuizDao;
import com.project.quizApp.Model.Question;
import com.project.quizApp.Model.QuestionWrapper;
import com.project.quizApp.Model.Quiz;
import com.project.quizApp.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ,String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        try {
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {

        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(Question q:questionFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getRightAnswer());
            questionForUser.add(qw);

        }
        try {
            return new ResponseEntity<>(questionForUser, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<Integer> getScore(Integer id, List<Response> responses) {
        Quiz quiz =quizDao.findById((id)).get();
        List<Question> questions=quiz.getQuestions();

        int right=0;
        int i=0;

        for(Response response: responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;

        }
        try {
            return new ResponseEntity<>(right, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);


    }
}
