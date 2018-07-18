package hr.thekarlo95.tdd.stringcalculator.checker

class NegativeChecker: Checker {
    override fun invoke(numbers: List<Long>): List<Long> {
        val negatives = numbers.filter { it < 0 }
        if(negatives.isNotEmpty()) {
            throw IllegalArgumentException("negatives not allowed - ${negatives.joinToString(",")}")
        } else {
            return numbers
        }
    }
}