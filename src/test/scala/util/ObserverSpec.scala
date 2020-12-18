package util

import controller.controllerbase.Controller
import model._
import model.fieldbase.FieldImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ObserverSpec extends AnyWordSpec with Matchers {
  "A Controller" when {
    "observed by observer" should {
      val controller = new Controller()
      val observer: Observer = new Observer {
        var updated: Boolean = false

        override def update(): Unit = updated = true
      }
      controller.add(observer)
      "notify observers after changing turns" in {
        controller.changePlayerTurn()
        observer.updated shouldBe true
      }
      "remove an observer" in {
        controller.remove(observer)
        controller.subscribers should not contain observer
      }
    }
  }
}
