package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReceiveOrderCommand {

    private Long orderId;
}
