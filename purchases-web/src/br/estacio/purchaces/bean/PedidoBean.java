package br.estacio.purchaces.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.estacio.purchaces.ejb.CompraService;
import br.estacio.purchaces.ejb.MessagerEJB;
import br.estacio.purchaces.ejb.MessagerService;
import br.estacio.purchaces.entity.Item;
import br.estacio.purchaces.entity.Pedido;
import br.estacio.purchaces.entity.Pedido.Status;

@ManagedBean
@SessionScoped
public class PedidoBean {
	private Pedido pedido;
	
	@EJB
	private CompraService compraService;
	
	public void salvarPedido(List<Item> itensAdicionados){
		pedido = new Pedido();
		pedido.setStatus(Status.PENDENTE);
		pedido.setItens(itensAdicionados);
		pedido = compraService.SalvarPedido(pedido);
		
	
	}

}
