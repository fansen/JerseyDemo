package com.tradingfront.JerseyDemo.API;

import com.tradingfront.JerseyDemo.Utils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dell on 2017/1/10.
 *
 */
@Path("/Logout")
public class Logout {

    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextLogout() {
        Utils.logout();
        return "Logout";
    }

    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLLogout() {
        Utils.logout();
        return "<?xml version=\"1.0\"?>" + "<hello>Logout" + "</hello>";
    }

    // This method is called if HTML is request
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlLogout() {
        Utils.logout();

        return "<html> " + "<title>" + "Logout" + "</title>"
                + "<body><h1>" + "Hello Logout" + "</body></h1>" + "</html> ";
    }
}
