name := "react-js"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)

scalaJSUseMainModuleInitializer := true

libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.3.1"

npmDependencies in Compile ++= Seq(
  "react" -> "16.5.1",
  "react-dom" -> "16.5.1")
