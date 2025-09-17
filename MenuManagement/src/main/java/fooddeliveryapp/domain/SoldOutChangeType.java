package fooddeliveryapp.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum SoldOutChangeType {
    MARKED_SOLD_OUT,
    MARKED_AVAILABLE,
}
