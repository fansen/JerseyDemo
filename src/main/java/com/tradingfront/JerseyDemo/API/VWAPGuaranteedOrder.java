package com.tradingfront.JerseyDemo.API;

import com.tradingfront.JerseyDemo.SettingData;
import com.tradingfront.JerseyDemo.Utils;
import quickfix.field.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by dell on 2017/1/11.
 *
 */
@Path("/VWAPGuaranteedOrder")
public class VWAPGuaranteedOrder {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextVWAPGuaranteedOrder() {
        ClOrdID clOrdID = new ClOrdID("6023");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(100);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("IBM");
        Side orderSide = new Side(Side.BUY);

        // get VWAP start time
        String startTime = "2017-01-19";
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EffectiveTime effectiveTime = new EffectiveTime(new Date(date.getTime()));

        Utils.VWAPGuaranteedOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, effectiveTime);

        return "VWAPGuaranteedOrder";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLVWAPGuaranteedOrder() {
        ClOrdID clOrdID = new ClOrdID("6023");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(100);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("IBM");
        Side orderSide = new Side(Side.BUY);

        // get VWAP start time
        String startTime = "2017-01-19";
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EffectiveTime effectiveTime = new EffectiveTime(new Date(date.getTime()));

        Utils.VWAPGuaranteedOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, effectiveTime);

        return "<?xml version=\"1.0\"?>" + "<hello>VWAPGuaranteedOrder" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlVWAPGuaranteedOrder() {

        ClOrdID clOrdID = new ClOrdID("6023");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(100);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("IBM");
        Side orderSide = new Side(Side.BUY);

        // get VWAP start time
        String startTime = "2017-01-19";
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EffectiveTime effectiveTime = new EffectiveTime(new Date(date.getTime()));

        Utils.VWAPGuaranteedOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, effectiveTime);

        return "<html> " + "<title>" + "VWAPGuaranteedOrder" + "</title>"
                + "<body><h1>" + "Hello VWAPGuaranteedOrder" + "</body></h1>" + "</html> ";
    }
}
