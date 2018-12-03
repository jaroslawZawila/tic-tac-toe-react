package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object Board  {

  final class Backend($: BackendScope[Unit, Unit]) {
    val status = "Next player: X"

    def render(p: Unit): VdomElement =
      <.div(
        <.div(^.className := "status", status),
        <.div(^.className := "board-row",
          Square(1),
          Square(2),
          Square(3)),
        <.div(^.className := "board-row",
          Square(4),
          Square(5),
          Square(6)),
        <.div(^.className := "board-row",
          Square(7),
          Square(8),
          Square(9))
      )
  }

  val Component = ScalaComponent.builder[Unit]("Board")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}
