package com.yvan.practice.test.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yvan on 2016/12/17.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

    public Map<String, String> data;

    protected WarehouseImpl() throws RemoteException {
        data = new HashMap<>();
        data.put("info", "get info successful...");

    }

    @Override
    public String getInfo(String description) throws RemoteException {
        String result = data.get(description);
        return result == null ? "" : result;
    }

}
