package me.kangbada.moveonbe.vo;

import lombok.Getter;

import java.net.URI;
import java.time.LocalDate;
import java.util.Objects;

@Getter
public class JobPostingVo {
    private final String title;
    private final LocalDate recruitPeriodStart;
    private final LocalDate recruitPeriodEnd;
    private final URI link;


    public JobPostingVo(String title, LocalDate recruitPeriodStart, LocalDate recruitPeriodEnd, URI link) {
        this.title = title;
        this.recruitPeriodStart = recruitPeriodStart;
        this.recruitPeriodEnd = recruitPeriodEnd;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobPostingVo that = (JobPostingVo) o;

        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return link != null ? link.hashCode() : 0;
    }

}
