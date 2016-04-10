name := """hello-scala"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "test",
                            "org.apache.httpcomponents" % "httpclient" % "4.0-alpha4",
                            "org.json4s" % "json4s-native_2.11" % "3.3.0")

fork in run := true

fork in run := true

fork in run := true