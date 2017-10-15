package com.github.jw3.mvf

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import scala.concurrent.Future


trait HttpInterface {
  def routes: Route =
    get {path("_ping") {complete("ok")}}
}

object HttpInterface extends HttpInterface {
  def bind(host: String, port: Int)(implicit system: ActorSystem, mat: ActorMaterializer): Future[ServerBinding] = Http().bindAndHandle(routes, host, port)
}
