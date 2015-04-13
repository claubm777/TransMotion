// @SOURCE:C:/Users/Asus/Desktop/appTransmotion/conf/routes
// @HASH:da64ee858c7a75dcc134849ddf29506fdd390fff
// @DATE:Sun Apr 12 18:22:37 COT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_darCostosRutas1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("costos"))))
private[this] lazy val controllers_Application_darCostosRutas1_invoker = createInvoker(
controllers.Application.darCostosRutas(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "darCostosRutas", Nil,"POST", """""", Routes.prefix + """costos"""))
        

// @LINE:8
private[this] lazy val controllers_Application_darRutaCongestion2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ruta/congestion"))))
private[this] lazy val controllers_Application_darRutaCongestion2_invoker = createInvoker(
controllers.Application.darRutaCongestion(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "darRutaCongestion", Nil,"POST", """""", Routes.prefix + """ruta/congestion"""))
        

// @LINE:9
private[this] lazy val controllers_Application_darRutaTiempo3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ruta/tiempo"))))
private[this] lazy val controllers_Application_darRutaTiempo3_invoker = createInvoker(
controllers.Application.darRutaTiempo(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "darRutaTiempo", Nil,"POST", """""", Routes.prefix + """ruta/tiempo"""))
        

// @LINE:15
private[this] lazy val controllers_Assets_at4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """costos""","""controllers.Application.darCostosRutas()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ruta/congestion""","""controllers.Application.darRutaCongestion()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ruta/tiempo""","""controllers.Application.darRutaTiempo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Application_darCostosRutas1_route(params) => {
   call { 
        controllers_Application_darCostosRutas1_invoker.call(controllers.Application.darCostosRutas())
   }
}
        

// @LINE:8
case controllers_Application_darRutaCongestion2_route(params) => {
   call { 
        controllers_Application_darRutaCongestion2_invoker.call(controllers.Application.darRutaCongestion())
   }
}
        

// @LINE:9
case controllers_Application_darRutaTiempo3_route(params) => {
   call { 
        controllers_Application_darRutaTiempo3_invoker.call(controllers.Application.darRutaTiempo())
   }
}
        

// @LINE:15
case controllers_Assets_at4_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     