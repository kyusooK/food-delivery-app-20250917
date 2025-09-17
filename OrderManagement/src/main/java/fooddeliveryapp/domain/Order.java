package fooddeliveryapp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.OrderManagementApplication;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long customerId;

    private Long restaurantId;

    private Long deliveryRiderId;

    private OrderStatus orderStatus;

    private DeliveryStatus deliveryStatus;

    private PaymentStatus paymentStatus;

    private String paymentId;

    @ElementCollection
    private List<OrderLine> menuItems;

    private Double totalPrice;

    private Date orderCreatedAt;

    private Date orderUpdatedAt;

    private Date orderCancelledAt;

    private String cancelReason;

    private Date cookingStartedAt;

    private Date cookingCompletedAt;

    private Date deliveryAssignedAt;

    private Date deliveryAcceptedAt;

    private Date deliveryRejectedAt;

    private Date foodPickedUpAt;

    private Date foodDeliveredAt;

    private Date deliveryConfirmedAt;

    private String customerAddress;

    private String restaurantAddress;

    private String deliveryAddress;

    private String deliveryTrackingLocation;

    private Boolean reviewAvailable;

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderManagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void createOrder(CreateOrderCommand createOrderCommand) {
        //implement business logic here:

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void pickUpFood(PickUpFoodCommand pickUpFoodCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void startCooking(StartCookingCommand startCookingCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completeCooking(CompleteCookingCommand completeCookingCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void acceptDelivery(AcceptDeliveryCommand acceptDeliveryCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void confirmDelivery(ConfirmDeliveryCommand confirmDeliveryCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deliverFood(DeliverFoodCommand deliverFoodCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void cancelOrder(CancelOrderCommand cancelOrderCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void assignDelivery(AssignDeliveryCommand assignDeliveryCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void receiveOrder(ReceiveOrderCommand receiveOrderCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void rejectDelivery(RejectDeliveryCommand rejectDeliveryCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void propagateMenuSoldOutToOrderManagement(
        MenuSoldOutUpdated menuSoldOutUpdated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderPlaced orderPlaced = new OrderPlaced(order);
        orderPlaced.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(menuSoldOutUpdated.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderPlaced orderPlaced = new OrderPlaced(order);
            orderPlaced.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
