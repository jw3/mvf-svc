package com.github.jw3.mvf.api

import julienrf.json.derived
import play.api.libs.json.Format


sealed trait Command
object Command {
  implicit val format: Format[Command] = derived.oformat()
}

case class UpdatePosition() extends Command
case class AddWatch() extends Command
