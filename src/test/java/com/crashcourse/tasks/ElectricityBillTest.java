package com.crashcourse.tasks;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class ElectricityBillTest {

    @Test
    void whenUnitsLessThan100AndNoDelayThenFirstRate() {
        double result = ElectricityBill.calculateBill(80, 0);

        assertThat(result).isCloseTo(400.0, within(0.001));
    }

    @Test
    void whenUnitsBetween100And300AndNoDelayThenTwoRates() {
        double result = ElectricityBill.calculateBill(250, 0);

        assertThat(result).isCloseTo(1700.0, within(0.001));
    }

    @Test
    void whenUnitsMoreThan300AndNoDelayThenThreeRates() {
        double result = ElectricityBill.calculateBill(350, 0);

        assertThat(result).isCloseTo(2700.0, within(0.001));
    }

    @Test
    void whenDelayFrom1To5DaysThenAdd5PercentPenalty() {
        double result = ElectricityBill.calculateBill(100, 3);

        assertThat(result).isCloseTo(525.0, within(0.001));
    }

    @Test
    void whenDelayFrom6To10DaysThenAdd10PercentPenalty() {
        double result = ElectricityBill.calculateBill(100, 7);

        assertThat(result).isCloseTo(550.0, within(0.001));
    }

    @Test
    void whenDelayMoreThan10DaysThenAdd20PercentPenalty() {
        double result = ElectricityBill.calculateBill(100, 12);

        assertThat(result).isCloseTo(600.0, within(0.001));
    }

    @Test
    void whenTotalMoreThan5000ThenApplyDiscount() {
        double result = ElectricityBill.calculateBill(600, 0);

        assertThat(result).isCloseTo(5200.0, within(0.001));
    }

    @Test
    void whenPenaltyMakesTotalMoreThan5000ThenDiscountAppliedAfterPenalty() {
        double result = ElectricityBill.calculateBill(600, 12);

        assertThat(result).isCloseTo(6340.0, within(0.001));
    }

}