package com.tradingfront.JerseyDemo.API;

import com.tradingfront.JerseyDemo.Utils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dell on 2017/1/9.
 *
 */
@Path("/PlaceOrder")
public class PlaceOrder {

    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextPlaceOrder() {
        Utils.placeOrder();
        return "PlaceOrder";
    }

    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLPlaceOrder() {
        Utils.placeOrder();
        return "<?xml version=\"1.0\"?>" + "<hello>PlaceOrder" + "</hello>";
    }

    // This method is called if HTML is request
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlPlaceOrder() {
        Utils.placeOrder();
        return "<html> " + "<title>" + "PlaceOrder" + "</title>"
                + "<body><h1>" + "Hello PlaceOrder" + "</body></h1>" + "</html> ";
    }
}
