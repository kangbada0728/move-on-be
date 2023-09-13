package me.kangbada.moveonbe.domain.job.posting;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPostingInfo {

    @Embedded
    private JobPostingTitle title;

    @Embedded
    private JobPostingLink link;


    public JobPostingInfo(JobPostingTitle title, JobPostingLink link) {
        this.title = title;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobPostingInfo that = (JobPostingInfo) o;

        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return link != null ? link.hashCode() : 0;
    }
}
