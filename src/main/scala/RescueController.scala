import org.apache.http.impl.client.DefaultHttpClient
import java.io._
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import scala.collection.mutable.StringBuilder
import org.json4s._
import org.json4s.native.JsonMethods._


object RescueController {

  def Rescue : Map[String, List[PeopleController.Person]] = {
    PeopleController.GetPeople.groupBy(_.species(0))
  }

  def max(p1: PeopleController.Person, p2: PeopleController.Person): PeopleController.Person = {
    if (p1.birth_year > p2.birth_year) p1 else p2
  }
}