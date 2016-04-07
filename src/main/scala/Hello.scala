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

object Hello {

  val Url = "http://swapi.co/api/people"
  implicit val formats = DefaultFormats
  case class Person(name: String,height: String,mass: String,hair_color: String,skin_color: String,eye_color: String,birth_year: String,gender: String,homeworld: List[String],films: String,species: String,vehicles: String,starships: String,created: String,edited: String,url: String)
  case class People(people : List[Person])
  case class PeolplePage(count : String, next : String, previous : String, people : List[Person])

  def main(args: Array[String]): Unit = {
    println(GetPeople)
  }

  def GetPeople : List[Person] = {
    var content: String = GetContent(Url)
    return parse(content).extract[PeolplePage].people
  }

  def GetContent(url : String): String = {
    val httpClient = new DefaultHttpClient
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity()
    var content = ""
    if (entity != null) {
      val inputStream = entity.getContent()
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close
    }
    httpClient.getConnectionManager().shutdown()
    content
  }
}

