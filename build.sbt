ThisBuild / organization := "pico.lexeval"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.3.6"

ThisBuild / javacOptions ++= Seq("--release", "21")
ThisBuild / scalacOptions ++= Seq("-release:21")

javaOptions += "--enable-native-access=ALL-UNNAMED"

val buildModules: Set[String] = sys.props.get("buildModules")
  .map(_.split(",").map(_.trim).toSet)
  .getOrElse(Set.empty)

lazy val coreApi = (project in file("core-api"))
  .settings(
    name := "core-api",
    idePackagePrefix := Some("pico.lexeval.core.api")
  )

def getProjectName(p: ProjectReference): String = p match {
  case ProjectRef(_, id) => id
  case LocalProject(id) => id
  case _ => ""
}

def includeModule(p: ProjectReference): Boolean =
  buildModules.isEmpty || buildModules.contains(getProjectName(p))

lazy val allModules: Seq[ProjectReference] = Seq(coreApi)

lazy val root = (project in file("."))
  .aggregate(allModules.filter(includeModule): _*)
  .settings(
    name := "lexeval",
    publish / skip := true
  )
