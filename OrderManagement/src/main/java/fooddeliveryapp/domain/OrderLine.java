package fooddeliveryapp.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {

    private Long menuId;

    private String menuName;

    private Integer quantity;

    private Double unitPrice;
}
//>>> DDD / Value Object
