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
          Square.Component(),
          Square.Component(),
          Square.Component()),
        <.div(^.className := "board-row",
          Square.Component(),
          Square.Component(),
          Square.Component()),
        <.div(^.className := "board-row",
          Square.Component(),
          Square.Component(),
          Square.Component())
      )
  }

  val Component = ScalaComponent.builder[Unit]("Board")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}
