import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe


class ThingBehaviorSpec : BehaviorSpec() { init {

    Given("a thing") {
        val thing = Thing()

        When("call for action") {
            val value = thing.callForAction()

            Then("result should be dog") {
                value shouldBe "Dogs"
            }
        }

        When("call for action with bone") {
            val value = thing.callForAction("bone")

            Then("result should be: Dog eats bone.") {
                value shouldBe "Dog eats bone."
            }
        }
    }
}}
