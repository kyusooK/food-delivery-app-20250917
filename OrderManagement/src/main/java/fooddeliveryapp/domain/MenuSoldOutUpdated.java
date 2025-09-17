package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class MenuSoldOutUpdated extends AbstractEvent {

    private Long menuId;
    private Boolean previousSoldOutStatus;
    private Boolean newSoldOutStatus;
    private Boolean isOrderable;
    private String changedBy;
    private Date changedAt;
}
