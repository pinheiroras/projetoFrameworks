package br.estacio.posgraduacao.frameworks.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ConexaoUtil {

  @PersistenceContext(unitName = "trabalho-pu")
  private EntityManager em;

}