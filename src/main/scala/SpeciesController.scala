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

object SpeciesController {
 
  val Url = "http://swapi.co/api/species/?page=1&format=json" 
  implicit val formats = DefaultFormats
  case class Specie(name: String, classification : String, designation : String, average_height : String,
                    average_lifespan : String, eye_colors : String, hair_colors : String, skin_colors : String, homeworld: String, language : String,
                    created : String, edited : String, url : String)
  case class SpeciesPage(count : String, next : String, previous : String, results : List[Specie])


  def GetSpecies : List[Specie] = {
    var content: String = GetContent(Url)
    return parse(content).extract[SpeciesPage].results
  }

  //repetido
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

