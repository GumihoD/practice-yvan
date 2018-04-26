package com.yvan.practice.test.rmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by yvan on 2016/12/17.
 */
public class WarehouseClient {
    private static Logger logger = LoggerFactory.getLogger("WarehouseClient");

    public static void warehouseClient() throws RemoteException, NotBoundException, MalformedURLException {
        String url = "rmi://localhost:1099/central_warehoues";
        Warehouse centralWarehouse = (Warehouse) Naming.lookup(url);
        String result = centralWarehouse.getInfo("info");
        logger.info(result);
    }
}
