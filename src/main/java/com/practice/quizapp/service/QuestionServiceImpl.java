package com.practice.quizapp.service;

import com.practice.quizapp.entity.Question;
import com.practice.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public String saveQuestion(Question question) {
        questionRepository.save(question);
        return "Success";
    }
}
