name := "react-js"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)
enablePlugins(WebScalaJSBundlerPlugin)

scalaJSUseMainModuleInitializer := true

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "1.3.1",
  "com.github.japgolly.scalajs-react" %%% "extra" % "1.3.1",
//  "com.github.japgolly.scalacss" %% "core" % "0.5.5",
  "com.github.japgolly.scalacss" %%% "ext-react" % "0.5.5")

npmDependencies in Compile ++= Seq(
  "react" -> "16.5.1",
  "react-dom" -> "16.5.1",
  "bootstrap" -> "4.1.3")

npmAssets ++= NpmAssets.ofProject(LocalProject("react-js")) { nodeModules =>
  (nodeModules / "bootstrap").allPaths // sbt 1.0.0+
}.value