package com.github.jw3.mvf.api

import julienrf.json.derived
import play.api.libs.json.Format


sealed trait Event
object Event {
  implicit val format: Format[Event] = derived.oformat()
}

case class Moved() extends Event
case class Entered() extends Event
case class Exited() extends Event
