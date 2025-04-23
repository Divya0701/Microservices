package com.practice.quizapp.service;

import com.practice.quizapp.entity.Question;
import com.practice.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public ResponseEntity<List<Question>> getAllQuestion() {
        try{
        return new ResponseEntity<List<Question>>(questionRepository.findAll(),HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Question>>(new ArrayList<Question>(),HttpStatus.BAD_GATEWAY);
    }

    @Override
    public String saveQuestion(Question question) {
        questionRepository.save(question);
        return "Success";
    }
}
