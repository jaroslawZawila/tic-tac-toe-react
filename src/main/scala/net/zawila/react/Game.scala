package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._
import org.scalajs.dom.document
import org.scalajs.dom.raw.HTMLStyleElement

import scala.scalajs.js.annotation.{JSExport, JSImport}
import scalacss.ScalaCssReact._
import scalacss.DevDefaults._
import scalacss.ScalaCssReact  // Always use dev settings

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
        ),
        <.div(
        BankHolidayComponent.Component()
      )
      )
  }

  val Component = ScalaComponent.builder[Unit]("Game")
    .renderBackend[Backend]
    //.configure(Reusability.shouldComponentUpdate)
    .build

  @JSImport("bootstrap", JSImport.Namespace)
  @JSExport
  def main(args: Array[String]): Unit = {
//    document.head.appendChild(CSS.render[HTMLStyleElement])
    CSS.addToDocument()
    Game.Component().renderIntoDOM(document.body)
  }
}