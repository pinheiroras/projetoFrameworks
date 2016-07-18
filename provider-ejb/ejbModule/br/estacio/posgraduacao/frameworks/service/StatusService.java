package br.estacio.posgraduacao.frameworks.service;

import java.util.List;

public interface StatusService {
  public List<StatusPedido> consultarStatus(Integer[] pedidos);
}
