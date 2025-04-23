package com.practice.quizapp.service;

import com.practice.quizapp.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService{
    ResponseEntity<List<Question>> getAllQuestion();
    String saveQuestion(Question question);
}
