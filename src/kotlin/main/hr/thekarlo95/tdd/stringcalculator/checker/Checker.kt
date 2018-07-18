package hr.thekarlo95.tdd.stringcalculator.checker

interface Checker {
    operator fun invoke(numbers: List<Long>): List<Long>
}