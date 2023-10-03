package me.kangbada.moveonbe.vo;

public interface JobPostingVoBuilder {
    JobPostingVoBuilder title(String title);

    JobPostingVoBuilder recruitPeriod(String startDateStr, String endDateStr);

    JobPostingVoBuilder link(String link);

    JobPostingVo getJobPostingVo();

}
