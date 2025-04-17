package com.practice.quizapp.service;

import com.practice.quizapp.entity.Question;

import java.util.List;

public interface QuestionService{
    List<Question> getAllQuestion();
    String saveQuestion(Question question);
}
