import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.0",
      version      := "0.1.0-SNAPSHOT"
    )),

    name := "Simple Scala Features",

    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0-M4",

  )

