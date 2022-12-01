fun main() {
    Day01Part2().run()
}

class Day01Part2 : DayAbstract("01", 5) {

    override fun resolve(input: List<String>): Int {
        val iterator = input.listIterator()
        var previousSum: Int? = null
        var sum: Int? = null
        var increased = 0

        for ((index, _) in iterator.withIndex()) {

            val hasPreviousSum = hasIndexes(input, arrayOf(index - 1, index, index + 1))
            val hasSum = hasIndexes(input, arrayOf(index, index + 1, index + 2))

            if (hasPreviousSum) {
                previousSum = input[index - 1].toInt() + input[index].toInt() + input[index + 1].toInt()
            }

            if (hasSum) {
                sum = input[index].toInt() + input[index + 1].toInt() + input[index + 2].toInt()
            }

            if (previousSum != null && sum != null && sum > previousSum) {
                increased++
            }
        }

        return increased
    }

    private fun hasIndexes(input: List<String>, indexes: Array<Int>): Boolean {
        for (index in indexes) {
            if (input.elementAtOrNull(index).isNullOrEmpty()) {
                return false
            }
        }

        return true
    }
}
