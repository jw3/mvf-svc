package com.github.jw3.mvf.api

import julienrf.json.derived
import play.api.libs.json.Format


sealed trait Entity
object Entity {
  implicit val format: Format[Entity] = derived.oformat()
}

case class Vehicle() extends Entity
case class Area() extends Entity
