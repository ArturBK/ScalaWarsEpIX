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
    SaveAll(PeopleController.GetPeople.groupBy(_.species(0)))
    SaveElder(PeopleController.GetPeople.groupBy(_.species(0)))
  }

  def SaveElder(people: Map[String, List[PeopleController.Person]]) : List[PeopleController.Person]] = {
    people map { case (specie, people) => people.sortBy(p => p).head } toList
  }

  def SaveNonSpecial(people: Map[String, List[PeopleController.Person]])  List[PeopleController.Person]] = {
    people map { case (specie, people) => people.sortBy(p => p).tail} toList).flatten
  }

  def extractElders(allPeople: List[Person]) =
    allPeople.groupBy(p => p.urlSpecie) map { case (specie, people) => people.sortBy(p => p).head } toList

  def SaveAll(people: Map[String, List[PeopleController.Person]]) : Map[String, List[PeopleController.Person]] = {
    people
  }

  def ShipManager(people: Map[String, List[PeopleController.Person]]) : Map[String, List[PeopleController.Person]] = {
    people
  }
}