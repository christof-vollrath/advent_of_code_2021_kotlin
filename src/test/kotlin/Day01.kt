import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.*

private fun parseSonarData(input: String): List<Int> = input.lines().map { it.trim().toInt() }

private fun countIncreased(sonarData: List<Int>) =
    sonarData.drop(1).zip(sonarData).count { (current, before) -> current > before }

private fun calculateSlidingSums(sonarData: List<Int>): List<Int> {
    val triples = sonarData.zip(sonarData.drop(1)).zip(sonarData.drop(2))
    return triples.map { it.first.first + it.first.second + it.second }
}

val exampleInput = """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263        
        """.trimIndent()

class Day01Part1 : BehaviorSpec() { init {

    Given("example input") {

        When("parsing sonar data") {
            val sonarData = parseSonarData(exampleInput)
            Then("it should have 10 entries with the right values") {
                sonarData.size shouldBe 10
                sonarData[0] shouldBe 199
                sonarData[2] shouldBe 208
            }
        }
        When("counting increases") {
            val sonarData = parseSonarData(exampleInput)
            val increasedCount = countIncreased(sonarData)
            Then("it should be 7") {
                increasedCount shouldBe 7
            }
        }
    }

    Given("input") {
        val input = readResource("day01resources.txt")!!
        When("counting increases") {
            val sonarData = parseSonarData(input)
            val increasedCount = countIncreased(sonarData)
            Then("it should be result") {
                increasedCount shouldBe 1696
            }
        }
    }
} }


class Day01Part2 : BehaviorSpec() { init {

    Given("example input") {
        val sonarData = parseSonarData(exampleInput)
        When("sum tripples") {
            val tripples = calculateSlidingSums(sonarData)
            Then("it should have summed each tripple") {
                tripples shouldBe listOf(607, 618, 618, 617, 647, 716, 769, 792)
            }
            val increasedCount = countIncreased(tripples)
            Then("it should have counted increases") {
                increasedCount shouldBe 5
            }
        }
    }
    Given("input") {
        val input = readResource("day01resources.txt")!!
        When("counting increases of triples") {
            val sonarData = parseSonarData(input)
            val tripples = calculateSlidingSums(sonarData)
            val increasedCount = countIncreased(tripples)
            Then("it should be result") {
                increasedCount shouldBe 1737
            }
        }
    }
} }