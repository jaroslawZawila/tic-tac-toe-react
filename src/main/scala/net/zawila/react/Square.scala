package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object Square {

  case class Props(number: String, onClick: Callback)

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