fun main() {
    Day01Part1().run()
}

class Day01Part1 : DayAbstract("01", 7) {

    override fun resolve(input: List<String>): Int {
        val iterator = input.listIterator()
        var previous: Int? = null
        var current: Int?
        var increased = 0
        while (iterator.hasNext()) {
            if (iterator.hasPrevious()) {
                previous = iterator.previous().toInt()
                iterator.next()
            }
            current = iterator.next().toInt()

            if (previous != null && current > previous) {
                increased++
            }
        }

        return increased
    }
}
