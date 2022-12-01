fun main() {
    Day03Part1().run()
}

class Day03Part1 : DayAbstract("03", 198) {

    override fun resolve(input: List<String>): Int {
        var gammaRate = ""
        var epsilonRate = ""
        val width = input.elementAt(1).length

        for (i in 1..width) {
            gammaRate += getMostFrequent(getColumnIndexFromInput(input, i)).toString()
            epsilonRate += getLessFrequent(getColumnIndexFromInput(input, i)).toString()
        }

        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }

    private fun getColumnIndexFromInput(input: List<String>, index: Int = 1): List<Int> {
        return input.map { it.split("")[index].toInt() }
    }

    private fun getMostFrequent(input: List<Int>): Int {
        if (input.count { it == 1 } > input.count { it == 0 }) {
            return 1
        }
        return 0
    }

    private fun getLessFrequent(input: List<Int>): Int {
        if (input.count { it == 1 } < input.count { it == 0 }) {
            return 1
        }
        return 0
    }
}
