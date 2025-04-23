package com.practice.quizapp.controller;

import com.practice.quizapp.entity.Question;
import com.practice.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @PostMapping("questions")
    public String postQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }
}
