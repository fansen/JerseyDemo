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
@Path("/SingleLimitOrder")
public class SingleLimitOrder {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextSingleLimitOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        Price limitPrice = new Price(32.5);

        Utils.singleLimitOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, limitPrice);

        return "SingleLimitOrder";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLSingleLimitOrder() {
        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        Price limitPrice = new Price(32.5);

        Utils.singleLimitOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, limitPrice);

        return "<?xml version=\"1.0\"?>" + "<hello>SingleLimitOrder" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlSingleLimitOrder() {

        ClOrdID clOrdID = new ClOrdID("222");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(400);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("VOW");
        Side orderSide = new Side(Side.BUY);
        Price limitPrice = new Price(32.5);

        Utils.singleLimitOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, limitPrice);

        return "<html> " + "<title>" + "SingleLimitOrder" + "</title>"
                + "<body><h1>" + "Hello SingleLimitOrder" + "</body></h1>" + "</html> ";
    }
}
