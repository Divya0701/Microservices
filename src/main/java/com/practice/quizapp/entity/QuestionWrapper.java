package com.practice.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class QuestionWrapper {
    private int id;
    private String qustion;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;

}
