package me.kangbada.moveonbe.domain.job.posting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JobPostingLinkTest {

    @DisplayName("채용공고 링크가 빈값이면 안된다.")
    @Test
    public void test1() {
        assertThatThrownBy(() -> {
            new JobPostingLink(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}