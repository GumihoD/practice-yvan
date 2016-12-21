package com.yvan.practice.test.rmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by yvan on 2016/12/17.
 */
public class WarehouseServer {
    private static Logger logger = LoggerFactory.getLogger(WarehouseServer.class);

//    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
//        WarehouseImpl centralWarehouse = new WarehouseImpl();
//        LocateRegistry.createRegistry(1099);
//        Naming.bind("rmi://localhost:1099/central_warehoues", centralWarehouse);
//        logger.info(" RMI Server is Ready");
//    }

}
