package com.yvan.practice.test.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by yvan on 2016/12/17.
 */
public interface Warehouse extends Remote {
    String getInfo(String description) throws RemoteException;
}
