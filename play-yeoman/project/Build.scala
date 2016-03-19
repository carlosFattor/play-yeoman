import play.sbt.PlayScala
import sbt.Keys._
import sbt._

object ApplicationBuild extends Build {

  val appName = "play-yeoman"
  val appVersion = "1.0.0"

  val appDependencies = Seq(
  )

  val main = Project(appName, file(".")).enablePlugins(PlayScala).settings(
    version := appVersion,
    libraryDependencies ++= appDependencies,
    scalaVersion in Global := "2.11.8",
    crossScalaVersions := Seq("2.11.8"),
    homepage := Some(url("https://github.com/carlosFattor/play-yeoman")),
    organization := "com.guildacode",
    organizationName := "GuildaCode",
    organizationHomepage := Some(new java.net.URL("http://www.guildacode.com.br")),
    licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    publishMavenStyle := true,
    publishTo <<= version {
      (v: String) =>
        val nexus = "https://oss.sonatype.org/"
        if (v.trim.endsWith("SNAPSHOT"))
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishArtifact in Test := false,
    pomIncludeRepository := {
      _ => false
    },
    pomExtra := (
        <scm>
          <url>git@github.com:carlosFattor/play-yeoman.git</url>
          <connection>scm:git:git@github.com:carlosFattor/play-yeoman.git</connection>
        </scm>
        <developers>
          <developer>
            <id>kronuz</id>
            <name>Carlos Fattor</name>
            <url>https://twitter.com/Carlos_Fattor</url>
          </developer>
        </developers>)
  )
}
