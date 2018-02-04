/*package cn.cc.mp.wb.common.rabbitmq;

import java.io.IOException;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.amqp.core.Message;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class Receiver {
    
    @RabbitListener(queues = "hello.queue1")
    public void processMessage1(Message message, Channel channel) throws IOException {
        System.out.println(Thread.currentThread().getName() 
                + " 接收到来自hello.queue1队列的消息：" 
                + StringUtils.newStringUtf8(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        return msg.toUpperCase();
    }
    
    @RabbitListener(queues = "hello.queue2")
    public void processMessage2(Message message, Channel channel) throws IOException {
        System.out.println(Thread.currentThread().getName() 
                + " 接收到来自hello.queue2队列的消息：" 
                + StringUtils.newStringUtf8(message.getBody()));
        
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
*/