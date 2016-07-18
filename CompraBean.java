package br.estacio.posgraduacao.frameworks.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CompraBean {

  private int quantidade;
  private Integer idProduto;
  private Produto produto;

  @EJB
  private CarrinhoService carrinho;

  public CompraBean() {
    quantidade = 0;
  }

  public List<Produto> getProdutos() {
    List<Produto> produtos = carrinho.buscarProdutos();
    return produtos;
  }

  public List<Item> getItensAdcionados() {
    return carrinho.getItensAdicionados();
  }

  public void adicionarLista(int quantidade) {
    carrinho.addItem(idProduto, quantidade);
  }

  public void finalizarCompra() {
    carrinho.finalizarCompra();
  }

  public float precoTotal() {
    float preco = 0.0f;
    List<Item> itens = getItensAdcionados();
    for (Item i : itens) {
      preco += (i.getProduto().getValor() * i.getQuantidade());
    }
    return preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Integer getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(Integer idProduto) {
    this.idProduto = idProduto;
  }

}