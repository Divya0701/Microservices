package com.practice.quizapp.controller;

import com.practice.quizapp.entity.Question;
import com.practice.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("questions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }

    @PostMapping("questions")
    public String postQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }
}
