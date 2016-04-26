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
    Map[String, List[PeopleController.Person]] map = PeopleController.GetPeople.groupBy(_.species(0))
    ListMap(map.toSeq.sortWith(_._birth_year > _._birth_year):_*)
    //map.sortBy((m) -> m._2.birth_year)
    //Map("foo"->3, "raise"->1, "the"->2, "bar"->4).toList sortBy {_._2}

    //map.reduceLeft(max)
  }

  def max(p1: PeopleController.Person, p2: PeopleController.Person): PeopleController.Person = {
    if (p1.birth_year > p2.birth_year) p1 else p2
  }
}