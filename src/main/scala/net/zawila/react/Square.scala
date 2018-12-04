package net.zawila.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.extra._
import org.scalajs.dom

object Square {

  case class Props(number: String)
  case class State(number: String)



  final class Backend($: BackendScope[Props, State]) {

    def click = {
      println("pressed X")
      $.props.flatMap(item => $.modState(_.copy("X")))

    }

    def render(p: Props, s: State): VdomElement =
      <.button(
        ^.className := "Square",
        ^.onClick --> click,
        s.number)
  }

  val Component = ScalaComponent.builder[Props]("Square")
    .initialStateFromProps(p => State(p.number))
    .renderBackend[Backend]
    .build

  def apply(s:Int) = Component(Props(s.toString))
}