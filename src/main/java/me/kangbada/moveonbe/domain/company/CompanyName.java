package me.kangbada.moveonbe.domain.company;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.length;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyName {
    private static final int MAX_NAME_LENGTH = 30;

    @Column(nullable = false, length = 100)
    private String name;

    public CompanyName(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException();
        }
        if (length(name) > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyName that = (CompanyName) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
