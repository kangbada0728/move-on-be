package me.kangbada.moveonbe.domain.job.posting;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPostingLink {
    @Column(nullable = false)
    private String link;

    public JobPostingLink(String link) {
        if (isBlank(link)) {
            throw new IllegalArgumentException();
        }
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobPostingLink that = (JobPostingLink) o;

        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return link != null ? link.hashCode() : 0;
    }
}
