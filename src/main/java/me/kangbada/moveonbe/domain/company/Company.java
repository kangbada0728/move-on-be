package me.kangbada.moveonbe.domain.company;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "NAME_UNIQUE", columnNames = {"name"})
})
public class Company {
    @EmbeddedId
    private CompanyId id;

    @Embedded
    private CompanyName name;

    @Embedded
    private JobPostings jobPostings;


}
