package br.estacio.purchaces.ejb;

import java.util.List;

import javax.ejb.Remote;

import br.estacio.frameworks.service.StatusPedidoResult;
import br.estacio.purchaces.entity.Item;
import br.estacio.purchaces.entity.Pedido;
import br.estacio.purchaces.entity.Produto;

@Remote
public interface CompraService {
	
	public void adicionarItem(Item item);

	public Double getTotal();

	public List<Produto> getProdutos();
	
	public Produto getProduto(Integer id);
	
	public List<Item> getItens();
	
	public Pedido SalvarPedido(Pedido pedido);
	
	public void salvarItensPedido(Item item);
	
	public Pedido[] getPedidosNaoFinalizados();
	
	public void atualizarPedidos(StatusPedidoResult[] resultados);

}
