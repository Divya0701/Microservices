package com.practice.quizapp.service;

import com.practice.quizapp.entity.Question;
import com.practice.quizapp.entity.QuestionWrapper;
import com.practice.quizapp.entity.Quiz;
import com.practice.quizapp.entity.Response;
import com.practice.quizapp.repository.QuestionRepository;
import com.practice.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public ResponseEntity<String> createQuiz(int numQuestions, String title) {
        Quiz quiz = new Quiz();
        List<Question> questionList = questionRepository.findRandomQuestions(numQuestions);
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestionList();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper qw = QuestionWrapper.builder()
                    .option_a(q.getOption_a())
                    .option_b(q.getOption_b())
                    .option_c(q.getOption_c())
                    .option_d(q.getOption_d())
                    .qustion(q.getQustion())
                    .build();
            questionsForUser.add(qw);

        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questionList = quiz.getQuestionList();
        int right=0;
        int i=0;
        for(Response response : responses){
            if(response.getResponse().equals(questionList.get(i).getAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
