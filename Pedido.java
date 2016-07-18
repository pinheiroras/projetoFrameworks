package br.estacio.posgraduacao.frameworks.entity;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {

  private static final long serialVersionUID = 1L;

  public static enum Status {
    PENDENTE, PROCESSADO, FINALIZADO, APROVADO
  };

  private Integer id;
  private String descricao;
  private Status status;
  private List<Item> itens;

  public Pedido() {}

  public Pedido(Integer id, String descricao, Status status, List<Item> itens) {
    super();
    this.id = id;
    this.descricao = descricao;
    this.status = status;
    this.itens = itens;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Item> getItens() {
    return itens;
  }

  public void setItens(List<Item> itens) {
    this.itens = itens;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescrição(String descricao) {
    this.descricao = descricao;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

}
