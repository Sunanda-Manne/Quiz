package com.project.quizApp.Controller;

import com.project.quizApp.Model.Question;
import com.project.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
            public ResponseEntity<List<Question>> getAllQuestions(){

                return questionService.getAllQuestions();
            }
            @GetMapping("category/{category}")
            public ResponseEntity<List<Question>> getByCategory(@PathVariable String category){
                return questionService.findByCategory(category);
            }

            @GetMapping("difficultyLevel/{difficultyLevel}")
            public ResponseEntity<List<Question>> getByDifficulty(@PathVariable String difficultyLevel){
                return questionService.findByDifficultyLevel(difficultyLevel);
            }
            @PostMapping(value = "addQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<String> addQuestion(@RequestBody Question question){
                return questionService.addQuestion(question);
    }

            @DeleteMapping("delete/{id}")
            public void deleteQuestion(@PathVariable int id){
                questionService.deleteById(id);


            }

        }






