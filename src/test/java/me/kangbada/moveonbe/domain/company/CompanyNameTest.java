package me.kangbada.moveonbe.domain.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CompanyNameTest {

    @DisplayName("회사명이 30글자를 넘으면 안된다.")
    @Test
    public void test1() {
        String 회사명 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        assertThatThrownBy(() -> {
            new CompanyName(회사명);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("회사명이 비어있으면 안된다.")
    @Test
    public void test2() {
        String 회사명 = "  ";
        assertThatThrownBy(() -> {
            new CompanyName(회사명);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}