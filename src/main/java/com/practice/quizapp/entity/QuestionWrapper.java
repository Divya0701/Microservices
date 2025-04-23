package com.practice.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
    public int id;
    public String qustion;
    public String option_a;
    public String option_b;
    public String option_c;
    public String option_d;

}
