package br.estacio.purchaces.bean;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.estacio.purchaces.ejb.CarrinhoService;
import br.estacio.purchaces.entity.Item;
import br.estacio.purchaces.entity.Produto;

@ManagedBean
@SessionScoped
public class CompraBean {

	private int quantidade;
	private Integer idProdutoSelecionado;
	private Produto produtoSelecionado;
	
	@EJB
	private CarrinhoService carrinho;
	
	
	public CompraBean() {
		quantidade = 0;
	}
	
	public List<Produto> getProdutos() {
		List<Produto> produtos = carrinho.buscarProdutos();
		return produtos;
	}
	
	public List<Item> getItensAdcionados(){
		return carrinho.getItensAdicionados();
	}
	
	public void adicionarLista(int quantidade){
		carrinho.addItem(idProdutoSelecionado, quantidade);
	}
	
	public void finalizarCompra(){
		carrinho.finalizarCompra();
	}
	
	public float precoTotal(){
		float preco = 0.0f;
		List<Item> itens = getItensAdcionados();
		for(Item i : itens){
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

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Integer getIdProdutoSelecionado() {
		return idProdutoSelecionado;
	}

	public void setIdProdutoSelecionado(Integer idProdutoSelecionado) {
		this.idProdutoSelecionado = idProdutoSelecionado;
	}
	
	
}
