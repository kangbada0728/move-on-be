package me.kangbada.moveonbe.domain.company;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.kangbada.moveonbe.domain.job.posting.JobPosting;

import java.util.List;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPostings {

    @OneToMany(mappedBy = "company")
    private List<JobPosting> jobPostings;


    public JobPostings(List<JobPosting> jobPostings) {
        this.jobPostings = jobPostings;
    }


}
