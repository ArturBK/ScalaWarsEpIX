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

  implicit val formats = DefaultFormats

  //case class Person(name: String, height: String)
  case class Person(name: String,height: String,mass: String,hair_color: String,skin_color: String,eye_color: String,birth_year: String,gender: String,homeworld: List,films: String,species: String,vehicles: String,starships: String,created: String,edited: String,url: String)


  def main(args: Array[String]): Unit = {
    def GetUrlContent = {
      val url = "http://swapi.co/api/people/1"

      val result = scala.io.Source.fromURL(url).mkString
      println(result)
    }

    def GetRestContent : String = {
      val url = "http://swapi.co/api/people/1"

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

      println(parse(content).extract[Person])

      return content
    }

    println(GetRestContent)
  }
}

