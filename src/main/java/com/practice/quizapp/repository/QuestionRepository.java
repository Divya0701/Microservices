package com.practice.quizapp.repository;

import com.practice.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query(value = "SELECT * FROM question order by RANDOM() limit :numQuestions",nativeQuery = true)
    List<Question> findRandomQuestions(int numQuestions);
}
