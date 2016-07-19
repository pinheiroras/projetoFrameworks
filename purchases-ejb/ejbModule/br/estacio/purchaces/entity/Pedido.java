package br.estacio.purchaces.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable{
	
	public static  enum Status{
		PENDENTE,
		PROCESSANDO,
		PROVADO,
		FINALIZADO
	};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(mappedBy="pedido", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Item> itens;
	
	public Pedido(){}
	
	public Pedido(Integer id, String descricao, List<Item> itens) {
		super();
		this.id = id;
		this.descricao = descricao;
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
