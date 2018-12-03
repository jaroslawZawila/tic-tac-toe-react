package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object Square {

  final class Backend($: BackendScope[Unit, Unit]) {
    def render(p: Unit): VdomElement =
      <.button(^.className := "Square")
  }

  val Component = ScalaComponent.builder[Unit]("Square")
    .renderBackend[Backend]
    .build
}