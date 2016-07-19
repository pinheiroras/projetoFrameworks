package br.estacio.posgraduacao.frameworks.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;
  private Double valor;
  private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

  public Produto() {

  }

  public Produto(Integer id, String nome, Double valor, List<Fornecedor> fornecedores) {
    super();
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    this.fornecedores = fornecedores;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }
  
  public List<Fornecedor> getFornecedores() {
    return fornecedores;
  }

  public void setFornecedores(List<Fornecedor> fornecedores) {
    this.fornecedores = fornecedores;
  }

}
