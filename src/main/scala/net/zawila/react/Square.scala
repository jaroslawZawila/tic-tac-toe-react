package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object Square {

  case class Props(number: Int)

  final class Backend($: BackendScope[Unit, Props]) {
    def render(p: Props): VdomElement =
      <.button(^.className := "Square", p.number)
  }

  val Component = ScalaComponent.builder[Unit]("Square")
    .initialState(Props(1))
    .renderBackend[Backend]
    .build
}