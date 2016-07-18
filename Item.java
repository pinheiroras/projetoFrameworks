package br.estacio.posgraduacao.frameworks.entity;

import java.io.Serializable;

public class Item implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Produto produto;
  private Integer quantidade;
  private Pedido pedido;

  public Item() {

  }

  public Item(Integer id, Produto produto, Integer quantidade, Pedido pedido) {
    this(produto, quantidade);
    this.pedido = pedido;
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

}
