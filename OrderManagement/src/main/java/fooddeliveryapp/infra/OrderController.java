package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "/orderscreateorder",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Order createOrder(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateOrderCommand createOrderCommand
    ) throws Exception {
        System.out.println("##### /order/createOrder  called #####");
        Order order = new Order();
        order.createOrder(createOrderCommand);
        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/pickupfood",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order pickUpFood(
        @PathVariable(value = "id") Long id,
        @RequestBody PickUpFoodCommand pickUpFoodCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/pickUpFood  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.pickUpFood(pickUpFoodCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/startcooking",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order startCooking(
        @PathVariable(value = "id") Long id,
        @RequestBody StartCookingCommand startCookingCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/startCooking  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.startCooking(startCookingCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/completecooking",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order completeCooking(
        @PathVariable(value = "id") Long id,
        @RequestBody CompleteCookingCommand completeCookingCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/completeCooking  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.completeCooking(completeCookingCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/acceptdelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order acceptDelivery(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptDeliveryCommand acceptDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/acceptDelivery  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.acceptDelivery(acceptDeliveryCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/confirmdelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order confirmDelivery(
        @PathVariable(value = "id") Long id,
        @RequestBody ConfirmDeliveryCommand confirmDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/confirmDelivery  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.confirmDelivery(confirmDeliveryCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/deliverfood",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order deliverFood(
        @PathVariable(value = "id") Long id,
        @RequestBody DeliverFoodCommand deliverFoodCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/deliverFood  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.deliverFood(deliverFoodCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/cancelorder",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Order cancelOrder(
        @PathVariable(value = "id") Long id,
        @RequestBody CancelOrderCommand cancelOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/cancelOrder  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.cancelOrder(cancelOrderCommand);

        orderRepository.delete(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/assigndelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order assignDelivery(
        @PathVariable(value = "id") Long id,
        @RequestBody AssignDeliveryCommand assignDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/assignDelivery  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.assignDelivery(assignDeliveryCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/receiveorder",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order receiveOrder(
        @PathVariable(value = "id") Long id,
        @RequestBody ReceiveOrderCommand receiveOrderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/receiveOrder  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.receiveOrder(receiveOrderCommand);

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/orders/{id}/rejectdelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order rejectDelivery(
        @PathVariable(value = "id") Long id,
        @RequestBody RejectDeliveryCommand rejectDeliveryCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/rejectDelivery  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.rejectDelivery(rejectDeliveryCommand);

        orderRepository.save(order);
        return order;
    }
}
//>>> Clean Arch / Inbound Adaptor
