package br.estacio.posgraduacao.frameworks.ejb;

import java.util.List;

public interface CarrinhoService {

  public List<Produto> buscarProdutos();

  public void addItem(Integer idProdutoSelecionado, int quantidade);

  public List<Item> getItensAdicionados();

  public void finalizarCompra();

}