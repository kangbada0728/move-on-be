package me.kangbada.moveonbe.dto.jobpostcontroller;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class JobPostingCompanyDto {
    private String companyName;
    private List<JobPostingDto> jobPostings = new ArrayList<>();
}
