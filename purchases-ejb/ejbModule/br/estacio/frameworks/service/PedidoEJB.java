/**
 * PedidoEJB.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.estacio.frameworks.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PedidoEJB extends Remote {
    public StatusPedidoResult[] consultarStatus(int[] arg0) throws RemoteException;
}
