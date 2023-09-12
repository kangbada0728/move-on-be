package me.kangbada.moveonbe.domain.job.posting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JobPostingTitleTest {

    @DisplayName("채용공고 제목은 비어있으면 안된다.")
    @Test
    public void test1() {
        Assertions.assertThatThrownBy(() -> {
            new JobPostingTitle(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("채용공고 제목은 길이가 50자리를 넘으면 안된다.")
    @Test
    public void test2() {
        Assertions.assertThatThrownBy(() -> {
            new JobPostingTitle("가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}