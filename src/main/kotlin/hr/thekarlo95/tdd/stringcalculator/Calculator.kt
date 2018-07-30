package hr.thekarlo95.tdd.stringcalculator

import hr.thekarlo95.tdd.stringcalculator.checker.CompositeChecker

class Calculator {
    fun add(numbers: String): Long {
        var numberArray = getNumberArray(numbers)
        numberArray = CompositeChecker(numberArray)
        return numberArray
                .reduce { n1, n2 -> n1 + n2 }
    }

    private fun getNumberArray(numbers: String): List<Long> {
        val delimiters = getDelimiters(numbers)
        val newNumbers = getNumbers(numbers)

        return newNumbers.split(Regex("[${delimiters.joinToString("")}\\n]+")).map { if (it.isBlank()) 0 else it.toLong() }
    }

    private fun getNumbers(numbers: String): String {
        return if (numbers.isEmpty() || numbers[0] != '/') {
            numbers
        } else {
            numbers.substring(numbers.indexOf('\n') + 1)
        }
    }

    private fun getDelimiters(numbers: String, defaultDelimiter: String = ","): List<String> {
        return when {
            numbers.isEmpty() || numbers[0] != '/' -> {
                listOf(defaultDelimiter)
            }
            numbers.startsWith("//[") -> {
                val delimiterRegex = Regex("\\[([^\\[\\]]+)\\]", RegexOption.DOT_MATCHES_ALL)
                delimiterRegex.findAll(numbers)
                        .map { it.groups[1]?.value }
                        .filterNotNull()
                        .toList()
            }
            numbers.startsWith("//") -> {
                listOf(numbers[2].toString())
            }
            else -> {
                throw IllegalArgumentException("Invalid parameter numbers - $numbers")
            }
        }
    }
}