import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {


  "Hello" should "have tests" in {
    true should be === true
  }

  "SaveElder" should "return 1" in {
      RescueController.SaveElder(mockElder) should be === mockElder
  }

  "SaveAll" should "return 1" in {
    RescueController.SaveElder(mockElder) should be === mockElder
  }

  "Rescue" should "return 1" in {
    RescueController.SaveElder(mockElder) should be === mockElder
  }

  def mockElder :  Map[String, List[PeopleController.Person]] = {
    Map("1" -> List(PeopleController.Person("name", "height", "mass", "hair_color", "skin_color", "eye_color", "birth_year", "gender", List("specie"), "created", "edited", "url")),List(PeopleController.Person("name", "height", "mass", "hair_color", "skin_color", "eye_color", "birth_year", "gender", List("specie"), "created", "edited", "url")))
  }
}
