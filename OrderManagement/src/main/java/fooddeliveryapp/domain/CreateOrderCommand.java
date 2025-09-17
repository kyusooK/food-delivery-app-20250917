package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateOrderCommand {

    private Long customerId;
    private Long restaurantId;
    private List<OrderLine> menuItems;
    private Double totalPrice;
    private String paymentId;
}
