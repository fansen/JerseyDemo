package com.tradingfront.JerseyDemo;

import quickfix.*;
import quickfix.field.*;
import quickfix.fix42.NewOrderSingle;

import java.util.Date;

/**
 * Created by dell on 2017/1/9.
 *
 */
public class Utils {

    public static void logon(String filePath) {
        try {
            SessionSettings settings = new SessionSettings(filePath);
            TFApplication application = new TFApplication();
            MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
            LogFactory logFactory = new ScreenLogFactory(true, true, true);
            MessageFactory messageFactory = new DefaultMessageFactory();

            Initiator initiator = new SocketInitiator(application, messageStoreFactory, settings, logFactory, messageFactory);
            initiator.start();
        } catch (ConfigError configError) {
            configError.printStackTrace();
        }
    }

    public static void logout() {
        System.out.println("Logout sessionID = " + SettingData.sessionID);
        if (SettingData.sessionID != null) {
            Session.lookupSession(SettingData.sessionID).logout("user requested");
        } else {
            System.out.println("sessionID is NULL!");
        }
    }

    public static void placeOrder() {
        if (SettingData.sessionID == null)
            SettingData.sessionID = new SessionID("FIX.4.2", "BANZAI", "FIXIMULATOR");

        final String orderId = "342";
        NewOrderSingle newOrder = new NewOrderSingle(new ClOrdID(orderId), new HandlInst('1'), new Symbol("IBM"),
                new Side(Side.BUY), new TransactTime(new Date()), new OrdType(OrdType.MARKET));
        Account account = new Account(SettingData.masterAccount);
        newOrder.set(account);
        newOrder.set(new OrderQty(300));
        try {
            Session.sendToTarget(newOrder, SettingData.sessionID);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }

    public static void singleMarketOrder(ClOrdID clOrdID, Account account, OrderQty orderQty, HandlInst orderHandlInst,
                                        Symbol orderSymbol, Side orderSide) {
        if (SettingData.sessionID == null)
            SettingData.sessionID = new SessionID("FIX.4.2", "BANZAI", "FIXIMULATOR");

        NewOrderSingle newOrderSingle = new NewOrderSingle(clOrdID, orderHandlInst, orderSymbol, orderSide,
                new TransactTime(new Date()), new OrdType(OrdType.MARKET));
        newOrderSingle.set(account);
        newOrderSingle.set(orderQty);

        try {
            Session.sendToTarget(newOrderSingle, SettingData.sessionID);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }

    public static void singleLimitOrder(ClOrdID clOrdID, Account account, OrderQty orderQty, HandlInst orderHandlInst,
                                         Symbol orderSymbol, Side orderSide, Price limitPrice) {
        if (SettingData.sessionID == null)
            SettingData.sessionID = new SessionID("FIX.4.2", "BANZAI", "FIXIMULATOR");

        NewOrderSingle newOrderSingle = new NewOrderSingle(clOrdID, orderHandlInst, orderSymbol, orderSide,
                new TransactTime(new Date()), new OrdType(OrdType.LIMIT));
        newOrderSingle.set(account);
        newOrderSingle.set(orderQty);
        newOrderSingle.set(limitPrice);

        try {
            Session.sendToTarget(newOrderSingle, SettingData.sessionID);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }

    public static void singleStopOrder(ClOrdID clOrdID, Account account, OrderQty orderQty, HandlInst orderHandlInst,
                                       Symbol orderSymbol, Side orderSide, StopPx stopPx) {
        if (SettingData.sessionID == null)
            SettingData.sessionID = new SessionID("FIX.4.2", "BANZAI", "FIXIMULATOR");

        NewOrderSingle newOrderSingle = new NewOrderSingle(clOrdID, orderHandlInst, orderSymbol, orderSide,
                new TransactTime(new Date()), new OrdType(OrdType.STOP));
        newOrderSingle.set(account);
        newOrderSingle.set(orderQty);
        newOrderSingle.set(stopPx);

        try {
            Session.sendToTarget(newOrderSingle, SettingData.sessionID);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }

    public static void singleStopLimitOrder(ClOrdID clOrdID, Account account, OrderQty orderQty, HandlInst orderHandlInst,
                                            Symbol orderSymbol, Side orderSide, StopPx stopPx, Price limitPrice) {
        if (SettingData.sessionID == null)
            SettingData.sessionID = new SessionID("FIX.4.2", "BANZAI", "FIXIMULATOR");

        NewOrderSingle newOrderSingle = new NewOrderSingle(clOrdID, orderHandlInst, orderSymbol, orderSide,
                new TransactTime(new Date()), new OrdType(OrdType.STOP_LIMIT));
        newOrderSingle.set(account);
        newOrderSingle.set(orderQty);
        newOrderSingle.set(stopPx);
        newOrderSingle.set(limitPrice);

        try {
            Session.sendToTarget(newOrderSingle, SettingData.sessionID);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }

    public static void VWAPGuaranteedOrder(ClOrdID clOrdID, Account account, OrderQty orderQty, HandlInst orderHandlInst,
                                           Symbol orderSymbol, Side orderSide, EffectiveTime effectiveTime) {

        // Set tag 40 (OrdType) to P (pegged)
        NewOrderSingle newOrderSingle = new NewOrderSingle(clOrdID, orderHandlInst, orderSymbol, orderSide,
                new TransactTime(new Date()), new OrdType(OrdType.PEGGED));
        newOrderSingle.set(account);
        newOrderSingle.set(orderQty);
        newOrderSingle.set(new TimeInForce(TimeInForce.DAY));
        // Set tag 100 (ExDestination) to VWAP
        newOrderSingle.set(new ExDestination("VWAP"));
        // Set tag 18 (ExecInst) to W (peg to VWAP)
        newOrderSingle.set(new ExecInst(String.valueOf(ExecInst.PEG_TO_VWAP)));
        newOrderSingle.set(new OpenClose(OpenClose.OPEN));
        newOrderSingle.set(new SecurityType(SecurityType.COMMON_STOCK));
        newOrderSingle.set(new Rule80A(Rule80A.AGENCY_SINGLE_ORDER));
        newOrderSingle.set(effectiveTime);
//        new PossDupFlag(PossDupFlag.ORIGINAL_TRANSMISSION);
//        new OrigSendingTime(new Date());

        try {
            Session.sendToTarget(newOrderSingle, SettingData.sessionID);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }

    public static void VWAPNonGuaranteedOrder(ClOrdID clOrdID, Account account, OrderQty orderQty, HandlInst orderHandlInst,
                                           Symbol orderSymbol, Side orderSide, EffectiveTime effectiveTime, Price VWAPPrice,
                                              CustomerOrFirm customerOrFirm, HandlInst handlInst, Currency currency) {

        // Set tag 40 (OrdType) to P (pegged)
        NewOrderSingle newOrderSingle = new NewOrderSingle(clOrdID, orderHandlInst, orderSymbol, orderSide,
                new TransactTime(new Date()), new OrdType(OrdType.LIMIT));
        newOrderSingle.set(account);
        newOrderSingle.set(orderQty);
        newOrderSingle.set(new TimeInForce(TimeInForce.DAY));
        // Set tag 100 (ExDestination) to SMART
        newOrderSingle.set(new ExDestination("SMART"));
        // Set tag 18 (ExecInst) to E
        newOrderSingle.set(new ExecInst(String.valueOf(ExecInst.DO_NOT_INCREASE)));
        newOrderSingle.set(new OpenClose(OpenClose.OPEN));
        newOrderSingle.set(new SecurityType(SecurityType.COMMON_STOCK));
        newOrderSingle.set(effectiveTime);

        try {
            Session.sendToTarget(newOrderSingle, SettingData.sessionID);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }



}
