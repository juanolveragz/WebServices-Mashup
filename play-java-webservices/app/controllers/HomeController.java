package controllers;

import play.mvc.*;

import views.html.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.json.*;
import java.util.Hashtable;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Servicios Web"));
    }


    /*
* El siguiente método hace una multiplicación de enteros.
* @param a el primer  entero.
* @param b el segundo entero.
* @return Resultado en formato Json.
*/
public  Result getMultiplicacion(int a, int b){
  ObjectNode result = Json.newObject();
  result.put("resultado", a*b );
  return ok(result);
}

/*
* El siguiente método verifica si una cadena es un palíndromo.
* @param word la palabra a validar.
* @return true o false en formato Json.
*/
public Result getPalindromo(String word){
  ObjectNode result = Json.newObject();
  String myWord = word.replaceAll("\\s+","");
  String reverse = new StringBuffer(myWord).reverse().toString();
  result.put("resultado", reverse.equalsIgnoreCase(myWord));
  return ok(result);

}

public Result getConversion(Double a) {
  ObjectNode result  = Json.newObject();
  result.put("resultado", (a*20) );
  return ok(result);
}

public Result getCelsius(Double a) {
  ObjectNode result  = Json.newObject();
  result.put("resultado", ((9*a)/5) + 32 );
  return ok(result);
}


public Result getCapital(String capital){

  Hashtable<String, String> paises = new Hashtable<String, String>();

      // De esta forma asocio a una persona con su edad en el diccionario
      paises.put("alemania", "Berlín");
      paises.put("austria", "Vienna");
      paises.put("belgica", "Bruselas");
      paises.put("dinamarca", "Copenhagen");
      paises.put("españa", "Madrid");
      paises.put("finlandia", "Helsinki");
      paises.put("francia", "Paris");

  ObjectNode result = Json.newObject();
  result.put("resultado", paises.get(capital));
  return ok(result);
}

public Result getUbicacion(String ubic){

  Hashtable<String, String> paises = new Hashtable<String, String>();

      // De esta forma asocio a una persona con su edad en el diccionario
      paises.put("Alemania", "52.5077843,13.3517587");
      paises.put("Austria", "48.1998585,16.3700744");
      paises.put("Belgica", "50.8083158,4.3849209");
      paises.put("Dinamarca", "55.6864627,12.5918263");
      paises.put("españa", "40.4160947,-3.6973632");
      paises.put("finlandia", "60.1685662,24.9351516");
      paises.put("francia", "48.8648275,2.292344");

  ObjectNode result = Json.newObject();
  result.put("resultado", paises.get(ubic));
  return ok(result);
}

}
