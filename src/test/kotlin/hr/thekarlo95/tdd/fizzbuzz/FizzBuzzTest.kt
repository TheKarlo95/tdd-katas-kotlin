package hr.thekarlo95.tdd.fizzbuzz

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FizzBuzzTest {

    lateinit var fizzBuzz: FizzBuzz

    @Before
    fun before() {
        fizzBuzz = FizzBuzz()
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_less_than_1() {
        fizzBuzz(0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_more_than_100() {
        fizzBuzz(101)
    }

    @Test
    fun test_number_1() {
        assertEquals("1", fizzBuzz(1))
    }

    @Test
    fun test_number_2() {
        assertEquals("2", fizzBuzz(2))
    }

    @Test
    fun test_number_3() {
        assertEquals("fizz", fizzBuzz(3))
    }

    @Test
    fun test_number_4() {
        assertEquals("4", fizzBuzz(4))
    }

    @Test
    fun test_number_5() {
        assertEquals("buzz", fizzBuzz(5))
    }

    @Test
    fun test_number_6() {
        assertEquals("fizz", fizzBuzz(6))
    }

    @Test
    fun test_number_7() {
        assertEquals("7", fizzBuzz(7))
    }

    @Test
    fun test_number_8() {
        assertEquals("8", fizzBuzz(8))
    }

    @Test
    fun test_number_9() {
        assertEquals("fizz", fizzBuzz(9))
    }

    @Test
    fun test_number_10() {
        assertEquals("buzz", fizzBuzz(10))
    }

    @Test
    fun test_number_11() {
        assertEquals("11", fizzBuzz(11))
    }

    @Test
    fun test_number_12() {
        assertEquals("fizz", fizzBuzz(12))
    }

    @Test
    fun test_number_13() {
        assertEquals("13", fizzBuzz(13))
    }

    @Test
    fun test_number_14() {
        assertEquals("14", fizzBuzz(14))
    }

    @Test
    fun test_number_15() {
        assertEquals("fizzbuzz", fizzBuzz(15))
    }
}