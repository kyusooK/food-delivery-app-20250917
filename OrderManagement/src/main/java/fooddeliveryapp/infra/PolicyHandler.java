package fooddeliveryapp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.config.kafka.KafkaProcessor;
import fooddeliveryapp.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuSoldOutUpdated'"
    )
    public void wheneverMenuSoldOutUpdated_PropagateMenuSoldOutToOrderManagement(
        @Payload MenuSoldOutUpdated menuSoldOutUpdated
    ) {
        MenuSoldOutUpdated event = menuSoldOutUpdated;
        System.out.println(
            "\n\n##### listener PropagateMenuSoldOutToOrderManagement : " +
            menuSoldOutUpdated +
            "\n\n"
        );

        // Comments //
        //메뉴 품절 상태가 변경될 때 주문/배달 관리 컨텍스트에 실시간으로 반영하여 고객이 품절 메뉴를 주문하지 못하도록 보장합니다.

        // Sample Logic //
        Order.propagateMenuSoldOutToOrderManagement(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
