package hr.thekarlo95.tdd.fizzbuzz

class FizzBuzz {

    operator fun invoke(number: Int): String {
        var output = ""
        if (1 > number || number > 100) {
            throw IllegalArgumentException("Parameter number must be between 1 and 100. It was $number")
        }
        if (number % 3 == 0) {
            output = "fizz"
        }
        if (number % 5 == 0) {
            output = "buzz"
        }
        if (output.isEmpty()) {
            output = "$number"
        }
        return output
    }
}