package me.kangbada.moveonbe.domain.company;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyId implements Serializable {
    private static final int ZERO = 0;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public CompanyId(Long id) {
        if (id <= ZERO) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyId companyId = (CompanyId) o;
        return Objects.equals(id, companyId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
