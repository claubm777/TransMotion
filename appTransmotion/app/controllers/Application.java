package controllers;

import models.Dijkstra;
import play.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.db.ebean.Model;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.libs.Json;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Transmotion."));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result darCostosRutas()  {
        List<Double> resp=new ArrayList<Double>();
        JsonNode j = Controller.request().body().asJson();
        System.out.println(j.asText());
        Double latitud = Double.parseDouble(j.findPath("latitud").asText());
        Double longitud = Double.parseDouble(j.findPath("longitud").asText());
        String nombreEstacionDestino = j.findPath("nombreEstacionDestino").asText();
        String nombreEstacionOrigen = j.findPath("nombreEstacionOrigen").asText();
        System.out.println("---------------------------ninicial   "+nombreEstacionOrigen+"------------nfinal   "+nombreEstacionDestino);
        Dijkstra d=new Dijkstra();
        Double congestion =d.dijkstraCongestionDist(nombreEstacionOrigen,nombreEstacionDestino);
        Double tiempo =d.dijkstraTiempoDist(nombreEstacionOrigen, nombreEstacionDestino);
        resp.add(congestion);
        resp.add(tiempo);
            return ok(Json.toJson(resp));
        }
    @BodyParser.Of(BodyParser.Json.class)
    public static Result darRutaCongestion()  {

        JsonNode j = Controller.request().body().asJson();
        System.out.println(j.asText());
        Double latitud = Double.parseDouble(j.findPath("latitud").asText());
        Double longitud = Double.parseDouble(j.findPath("longitud").asText());
        String nombreEstacionDestino = j.findPath("nombreEstacionDestino").asText();
        String nombreEstacionOrigen = j.findPath("nombreEstacionOrigen").asText();
        System.out.println("---------------------------ninicial   "+nombreEstacionOrigen+"------------nfinal   "+nombreEstacionDestino);
        Dijkstra d=new Dijkstra();
        List<String> congestion =d.dijkstraCongestion(nombreEstacionOrigen, nombreEstacionDestino);

        return ok(Json.toJson(congestion));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result darRutaTiempo()  {

        JsonNode j = Controller.request().body().asJson();
        System.out.println(j.asText());
        Double latitud = Double.parseDouble(j.findPath("latitud").asText());
        Double longitud = Double.parseDouble(j.findPath("longitud").asText());
        String nombreEstacionDestino = j.findPath("nombreEstacionDestino").asText();
        String nombreEstacionOrigen = j.findPath("nombreEstacionOrigen").asText();
        System.out.println("---------------------------ninicial   "+nombreEstacionOrigen+"------------nfinal   "+nombreEstacionDestino);
        Dijkstra d=new Dijkstra();
        List<String> tiempo =d.dijkstraTiempo(nombreEstacionOrigen, nombreEstacionDestino);

        return ok(Json.toJson(tiempo));
    }


}
