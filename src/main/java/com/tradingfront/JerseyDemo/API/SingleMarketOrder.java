package com.tradingfront.JerseyDemo.API;

import com.tradingfront.JerseyDemo.SettingData;
import com.tradingfront.JerseyDemo.Utils;
import quickfix.field.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dell on 2017/1/11.
 *
 */
@Path("/SingleMarketOrder")
public class SingleMarketOrder {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextSingleMarketOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);

        Utils.singleMarketOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide);

        return "SingleMarketOrder";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLSingleMarketOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);

        Utils.singleMarketOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide);

        return "<?xml version=\"1.0\"?>" + "<hello>SingleMarketOrder" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlSingleMarketOrder() {

        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);

        Utils.singleMarketOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide);


        return "<html> " + "<title>" + "SingleMarketOrder" + "</title>"
                + "<body><h1>" + "Hello SingleMarketOrder" + "</body></h1>" + "</html> ";
    }
}
