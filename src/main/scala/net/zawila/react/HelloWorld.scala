package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.document

import scala.scalajs.js.annotation.JSExport

object TutorialApp {

  val Hello = ScalaComponent.builder[String]("Hello")
    .render_P(name => <.div(^.onClick --> onButtonPressed,
      "Hello there ", name))
    .build

  def onButtonPressed: Callback =
    Callback.alert("The button was pressed!")

  @JSExport
  def main(args: Array[String]): Unit = {
    Hello("jarek").renderIntoDOM(document.body)
  }
}