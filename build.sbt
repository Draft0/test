name := """draft"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)


scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,

  javaWs,
jdbc,
  "org.webjars" % "jquery" % "1.11.1",
  "org.webjars" % "bootstrap" % "3.3.7" exclude("org.webjars", "jquery"),
"org.avaje" % "ebean" % "2.8.1",
"io.ebean" % "ebean-agent" % "10.1.7",
  "org.postgresql" % "postgresql" % "42.0.0",
  "org.easytesting" % "fest-assert" % "1.4",
  "org.testng" % "testng" % "6.8"

)
libraryDependencies += evolutions




resolvers ++= DefaultOptions.resolvers(snapshot = true)

playEbeanModels in Compile := Seq("models.ebean*")

playEbeanModels in Test := Seq("models.ebean*")
playEbeanDebugLevel := 4
inConfig(Test)(PlayEbean.scopedSettings)


fork in run := true