package hr.thekarlo95.tdd.stringcalculator.checker

class MoreThanThousandChecker: Checker {
    override fun invoke(numbers: List<Long>): List<Long> {
        return numbers.filterNot { it > 1000 }
    }
}