package xyz.hyperreal.spraytemplate

import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.json._
import DefaultJsonProtocol._
import spray.httpx.SprayJsonSupport
import MediaTypes._
import scala.collection.mutable.ArrayBuffer

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

// 	case class Todo( id: Int, text: String, done: Boolean )
// 
// 	object TodoJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
// 		implicit val PortofolioFormats: RootJsonFormat[Todo] = jsonFormat3(Todo)
// 	}
// 
// 	import TodoJsonSupport._
// 
// 	var todos = ArrayBuffer[Todo]( Todo(1, "first item", false), Todo(2, "second item", false) )
// 	var id = 3
	
  val myRoute =
	pathPrefix("css") {
		getFromResourceDirectory("resources/public")
	} ~
	pathPrefix("js") {
		getFromResourceDirectory("public")
	} ~
	pathSuffixTest( ".*html"r ) { _ =>
		getFromResourceDirectory( "public" )
	} ~
	pathPrefix("coffee") {
		getFromResourceDirectory("public/js")
	} ~
	pathPrefix("webjars") {
		getFromResourceDirectory("META-INF/resources/webjars")
	} ~
    path( "" ) {
		getFromResource( "public/index.html" )
    }
}
