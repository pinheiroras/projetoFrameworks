package br.estacio.frameworks.service;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;

public class PedidoEJBProxy implements PedidoEJB {
  private String _endpoint = null;
  private PedidoEJB pedidoEJB = null;
  
  public PedidoEJBProxy() {
    _initPedidoEJBProxy();
  }
  
  public PedidoEJBProxy(String endpoint) {
    _endpoint = endpoint;
    _initPedidoEJBProxy();
  }
  
  private void _initPedidoEJBProxy() {
    try {
      pedidoEJB = (new PedidoEJBServiceLocator()).getPedidoEJBPort();
      if (pedidoEJB != null) {
        if (_endpoint != null)
          ((Stub)pedidoEJB)._setProperty("service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((Stub)pedidoEJB)._getProperty("service.endpoint.address");
      }
      
    }
    catch (ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pedidoEJB != null)
      ((Stub)pedidoEJB)._setProperty("service.endpoint.address", _endpoint);
    
  }
  
  public PedidoEJB getPedidoEJB() {
    if (pedidoEJB == null)
      _initPedidoEJBProxy();
    return pedidoEJB;
  }
  
  public StatusPedidoResult[] consultarStatus(int[] pedidos) throws RemoteException{
    if (pedidoEJB == null)
      _initPedidoEJBProxy();
    return pedidoEJB.consultarStatus(pedidos);
  }
  
  
}