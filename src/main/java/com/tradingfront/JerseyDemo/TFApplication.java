package com.tradingfront.JerseyDemo;

import quickfix.*;

/**
 * Created by dell on 2017/1/3.
 */
public class TFApplication implements Application {

    public void onCreate(SessionID sessionID) {
        System.out.println("OnCreate");
    }

    public void onLogon(SessionID sessionID) {
        System.out.println("onLogon sessionID = " + sessionID);
        SettingData.sessionID = sessionID;
    }

    public void onLogout(SessionID sessionID) {
        System.out.println("onLogout");
        SettingData.sessionID = sessionID;
    }

    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("toAdmin");
    }

    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("fromAdmin");
    }

    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("toApp message: " + message);
    }

    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("fromApp");
    }

    public void Hello() {
        System.out.println("Hello!");
    }
}
