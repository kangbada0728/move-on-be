package me.kangbada.moveonbe.domain.job.posting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JobPostingIdTest {
    @DisplayName("채용공고 아이디는 양수여야 한다.")
    @Test
    public void test1() {
        Long 채용공고_아이디 = 0L;
        assertThatThrownBy(() -> {
            new JobPostingId(채용공고_아이디);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}