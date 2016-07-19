package br.estacio.posgraduacao.frameworks.ejb;

import java.util.List;

import javax.ejb.Remote;

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
	
	public void atualizarPedidos(StatusPedido[] resultados);
}