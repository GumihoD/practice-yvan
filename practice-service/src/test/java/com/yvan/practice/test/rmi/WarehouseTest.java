package com.yvan.practice.test.rmi;

import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by yvan on 2016/12/17.
 */
public class WarehouseTest {

    @Test
    public void testClient() throws MalformedURLException, RemoteException, AlreadyBoundException, NotBoundException {
        WarehouseClient.warehouseClient();
    }

}