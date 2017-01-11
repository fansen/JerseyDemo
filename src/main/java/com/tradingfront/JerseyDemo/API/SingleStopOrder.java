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
@Path("/SingleStopOrder")
public class SingleStopOrder {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextSingleStopOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        StopPx stopPx = new StopPx(32.5);

        Utils.singleStopOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, stopPx);

        return "SingleStopOrder";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLSingleStopOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        StopPx stopPx = new StopPx(32.5);

        Utils.singleStopOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, stopPx);

        return "<?xml version=\"1.0\"?>" + "<hello>SingleStopOrder" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlSingleStopOrder() {

        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        StopPx stopPx = new StopPx(32.5);

        Utils.singleStopOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, stopPx);

        return "<html> " + "<title>" + "SingleStopOrder" + "</title>"
                + "<body><h1>" + "Hello SingleStopOrder" + "</body></h1>" + "</html> ";
    }
}
