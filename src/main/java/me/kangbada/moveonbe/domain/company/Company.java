package me.kangbada.moveonbe.domain.company;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "NAME_UNIQUE", columnNames = {"name"})
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {
    @EmbeddedId
    private CompanyId id;





}
