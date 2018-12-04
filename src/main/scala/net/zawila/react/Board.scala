package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._

object Board  {

  case class State(squares: List[String], isXNext: Boolean)

  final class Backend($: BackendScope[Unit, State]) {



    def handleClick(int: Int) = {
      $.modState(s => {
        val xOrO = if(s.isXNext) "X" else "O"
        State(s.squares.updated(int, xOrO), !s.isXNext)
      })
    }

    def render(p: Unit, state: State): VdomElement = {
      val xOrO = if(state.isXNext) "X" else "O"
      val status = s"Next player: $xOrO"
      <.div(
        <.div(^.className := "status", status),
        <.div(^.className := "board-row",
          renderSquare(0, state),
          renderSquare(1, state),
          renderSquare(2, state)),
        <.div(^.className := "board-row",
          renderSquare(3, state),
          renderSquare(4, state),
          renderSquare(5, state)),
        <.div(^.className := "board-row",
          renderSquare(6, state),
          renderSquare(7, state),
          renderSquare(8, state))
      )
    }


    def renderSquare(i: Int, state: State) = Square(state.squares(i), handleClick(i))
  }

  val Component = ScalaComponent.builder[Unit]("Board")
    .initialState(State((11 to 19).map(_.toString).toList, true))
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build
}
