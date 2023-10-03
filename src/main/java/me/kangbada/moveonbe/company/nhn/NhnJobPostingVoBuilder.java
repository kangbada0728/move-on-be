package me.kangbada.moveonbe.company.nhn;

import me.kangbada.moveonbe.vo.JobPostingVoBuilder;
import me.kangbada.moveonbe.vo.JobPostingVo;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static me.kangbada.moveonbe.domain.job.posting.JobPostingTitle.MAX_TITLE_LENGTH;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.length;

public class NhnJobPostingVoBuilder implements JobPostingVoBuilder {
    private static final String YYYY_MM_DD = "yyyy.MM.dd";

    private String title;
    private LocalDate recruitPeriodStart;
    private LocalDate recruitPeriodEnd;
    private URI link;


    @Override
    public JobPostingVoBuilder title(String title) {
        if (isBlank(title)) {
            throw new IllegalArgumentException();
        }
        if (length(title) > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        return this;
    }

    @Override
    public JobPostingVoBuilder recruitPeriod(String startDateStr,
                                             String endDateStr) {

        if (isBlank(startDateStr) || isBlank(endDateStr)) {
            throw new IllegalArgumentException();
        }
        try {
            this.recruitPeriodStart = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern(YYYY_MM_DD));
        } catch (DateTimeParseException e) {
            this.recruitPeriodStart = LocalDate.MIN;
        }
        try {
            this.recruitPeriodEnd = LocalDate.parse(endDateStr, DateTimeFormatter.ofPattern(YYYY_MM_DD));
        } catch (DateTimeParseException e) {
            this.recruitPeriodEnd = LocalDate.MAX;
        }
        return this;
    }

    @Override
    public JobPostingVoBuilder link(String link) {
        URI uri = URI.create(link);
        this.link = uri;
        return this;
    }

    @Override
    public JobPostingVo getJobPostingVo() {
        return new JobPostingVo(title, recruitPeriodStart, recruitPeriodEnd, link);
    }
}
