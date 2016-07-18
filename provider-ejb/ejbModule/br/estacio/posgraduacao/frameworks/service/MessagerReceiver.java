package br.estacio.posgraduacao.frameworks.service;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(mappedName = "java:/topic/MyTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/topic/MyTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MessagerReceiver implements MessageListener {

  @Resource
  private MessageDrivenContext mdc;

  @Override
  public void onMessage(Message messageArg) {
    if (messageArg instanceof TextMessage) {
      TextMessage message = (TextMessage) messageArg;
      try {
        System.out.println("Pedido: " + message.getText() + " Recebido");
      } catch (JMSException e) {
        e.printStackTrace();
      }
    }
  }
}
