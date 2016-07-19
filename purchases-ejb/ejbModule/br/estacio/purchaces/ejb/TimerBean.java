package br.estacio.purchaces.ejb;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import br.estacio.frameworks.service.PedidoEJBProxy;
import br.estacio.frameworks.service.StatusPedidoResult;
import br.estacio.purchaces.entity.Pedido;

@Singleton
public class TimerBean {

	private PedidoEJBProxy proxy = new PedidoEJBProxy();
	
	@EJB
	private CompraService compraService;
	
	@Schedule(minute="*/1", hour="*")
	public void consultarStatusTimer(){
		
		try {
			Pedido[] pedidos = compraService.getPedidosNaoFinalizados();
			
			if(pedidos != null && pedidos.length > 0){
				int ids[] = new int[pedidos.length];
				
				for(int i = 0; i<pedidos.length; i++){
					ids[i] = pedidos[i].getId();
				}
				
				StatusPedidoResult[] resultados = proxy.consultarStatus(ids);
				compraService.atualizarPedidos(resultados);
				
				System.out.println("Pedido Alterado");
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		
	}
}
