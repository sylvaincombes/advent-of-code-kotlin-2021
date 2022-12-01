fun main() {
    Day02Part2().run()
}

class Day02Part2 : DayAbstract("02", 900) {

    override fun resolve(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        val iterator = input.listIterator()
        while (iterator.hasNext()) {
            val (direction, distanceInput) = iterator.next().split(" ")
            val distance = distanceInput.toInt()
            when (direction) {
                "forward" -> {
                    horizontalPosition += distance
                    // It increases your depth by your aim multiplied by X.
                    depth += aim * distance
                }
                "down" -> aim += distance
                "up" -> aim -= distance
                else -> throw IllegalStateException("\uD83E\uDD37Unknow direction: $direction")
            }
        }

        return horizontalPosition * depth
    }
}
