package com.project.quizApp.Model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;

    public QuestionWrapper(int id, String questionTitle, String option1, String option2, String option3, String option4, String rightAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
    }
}
