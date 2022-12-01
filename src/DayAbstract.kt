import java.io.File

abstract class DayAbstract(
    private val datasFolderNumber: String,
    private val testShouldEquals: Int
) {

    abstract fun resolve(input: List<String>): Int

    private fun runTest() {
        if (0 == testShouldEquals) {
            throw IllegalStateException("\uD83D\uDC77Please, implement the test")
        }

        val testResult = resolve(getTest())

        try {
            check(testResult == testShouldEquals)
        } catch (exception: IllegalStateException) {
            println("❌ Test failed $testResult is not equal to $testShouldEquals")
            throw exception
        }

        println("✔ Test passed: defined answer '$testShouldEquals' has been found \uD83D\uDCAA")
    }

    fun run() {
        println("\uD83D\uDDD2Starting ${javaClass.kotlin.simpleName}")
        runTest()
        println("\uD83D\uDE4BFinal answer is: \u001B[1m${resolve(getPuzzle())}\u001B[0m")
    }

    private fun getPuzzle(): List<String> {
        return loadFile("input")
    }

    private fun getTest(): List<String> {
        return loadFile("test")
    }

    private fun loadFile(name: String) = File("data/$datasFolderNumber", "$name.txt").readLines()
}
