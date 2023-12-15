package com.project.quizApp.Dao;

import com.project.quizApp.Model.Question;
import com.project.quizApp.Model.Quiz;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    

    @Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery= true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

    List<Question> findByCategory(String category);

    List<Question> findByDifficultyLevel(String difficultyLevel);
}


