package br.estacio.purchaces.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.estacio.frameworks.service.StatusPedidoResult;
import br.estacio.purchaces.entity.Item;
import br.estacio.purchaces.entity.Pedido;
import br.estacio.purchaces.entity.Produto;

@Stateless
public class CompraDAO implements CompraService{
	
	@PersistenceContext(unitName="trabalho-pu")
	private EntityManager em;
	
	@EJB
	private MessagerService messagerService;

	@Override
	public void adicionarItem(Item item) {
		
	}

	@Override
	public Double getTotal() {
		return null;
	}

	@Override
	public List<Produto> getProdutos() {
		String query = "SELECT p FROM Produto p";
		List<Produto> produtos = em.createQuery(query).getResultList();
		return produtos;
		
	}
	
	public Pedido SalvarPedido(Pedido pedido){
		
		for(Item i : pedido.getItens()){
			i.setPedido(pedido);
		}
		em.persist(pedido);
		messagerService.enviarPedido(pedido);
		return pedido;
	}
	
	public void salvarItensPedido(Item item){
		em.persist(item);
	}

	@Override
	public List<Item> getItens() {
		return null;
	}

	@Override
	public Produto getProduto(Integer id) {
		return em.find(Produto.class, id);
	}

	@Override
	public Pedido[] getPedidosNaoFinalizados() {
		String query = "SELECT p FROM Pedido p WHERE p.status <> 'FINALIZADO'";
		List<Pedido> pedidosList = em.createQuery(query).getResultList();
		Pedido[] pedidos = new Pedido[pedidosList.size()];
		return pedidosList.toArray(pedidos);
	}

	@Override
	public void atualizarPedidos(StatusPedidoResult[] resultados) {
		Pedido pedido;
		for(StatusPedidoResult r : resultados){
			pedido = em.find(Pedido.class, r.getId());
			pedido.setStatus(Pedido.Status.valueOf(r.getStatus()));
		}
	}
	

}
