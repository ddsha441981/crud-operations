package com.codewithcup.crudoperations;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CrudOperationsApplicationTests {

    Calculator calculator = new Calculator();

    @Test
    void isShouldAddNumbers() {
        //given
        int numberOne = 20;
        int numberTwo = 10;
        //when
        int result = calculator.add(numberOne, numberTwo);
        //then
        int expectedResult = 30;
        assertThat(result).isEqualTo(expectedResult);
    }
    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}
