package com.practice.quizapp.service;

import com.practice.quizapp.entity.QuestionWrapper;
import com.practice.quizapp.entity.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    ResponseEntity<String> createQuiz(int numQuestions, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
