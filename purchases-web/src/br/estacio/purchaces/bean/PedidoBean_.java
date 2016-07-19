package br.estacio.posgraduacao.frameworks.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PedidoBean {
  private Pedido pedido;

  @EJB
  private CompraService compraService;

  public void salvarPedido(List<Item> itensAdicionados) {
    pedido = new Pedido();
    pedido.setStatus(Status.PENDENTE);
    pedido.setItens(itensAdicionados);
    pedido = compraService.SalvarPedido(pedido);
  }

}
