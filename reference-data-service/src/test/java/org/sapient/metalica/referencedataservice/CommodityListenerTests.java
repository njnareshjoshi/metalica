package org.sapient.metalica.referencedataservice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.sapient.metalica.referencedataservice.constant.Constants.COMMODITY_DATA_QUEUE;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommodityListenerTests {

    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    public void testGetCommodity() {
        System.out.println(rabbitTemplate.convertSendAndReceive(COMMODITY_DATA_QUEUE, "AL"));
    }

    @Test
    public void testGetCommodities() {
        System.out.println(rabbitTemplate.convertSendAndReceive(COMMODITY_DATA_QUEUE, (Object) null));
    }

}
