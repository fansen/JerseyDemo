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
@Path("/Logon")
public class Logon {
    @SuppressWarnings("ConstantConditions")
    private String filePath = this.getClass().getClassLoader().getResource("").getPath() + "initiator.cfg";

    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextLogon() {


        if (this.getClass().getClassLoader().getResource("") != null) {
            String path = this.getClass().getClassLoader().getResource("").getPath();
        }

        this.getClass().getClassLoader().getResource("").getPath();

        System.out.printf("ClassPath1: " + filePath);
        Utils.logon(filePath);
        return "Logon";
    }

    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLLogon() {
        System.out.printf("ClassPath1: " + filePath);
        Utils.logon(filePath);
        return "<?xml version=\"1.0\"?>" + "<hello>Logon" + "</hello>";
    }

    // This method is called if HTML is request
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlLogon() {
        System.out.printf("ClassPath1: " + filePath);
        System.out.printf("\n");
        System.out.printf("ClassPath2: " + this.getClass().getResource(""));
        System.out.printf("\n");
        Utils.logon(filePath);

        return "<html> " + "<title>" + "Logon" + "</title>"
                + "<body><h1>" + "Hello Logon" + "</body></h1>" + "</html> ";
    }
}
