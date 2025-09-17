package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuSoldOutUpdated extends AbstractEvent {

    private Long menuId;
    private Boolean previousSoldOutStatus;
    private Boolean newSoldOutStatus;
    private Boolean isOrderable;
    private String changedBy;
    private Date changedAt;

    public MenuSoldOutUpdated(Menu aggregate) {
        super(aggregate);
    }

    public MenuSoldOutUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
