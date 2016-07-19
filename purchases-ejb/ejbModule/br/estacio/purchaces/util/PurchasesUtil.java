package br.estacio.purchaces.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PurchasesUtil {
	
	@PersistenceContext(unitName="trabalho-pu")
	private EntityManager em;

}
