package com.practice.quizapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Entity
@Table(name = "quiz")
@Slf4j
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToMany
    private List<Question> questionList;
}
