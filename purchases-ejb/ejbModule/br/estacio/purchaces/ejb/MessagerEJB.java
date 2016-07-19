package br.estacio.purchaces.ejb;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

import br.estacio.purchaces.entity.Pedido;

@Stateless
public class MessagerEJB implements MessagerService {
	@Resource(name="java:/topic/MyTopic")
	private Topic topic;
	
	@Resource(name="jms/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	/* (non-Javadoc)
	 * @see br.estacio.purchaces.ejb.MessagerService#enviarPedido(br.estacio.purchaces.entity.Pedido)
	 */
	@Override
	public void enviarPedido(Pedido pedido){
		Connection connection;
		try {
			
			JMSContext jmsContext = connectionFactory.createContext();
			
			final StringBuffer message = new StringBuffer();
			message.append(pedido.getId());
			
			
			jmsContext.createProducer().send(topic,message.toString());
			
			System.out.println("Pedido " + pedido.getId() + " Enviado");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Pedido não enviado");
		}
	}

}
