package br.estacio.posgraduacao.frameworks.ejb;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class TimerBean {

  private PedidoEJBProxy proxy = new PedidoEJBProxy();

  @EJB
  private CompraService compraService;

  @Schedule(minute = "*/1", hour = "*")
  public void consultarStatus() {

    try {
      Pedido[] pedidos = compraService.getPedidosNaoFinalizados();
      System.out.println("Pedido não finalizados...");
      if (pedidos != null && pedidos.length > 0) {
        int ids[] = new int[pedidos.length];
        for (int i = 0; i < pedidos.length; i++) {
          ids[i] = pedidos[i].getId();
        }
        StatusPedido[] resultados = proxy.consultarStatus(ids);
        compraService.atualizarPedidos(resultados);
        System.out.println("Pedido Atualizado...");
      }
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
