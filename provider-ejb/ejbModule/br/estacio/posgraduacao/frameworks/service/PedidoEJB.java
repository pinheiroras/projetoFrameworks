package br.estacio.posgraduacao.frameworks.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@Remote(StatusService.class)
@WebService
public class PedidoEJB implements StatusService {

  @WebMethod
  public List<StatusPedido> consultarStatus(Integer[] pedidos) {
    List<StatusPedido> statusPedidos = new ArrayList<>();
    for (Integer pedido : pedidos) {
      statusPedidos.add(new StatusPedido(pedido, statusRandom()));
    }
    return statusPedidos;
  }

  private String statusRandom() {
    String status = "";
    switch ((int) (Math.random() * 4) + 1) {
      case 1:
        status = "PENDENTE";
        break;
      case 2:
        status = "PROCESSADO";
        break;
      case 3:        
        status = "FINALIZADO";
        break;
      case 4:
        status = "APROVADO";        
        break;
      default:
        status = "PENDENTE";
    }
    return status;
  }

}
