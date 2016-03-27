object Hello {
  def main(args: Array[String]): Unit = {
    def GetUrlContent = {

      val url = "http://swapi.co/api/people/1"
      val result = scala.io.Source.fromURL(url).mkString
      println(result)
    }

    GetUrlContent
  }
}
