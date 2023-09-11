package me.kangbada.moveonbe.domain.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CompanyIdTest {
    @DisplayName("회사 아이디는 양수여야 한다.")
    @Test
    public void test1() {
        Long 회사아이디 = 0L;
        assertThatThrownBy(() -> {
            new CompanyId(회사아이디);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}