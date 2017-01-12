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

/**
 * Created by dell on 2017/1/11.
 *
 */
@Path("/VWAPNonGuaranteedOrder")
public class VWAPNonGuaranteedOrder {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextVWAPNonGuaranteedOrder() {
        ClOrdID clOrdID = new ClOrdID("a002");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(100);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("IBM");
        Side orderSide = new Side(Side.BUY);
        Price VWAPPrice = new Price(1.80);
        CustomerOrFirm customerOrFirm = new CustomerOrFirm(0);
        HandlInst handlInst = new HandlInst(HandlInst.AUTOMATED_EXECUTION_ORDER_PUBLIC);
        Currency currency = new Currency("USD");

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

        Utils.VWAPNonGuaranteedOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, effectiveTime,
                VWAPPrice, customerOrFirm, handlInst, currency);

        return "VWAPNonGuaranteedOrder";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLVWAPNonGuaranteedOrder() {
        ClOrdID clOrdID = new ClOrdID("a002");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(100);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("IBM");
        Side orderSide = new Side(Side.BUY);
        Price VWAPPrice = new Price(1.80);
        CustomerOrFirm customerOrFirm = new CustomerOrFirm(0);
        HandlInst handlInst = new HandlInst(HandlInst.AUTOMATED_EXECUTION_ORDER_PUBLIC);
        Currency currency = new Currency("USD");

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

        Utils.VWAPNonGuaranteedOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, effectiveTime,
                VWAPPrice, customerOrFirm, handlInst, currency);

        return "<?xml version=\"1.0\"?>" + "<hello>VWAPNonGuaranteedOrder" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlVWAPNonGuaranteedOrder() {

        ClOrdID clOrdID = new ClOrdID("a002");
        Account account = new Account(SettingData.masterAccount);
        OrderQty orderQty = new OrderQty(100);
        HandlInst orderHandlInst = new HandlInst('1');
        Symbol orderSymbol = new Symbol("IBM");
        Side orderSide = new Side(Side.BUY);
        Price VWAPPrice = new Price(1.80);
        CustomerOrFirm customerOrFirm = new CustomerOrFirm(0);
        HandlInst handlInst = new HandlInst(HandlInst.AUTOMATED_EXECUTION_ORDER_PUBLIC);
        Currency currency = new Currency("USD");


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

        Utils.VWAPNonGuaranteedOrder(clOrdID, account, orderQty, orderHandlInst, orderSymbol, orderSide, effectiveTime,
                VWAPPrice, customerOrFirm, handlInst, currency);

        return "<html> " + "<title>" + "VWAPNonGuaranteedOrder" + "</title>"
                + "<body><h1>" + "Hello VWAPNonGuaranteedOrder" + "</body></h1>" + "</html> ";
    }
}
