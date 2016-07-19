package br.estacio.purchaces.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double valor;
	
	@ManyToMany
	@JoinTable(name="produto_fornecedor", 
	joinColumns=@JoinColumn(name="produto_id", 
		 referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="fornecedor_id",
	referencedColumnName="id"))
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	public Produto(){
		
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
	
	
	
}
