name := """draft"""

version := "1.0.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)


scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaJpa,
  javaWs,
jdbc,
  ws,
  filters,
  "org.got5" % "tapestry5-jquery" % "3.4.2",
  "org.webjars" % "bootstrap" % "3.3.7-1" exclude("org.webjars", "jquery"),


  "org.avaje" % "ebean" % "2.8.1",
"io.ebean" % "ebean-agent" % "10.1.7",
  "org.postgresql" % "postgresql" % "42.0.0",
  "org.easytesting" % "fest-assert" % "1.4",
  "org.testng" % "testng" % "6.8",
  "com.adrianhurt" %% "play-bootstrap" % "1.1.1-P25-B3-SNAPSHOT" ,

  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",


"junit" % "junit" % "4.4"





)
libraryDependencies += evolutions
routesGenerator := StaticRoutesGenerator


resolvers += Resolver.url("Edulify Repository", url("https://edulify.github.io/modules/releases/"))(Resolver.ivyStylePatterns)
resolvers ++= DefaultOptions.resolvers(snapshot = true)

playEbeanModels in Compile := Seq("models*")

playEbeanModels in Test := Seq("models*")
playEbeanDebugLevel := 4
inConfig(Test)(PlayEbean.scopedSettings)


fork in run := true