package hr.thekarlo95.tdd.stringcalculator.checker

object CompositeChecker : Checker {

    private val checkers = listOf(NegativeChecker(), MoreThanThousandChecker())

    override fun invoke(numbers: List<Long>): List<Long> {
        var newNumbers = listOf<Long>() + numbers
        checkers.forEach {
            newNumbers = it(newNumbers)
        }
        return newNumbers
    }
}