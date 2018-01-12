package cn.cc.mp.wb.configurer;
//package cn.cc.mp.wb.common;
//
//import org.apache.commons.codec.binary.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
//import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.rabbitmq.client.Channel;
//
///**
// * 消费者配置
// *
// * @author chenhf
// * @create 2017-10-30 下午3:14
// **/
//@Configuration
//public class ExampleAmqpConfiguration {
//    static Logger logger = LoggerFactory.getLogger(ExampleAmqpConfiguration.class);
//    
//    @Bean("testQueueContainer")
//    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames("hello.queue2", "hello.queue1");
//        container.setMessageListener(exampleListener());
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        return container;
//    }
//
//
//    @Bean("testQueueListener")
//    public ChannelAwareMessageListener exampleListener() {
//        return new ChannelAwareMessageListener() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
////                User testUser = (TestUser) SerializeUtil.unserialize(message.getBody());
//                
//                String s = StringUtils.newStringUtf8(message.getBody());
//                logger.info("s:{}", s);
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//                //通过设置TestUser的name来测试回调，分别发两条消息，一条UserName为1，一条为2，查看控制台中队列中消息是否被消费
////                if ("2".equals(testUser.getUserName())){
////                    System.out.println(testUser.toString());
////                    channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
////                }
////
////                if ("1".equals(testUser.getUserName())){
////                    System.out.println(testUser.toString());
////                    channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
////                }
//            }
//        };
//    }
//
//}
//
