package com.github.jw3.mvf

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.typesafe.scalalogging.LazyLogging

import scala.util.{Failure, Success}


object Boot extends App with LazyLogging {
  implicit val system: ActorSystem = ActorSystem("mvf")
  implicit val mat: ActorMaterializer = ActorMaterializer()

  import system.dispatcher

  HttpInterface.bind("0.0.0.0", 9000).onComplete {
    case Success(b) ⇒ logger.info("started http")
    case Failure(x) ⇒ logger.error("failed to start http, {}", x.getMessage)
  }
}
