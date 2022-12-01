fun main() {
    Day03Part2().run()
}

class Day03Part2 : DayAbstract("03", 230) {

    override fun resolve(input: List<String>): Int {
        val width = input.elementAt(1).length

        var oxygenGeneratorRatingList = input.toMutableList()
        var co2ScrubberRatingList = input.toMutableList()
        for (i in 1..width) {
            if (oxygenGeneratorRatingList.size > 1) {
                oxygenGeneratorRatingList =
                    oxygenGeneratorRatingList
                        .filter {
                            it.split("")[i] ==
                                getMostFrequent(getColumnIndexFromInput(oxygenGeneratorRatingList, i))
                                    .toString()
                        }
                        .toMutableList()
            }
            if (co2ScrubberRatingList.size > 1) {
                co2ScrubberRatingList =
                    co2ScrubberRatingList
                        .filter {
                            it.split("")[i] ==
                                getLessFrequent(getColumnIndexFromInput(co2ScrubberRatingList, i)).toString()
                        }
                        .toMutableList()
            }
            if (oxygenGeneratorRatingList.size == 1 && co2ScrubberRatingList.size == 1) {
                break
            }
        }

        val oxygenGeneratorRating = oxygenGeneratorRatingList.first().toInt(2)
        val co2ScrubberRating = co2ScrubberRatingList.first().toInt(2)

        return oxygenGeneratorRating * co2ScrubberRating
    }

    private fun getColumnIndexFromInput(input: List<String>, index: Int = 1): List<Int> {
        return input.map { it.split("")[index].toInt() }
    }

    private fun getMostFrequent(input: List<Int>): Int {
        if (input.count { it == 1 } >= input.count { it == 0 }) {
            return 1
        }
        return 0
    }

    private fun getLessFrequent(input: List<Int>): Int {
        if (input.count { it == 0 } <= input.count { it == 1 }) {
            return 0
        }
        return 1
    }
}
