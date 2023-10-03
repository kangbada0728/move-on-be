package me.kangbada.moveonbe.company.nhn;

import me.kangbada.moveonbe.vo.JobPostingVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NhnCrawlingServiceTest {

    public static final String 백엔드 = "백엔드";

    @DisplayName("NHN 기술 모집분야 채용공고 가져오기")
    @Test
    void NHN_기술_모집분야_채용공고_가져오기() {
        NhnCrawlingService nhnCrawlingService = new NhnCrawlingService();
        List<JobPostingVo> jobPostingVos = nhnCrawlingService.crawlJobPostings();
        assertThat(jobPostingVos)
                .flatExtracting(JobPostingVo::getTitle)
                .contains(백엔드);
    }

}