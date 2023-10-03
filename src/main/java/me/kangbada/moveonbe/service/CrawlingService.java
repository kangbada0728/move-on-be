package me.kangbada.moveonbe.service;

import me.kangbada.moveonbe.vo.JobPostingVo;
import me.kangbada.moveonbe.vo.JobPostingVoBuilder;

import java.util.List;

public interface CrawlingService {
    List<JobPostingVo> crawlJobPostings(JobPostingVoBuilder voBuilder);
}
