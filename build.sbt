ThisBuild / scalaVersion := "3.3.0"
ThisBuild / version := "1.2.1"
ThisBuild / organization := "com.stulsoft"
ThisBuild / organizationName := "stulsoft"

lazy val root = (project in file("."))
  .settings(
    name := "ys-scala-swing",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.6",
    libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
  )