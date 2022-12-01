fun main() {
    Day02Part1().run()
}

class Day02Part1 : DayAbstract("02", 150) {

    override fun resolve(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        val iterator = input.listIterator()
        while (iterator.hasNext()) {
            val (direction, distance) = iterator.next().split(" ")
            when (direction) {
                "forward" -> horizontalPosition += distance.toInt()
                "down" -> depth += distance.toInt()
                "up" -> depth -= distance.toInt()
                else -> throw IllegalStateException("\uD83E\uDD37Unknow direction: $direction")
            }
        }

        return horizontalPosition * depth
    }
}
