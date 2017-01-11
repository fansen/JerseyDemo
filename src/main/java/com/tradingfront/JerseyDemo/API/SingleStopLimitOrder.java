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
@Path("/SingleStopLimitOrder")
public class SingleStopLimitOrder {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextSingleStopLimitOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        StopPx stopPx = new StopPx(35.5);
        Price limitPrice = new Price(32.5);

        Utils.singleStopLimitOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, stopPx, limitPrice);

        return "SingleStopLimitOrder";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLSingleStopLimitOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        StopPx stopPx = new StopPx(35.5);
        Price limitPrice = new Price(32.5);

        Utils.singleStopLimitOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, stopPx, limitPrice);

        return "<?xml version=\"1.0\"?>" + "<hello>SingleStopLimitOrder" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlSingleStopLimitOrder() {

        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        StopPx stopPx = new StopPx(35.5);
        Price limitPrice = new Price(32.5);

        Utils.singleStopLimitOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, stopPx, limitPrice);

        return "<html> " + "<title>" + "SingleStopLimitOrder" + "</title>"
                + "<body><h1>" + "Hello SingleStopLimitOrder" + "</body></h1>" + "</html> ";
    }
}
