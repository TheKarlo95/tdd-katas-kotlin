package hr.thekarlo95.tdd.stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    lateinit var calculator: Calculator

    @Before
    fun before() {
        calculator = Calculator()
    }

    @Test
    fun test_add_empty_string() {
        val result = calculator.add("")
        assertEquals(0, result)
    }

    @Test
    fun test_add_one_positive_number() {
        val result = calculator.add("3")
        assertEquals(3, result)
    }

    @Test
    fun test_add_two_positive_number() {
        val result = calculator.add("3,3")
        assertEquals(6, result)
    }

    @Test
    fun test_add_lot_of_numbers() {
        val numbers = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).map { "$it" }.reduce { s1, s2 -> "$s1,$s2" }
        val result = calculator.add(numbers)
        assertEquals(55, result)
    }

    @Test
    fun test_add_test_new_line_in_numbers() {
        val result = calculator.add("1\n2,3")
        assertEquals(6, result)
    }

    @Test
    fun test_add_test_different_delimiter() {
        val result = calculator.add("//;\n1;2")
        assertEquals(3, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_add_one_negative_numbers_throws_exception() {
        calculator.add("-2")
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_add_two_negatives_one_psoitive_numbers_throws_exception() {
        calculator.add("2,-3,-5")
    }

    @Test
    fun test_add_exclude_more_than_1000() {
        val result = calculator.add("2,1001")
        assertEquals(2, result)
    }

    @Test
    fun test_add_dont_exclude_1000() {
        val result = calculator.add("1000,2")
        assertEquals(1002, result)
    }

    @Test
    fun test_add_any_size_delimiter() {
        val result = calculator.add("//[***]\n1***2***3")
        assertEquals(6, result)
    }

    @Test
    fun test_add_mutliple_delimiters() {
        val result = calculator.add("//[*][%]\n1*2%3")
        assertEquals(6, result)
    }

    @Test
    fun test_add_mutliple_delimiters_of_any_size() {
        val result = calculator.add("//[**][%][&&&]\n1**2%3&&&4")
        assertEquals(10, result)
    }
}