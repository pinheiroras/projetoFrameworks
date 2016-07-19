package br.estacio.posgraduacao.frameworks.ejb;

import javax.ejb.Remote;

@Remote
public interface MessagerService {
    void enviarPedido(Pedido pedido);
}