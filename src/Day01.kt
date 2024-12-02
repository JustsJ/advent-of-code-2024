import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        for(line in input) {
            line.split("   ")
                .map { it.toInt() }
                .let {
                    list1.add(it[0])
                    list2.add(it[1])
                }
        }

        list1.sort()
        list2.sort()

        return list1.mapIndexed { index, item1 ->
            val item2 = list2[index]
            abs(item1 - item2)
        }.sum()
    }

    fun part2(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        for(line in input) {
            line.split("   ")
                .map { it.toInt() }
                .let {
                    list1.add(it[0])
                    list2.add(it[1])
                }
        }

        val frequencyMap = list2.groupingBy { it }.eachCount()

        return list1.sumOf {
            it * (frequencyMap[it] ?: 0)
        }
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 11)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}