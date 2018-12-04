package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._
import org.scalajs.dom

object Square {

  case class Props(number: String, onClick: Callback)
  case class State(number: String)



  final class Backend($: BackendScope[Props, Unit]) {

    def render(p: Props): VdomElement =
      <.button(
        ^.className := "Square",
        ^.onClick --> p.onClick,
        p.number)
  }

  val Component = ScalaComponent.builder[Props]("Square")
    .renderBackend[Backend]
    .build

  def apply(s:String, c: Callback) = Component(Props(s.toString, c))
}