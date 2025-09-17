package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RejectDeliveryCommand {

    private Long orderId;
    private Long deliveryRiderId;
}
