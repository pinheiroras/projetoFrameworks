package br.estacio.purchaces.ejb;

import javax.ejb.Remote;

import br.estacio.purchaces.entity.Pedido;

@Remote
public interface MessagerService {

	void enviarPedido(Pedido pedido);

}