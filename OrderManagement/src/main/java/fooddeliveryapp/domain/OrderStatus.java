package fooddeliveryapp.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum OrderStatus {
    PLACED,
    CANCELLED,
    RECEIVED,
    COOKING,
    COOKED,
    DELIVERY_WAITING,
    COMPLETED,
}
