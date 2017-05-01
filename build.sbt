name := """draft"""

version := "2.6.2-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)


scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaJpa,
  javaWs,
jdbc,
  "org.webjars" % "jquery" % "1.11.1",
  "org.webjars" % "bootstrap" % "3.3.7" exclude("org.webjars", "jquery"),
"org.avaje" % "ebean" % "2.8.1",
"io.ebean" % "ebean-agent" % "10.1.7",
  "org.postgresql" % "postgresql" % "42.0.0",
  "org.easytesting" % "fest-assert" % "1.4",
  "org.testng" % "testng" % "6.8",
  "org.hibernate" % "hibernate-core" % "5.2.5.Final",
  "org.springframework" % "spring-context" % "4.2.7.RELEASE",
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.webjars" % "webjars-play_2.11" % "2.5.0-4",

"junit" % "junit" % "4.4"





)
libraryDependencies += evolutions



resolvers += Resolver.url("Edulify Repository", url("https://edulify.github.io/modules/releases/"))(Resolver.ivyStylePatterns)
resolvers ++= DefaultOptions.resolvers(snapshot = true)

playEbeanModels in Compile := Seq("models.ebean*")

playEbeanModels in Test := Seq("models.ebean*")
playEbeanDebugLevel := 4
inConfig(Test)(PlayEbean.scopedSettings)


fork in run := true