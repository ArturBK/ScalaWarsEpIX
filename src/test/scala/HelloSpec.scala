import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {


  "Hello" should "have tests" in {
    true should be === true
  }

  "SaveElder" should "return 1" in {
      RescueController.SaveElder(mockElder) should be === ElderSaved
  }

  "SaveAll" should "return 1" in {
    RescueController.SaveElder(mockElder) should be === ElderSaved
  }

  "Rescue" should "return 1" in {
    RescueController.SaveAll(mockElder) should be === MockElder
  }

  def MockElder :  Map[String, List[PeopleController.Person]] = {
    Map("1" -> List(PeopleController.Person("name", "height", "mass", "hair_color", "skin_color", "eye_color", "birth_year", "gender", List("specie"), "created", "edited", "url"))))
  }

  def ElderSaved :  Map[String, List[PeopleController.Person]] = {
    List(PeopleController.Person("name", "height", "mass", "hair_color", "skin_color", "eye_color", "birth_year", "gender", List("specie"), "created", "edited", "url")))
  }
}
