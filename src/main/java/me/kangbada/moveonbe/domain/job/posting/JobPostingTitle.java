package me.kangbada.moveonbe.domain.job.posting;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.length;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPostingTitle {
    public static final int MAX_TITLE_LENGTH = 50;
    @Column(nullable = false)
    private String title;

    public JobPostingTitle(String title) {
        if (isBlank(title)) {
            throw new IllegalArgumentException();
        }
        if (length(title) > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobPostingTitle that = (JobPostingTitle) o;

        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
