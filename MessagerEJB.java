package br.estacio.posgraduacao.frameworks.ejb;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Stateless
public class MessagerEJB implements MessagerService {
  @Resource(name = "java:/topic/MyTopic")
  private Topic topic;

  @Resource(name = "jms/ConnectionFactory")
  private ConnectionFactory connectionFactory;

  @Override
  public void enviarPedido(Pedido pedido) {
    try {
      JMSContext jmsContext = connectionFactory.createContext();
      final StringBuffer message = new StringBuffer();
      message.append(pedido.getId());
      jmsContext.createProducer().send(topic, message.toString());
      System.out.println("Pedido enviado : " + pedido.getId());
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Ocorreu um erro ao enviar o pedido");
    }
  }
}