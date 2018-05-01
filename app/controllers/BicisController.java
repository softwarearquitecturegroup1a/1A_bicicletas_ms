package controllers;

import play.mvc.*;
import play.libs.Json;
import play.Logger;

import com.fasterxml.jackson.databind.JsonNode;

import models.*;
import io.ebean.Model;

import java.util.List;
import java.util.HashMap;
import java.math.BigInteger;

public class BicisController extends Controller {

    // Obtiene todas las bicicletas
    public Result index() {
        Logger.info("getAll");
        List<Bicicleta> bicicletas = Bicicleta.find.all();
        return ok( Json.toJson(bicicletas) );
    }

    // Crea una nueva bicicleta
    public Result create() {
        Logger.info("create");
        Bicicleta bicicleta = new Bicicleta();

        getRequests(bicicleta);

        if(!bicicletaValida(bicicleta))
            return status( 406, Json.toJson(ErrorResponse.NOT_ACCEPTABLE) );

        bicicleta.save();

        return ok(Json.toJson(bicicleta));
    }

    // Obtiene una bicicleta bicicletas segun su serial
    public Result show(Integer serial){
        Logger.info("Show" + serial);
    	Bicicleta bicicleta = Bicicleta.find.byId(serial);

        if(bicicleta == null)
            return notFound( Json.toJson(ErrorResponse.NOT_FOUND) );

        return ok( Json.toJson(bicicleta) );
    }

    // Actualiza la informacion de una bicicleta
	public Result update(Integer serial){
        Logger.info("Update" + serial);
    	Bicicleta bicicleta = Bicicleta.find.byId(serial);

        if(bicicleta == null)
            return notFound( Json.toJson(ErrorResponse.NOT_FOUND) );

        getRequests(bicicleta).update();

        if(!bicicletaValida(bicicleta))
            return status(406, Json.toJson(ErrorResponse.NOT_ACCEPTABLE) );

        return ok(Json.toJson(bicicleta));
    }

    // Elimina una bicicleta
	public Result destroy(Integer serial){
        Logger.info("Destroy" + serial);
        Bicicleta bicicleta = Bicicleta.find.byId(serial);
        bicicleta.find.deleteById(serial);
        return ok(Json.toJson(bicicleta));
    }

    // Peticiones
    private Bicicleta getRequests(Bicicleta bicicleta) {
        JsonNode json = request().body().asJson();

        if(json.has("serial"))
            bicicleta.setSerial( json.findValue("serial").bigIntegerValue() );
        if (json.has("marca"))
            bicicleta.setMarca( json.findValue("marca").textValue() );
        if (json.has("color"))
            bicicleta.setColor( json.findValue("color").textValue() );
        if (json.has("ubicacion"))
            bicicleta.setUbicacion (json.findValue("ubicacion").textValue() );
        if (json.has("estado"))
            bicicleta.setEstado ( json.findValue("estado").textValue() );

        return bicicleta;
    }


    // Realiza validaciones
    private boolean bicicletaValida(Bicicleta bicicleta) {
        if(bicicleta.serial == null || bicicleta.serial.signum() < 1 )
            return false;

        return true;
    }

}
