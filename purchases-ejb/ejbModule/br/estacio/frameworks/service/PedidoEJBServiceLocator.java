/**
 * PedidoEJBServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.estacio.frameworks.service;

import org.apache.axis.client.Service;

public class PedidoEJBServiceLocator extends Service implements br.estacio.frameworks.service.PedidoEJBService {

    public PedidoEJBServiceLocator() {
    }


    public PedidoEJBServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PedidoEJBServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PedidoEJBPort
    private java.lang.String PedidoEJBPort_address = "http://localhost:8080/provider-ejb/PedidoEJB";

    public java.lang.String getPedidoEJBPortAddress() {
        return PedidoEJBPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PedidoEJBPortWSDDServiceName = "PedidoEJBPort";

    public java.lang.String getPedidoEJBPortWSDDServiceName() {
        return PedidoEJBPortWSDDServiceName;
    }

    public void setPedidoEJBPortWSDDServiceName(java.lang.String name) {
        PedidoEJBPortWSDDServiceName = name;
    }

    public br.estacio.frameworks.service.PedidoEJB getPedidoEJBPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PedidoEJBPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPedidoEJBPort(endpoint);
    }

    public br.estacio.frameworks.service.PedidoEJB getPedidoEJBPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.estacio.frameworks.service.PedidoEJBServiceSoapBindingStub _stub = new br.estacio.frameworks.service.PedidoEJBServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPedidoEJBPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPedidoEJBPortEndpointAddress(java.lang.String address) {
        PedidoEJBPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.estacio.frameworks.service.PedidoEJB.class.isAssignableFrom(serviceEndpointInterface)) {
                br.estacio.frameworks.service.PedidoEJBServiceSoapBindingStub _stub = new br.estacio.frameworks.service.PedidoEJBServiceSoapBindingStub(new java.net.URL(PedidoEJBPort_address), this);
                _stub.setPortName(getPedidoEJBPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PedidoEJBPort".equals(inputPortName)) {
            return getPedidoEJBPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.frameworks.estacio.br/", "PedidoEJBService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.frameworks.estacio.br/", "PedidoEJBPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PedidoEJBPort".equals(portName)) {
            setPedidoEJBPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
