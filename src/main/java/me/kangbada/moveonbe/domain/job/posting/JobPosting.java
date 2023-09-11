package me.kangbada.moveonbe.domain.job.posting;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.kangbada.moveonbe.domain.company.Company;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPosting {
    @EmbeddedId
    private JobPostingId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Company")
    private Company company;



}
