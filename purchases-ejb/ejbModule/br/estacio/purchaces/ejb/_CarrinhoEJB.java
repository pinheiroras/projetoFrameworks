package br.estacio.posgraduacao.frameworks.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoEJB implements CarrinhoService {

  private List<Item> itens = new ArrayList<Item>();

  @EJB
  private CompraService compraService;

  @Override
  public List<Produto> buscarProdutos() {
    return compraService.getProdutos();
  }

  @Override
  public List<Item> getItensAdicionados() {
    return itens;
  }

  @Override
  public void addItem(Integer idProduto, int quantidade) {
    Produto produto = compraService.getProduto(idProduto);
    Item item = new Item(produto, quantidade);
    itens.add(item);
  }

  @Override
  public void finalizarCompra() {
    Pedido pedido = new Pedido();
    pedido.setStatus(Status.PENDENTE);
    pedido.setItens(itens);
    pedido = compraService.SalvarPedido(pedido);
  }

}