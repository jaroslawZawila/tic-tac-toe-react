package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Component
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.document

import scala.scalajs.js.annotation.JSExport

object TutorialApp {

  @JSExport
  def main(args: Array[String]): Unit = {
    MouseEvents.Component().renderIntoDOM(document.body)
  }
}