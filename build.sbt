/**
 *
 * Projects
 *
 */

lazy val `mvf-svc` =
  project.in(file("."))
  .aggregate(api, core)
  .settings(commonSettings: _*)

lazy val api =
  project.in(file("api"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= commonLibraries)
  .settings(
    name := "mvf-api"
  )
  .enablePlugins(GitVersioning)

lazy val core =
  project.in(file("core"))
  .dependsOn(api)
  .settings(commonSettings: _*)
  .settings(dockerSettings: _*)
  .settings(libraryDependencies ++= commonLibraries)
  .settings(
    name := "mvf-core"
  )
  .enablePlugins(GitVersioning, JavaServerAppPackaging, OpenShiftPlugin)


/**
 *
 * Commons
 *
 */

lazy val commonSettings = Seq(
  organization := "com.github.jw3",
  git.useGitDescribe := true,
  scalaVersion := "2.12.3",

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",

    "-feature",
    "-unchecked",
    "-deprecation",

    "-language:postfixOps",
    "-language:implicitConversions",

    "-Ywarn-unused-import",
    "-Xfatal-warnings",
    "-Xlint:_"
  )
)

lazy val akkaVersion = "2.5.6"
lazy val akkaHttpVersion = "10.0.10"
lazy val scalatestVersion = "3.0.3"

lazy val commonLibraries = {
  Seq(
    "com.iheart" %% "ficus" % "1.4.0",

    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-typed" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,

    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "org.julienrf" %% "play-json-derived-codecs" % "4.0.0",
    "com.typesafe.play" %% "play-ahc-ws-standalone" % "1.1.2",

    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "ch.qos.logback" % "logback-classic" % "1.1.9",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",

    "org.scalactic" %% "scalactic" % scalatestVersion % Test,
    "org.scalatest" %% "scalatest" % scalatestVersion % Test,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
  )
}

lazy val dockerSettings = Seq(
  packageName in Docker := "mvf-service",
  dockerExposedPorts := Seq(9000)
)
