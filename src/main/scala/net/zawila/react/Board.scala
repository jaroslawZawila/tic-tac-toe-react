package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object Board  {

  case class State(squares: List[String])

  final class Backend($: BackendScope[Unit, State]) {

    val status = "Next player: X"

    def handleClick(int: Int) = {
      $.modState(s => State(s.squares.updated(int, "X")))
    }

    def render(p: Unit, state: State): VdomElement =
      <.div(
        <.div(^.className := "status", status),
        <.div(^.className := "board-row",
          Square(state.squares(0), handleClick(0)),
          Square(state.squares(1), handleClick(1)),
          Square(state.squares(2), handleClick(2))),
        <.div(^.className := "board-row",
          Square(state.squares(3), handleClick(3)),
          Square(state.squares(4), handleClick(4)),
          Square(state.squares(5), handleClick(5))),
        <.div(^.className := "board-row",
          Square(state.squares(6), handleClick(6)),
          Square(state.squares(7), handleClick(7)),
          Square(state.squares(8), handleClick(8)))
      )
  }

  val Component = ScalaComponent.builder[Unit]("Board")
    .initialState(State((11 to 19).map(_.toString).toList))
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}
