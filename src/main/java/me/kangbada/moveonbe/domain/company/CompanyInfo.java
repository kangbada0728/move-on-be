package me.kangbada.moveonbe.domain.company;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.kangbada.moveonbe.company.nhn.NhnCrawlingService;
import me.kangbada.moveonbe.service.CrawlingService;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public enum CompanyInfo {
    NHN("NHN", new NhnCrawlingService()),
    ;

    private String name;
    private CrawlingService crawlingService;

    public String getName() {
        return name;
    }

    public CrawlingService getCrawlingService() {
        return crawlingService;
    }

}
