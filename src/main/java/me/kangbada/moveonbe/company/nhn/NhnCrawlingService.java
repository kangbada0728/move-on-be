package me.kangbada.moveonbe.company.nhn;

import me.kangbada.moveonbe.service.CrawlingService;
import me.kangbada.moveonbe.vo.JobPostingVo;
import me.kangbada.moveonbe.vo.JobPostingVoBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NhnCrawlingService implements CrawlingService {
    private static final String NHN_RECRUIT_URL = "https://recruit.nhn.com";
    private static final String SEARCH_RECRUITS_BY_CLASS = "/ent/recruitings?type=class";
    private static final String TECH_RECRUIT_LIST = "기술 공고 목록";

    @Override
    public List<JobPostingVo> crawlJobPostings(JobPostingVoBuilder voBuilder) {
        NhnJobPostingVoBuilder nhnJobPostingVoBuilder = (NhnJobPostingVoBuilder) voBuilder;
        try {
            Document document = Jsoup.connect(NHN_RECRUIT_URL + SEARCH_RECRUITS_BY_CLASS).get();
            Element container = document.getElementById("container");
            Elements fields = container.select(".sub .cont_wrap .cont_area .tbl_sec");
            Element techField = fields.stream()
                    .filter(e -> e.select(".blind").text().contains(TECH_RECRUIT_LIST))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
            Elements trs = techField.select("tbody tr");

            List<JobPostingVo> jobPostingVos = new ArrayList<>();
            for (Element tr : trs) {
                Elements tds = tr.select("td");
                Element firstTd = tds.get(0).select(".frst_td a").first();
                String title = firstTd.text();
                String href = firstTd.attr("href");
                String link = NHN_RECRUIT_URL + href;
                String recruitTarget = tds.get(1).text();
                String recruitClass = tds.get(2).text();
                String recruitPeriod = tds.get(3).text();
                String[] recruitPeriodSplitArr = recruitPeriod.split(" ~");
                String startDateStr = recruitPeriodSplitArr[0];
                String endDateStr = recruitPeriodSplitArr[1];

                JobPostingVo jobPostingVo = nhnJobPostingVoBuilder
                        .title(title)
                        .recruitPeriod(startDateStr, endDateStr)
                        .link(link)
                        .getJobPostingVo();
                jobPostingVos.add(jobPostingVo);
            }

            return jobPostingVos;

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }




}
