package com.project.quizApp.Dao;

import com.project.quizApp.Model.Question;
import com.project.quizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}

