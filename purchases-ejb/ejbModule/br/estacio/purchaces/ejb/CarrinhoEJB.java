package br.estacio.purchaces.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import br.estacio.purchaces.entity.Item;
import br.estacio.purchaces.entity.Pedido;
import br.estacio.purchaces.entity.Produto;
import br.estacio.purchaces.entity.Pedido.Status;

@Stateful
public class CarrinhoEJB implements CarrinhoService {
	
	private List<Item> itensAdicionados = new ArrayList<Item>();
	
	@EJB
	private CompraService compraService;

	@Override
	public List<Produto> buscarProdutos() {
		return compraService.getProdutos();
	}
	
	@Override
	public List<Item> getItensAdicionados() {
		return itensAdicionados;
	}

	@Override
	public void addItem(Integer idProdutoSelecionado, int quantidade) {
		Produto produtoSelecionado = compraService.getProduto(idProdutoSelecionado);
		Item item = new Item(produtoSelecionado, quantidade);
		itensAdicionados.add(item);
	}
	
	@Override
	public void finalizarCompra() {
		Pedido pedido = new Pedido();
		pedido.setStatus(Status.PENDENTE);
		pedido.setItens(itensAdicionados);
		pedido = compraService.SalvarPedido(pedido);
	}

}
