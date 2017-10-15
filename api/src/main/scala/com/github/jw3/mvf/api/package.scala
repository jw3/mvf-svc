package com.github.jw3.mvf

import play.api.libs.json.{Format, Json}
import spray.json.{JsValue, RootJsonFormat, pimpString}


package object api {
  implicit def p2sFormat[T](implicit playFormat: Format[T]): RootJsonFormat[T] = new RootJsonFormat[T] {
    def read(json: spray.json.JsValue): T = play.api.libs.json.Json.parse(json.compactPrint).as[T]
    def write(obj: T): JsValue = pimpString(Json.toJson(obj).toString).parseJson
  }
}
