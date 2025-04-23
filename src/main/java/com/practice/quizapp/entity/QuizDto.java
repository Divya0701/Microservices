package com.practice.quizapp.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private int numQuestions;
    private String Title;
}
