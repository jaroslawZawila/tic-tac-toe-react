package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._
import org.scalajs.dom.document

import scala.scalajs.js.annotation.JSExport

object Game {

  final class Backend($: BackendScope[Unit, Unit]) {
    def render(p: Unit): VdomElement =
      <.div(^.className := "game",
        <.div(^.className := "game-board",
          Board.Component()
        ),
        <.div(^.className := "game-info",
          <.div,
          <.ol
        )
      )
  }

  val Component = ScalaComponent.builder[Unit]("Game")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build

  @JSExport
  def main(args: Array[String]): Unit = {
    Game.Component().renderIntoDOM(document.body)
  }
}