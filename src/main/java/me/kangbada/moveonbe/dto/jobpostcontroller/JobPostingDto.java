package me.kangbada.moveonbe.dto.jobpostcontroller;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class JobPostingDto {
    private String title;
    private String target;
    private LocalDate recruitPeriodStart;
    private LocalDate recruitPeriodEnd;
    private String link;
}
