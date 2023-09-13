package me.kangbada.moveonbe.domain.job.posting;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.kangbada.moveonbe.domain.company.Company;

import java.util.Objects;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "LINK_UNIQUE", columnNames = {"link"})
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPosting {
    @EmbeddedId
    private JobPostingId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Company")
    private Company company;

    @Embedded
    private JobPostingInfo info;

    public JobPosting(Company company, JobPostingInfo info) {
        this.company = company;
        this.info = info;
    }

    public JobPosting(JobPostingId id, Company company, JobPostingInfo info) {
        this(company, info);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobPosting that = (JobPosting) o;

        if (!Objects.equals(company, that.company)) return false;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }
}
