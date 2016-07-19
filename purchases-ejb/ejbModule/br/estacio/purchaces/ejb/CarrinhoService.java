package br.estacio.purchaces.ejb;

import java.util.List;

import br.estacio.purchaces.entity.Item;
import br.estacio.purchaces.entity.Produto;

public interface CarrinhoService {
	
	public List<Produto> buscarProdutos();
	
	public void addItem(Integer idProdutoSelecionado, int quantidade);
	
	public List<Item> getItensAdicionados();
	
	public void finalizarCompra();

}
