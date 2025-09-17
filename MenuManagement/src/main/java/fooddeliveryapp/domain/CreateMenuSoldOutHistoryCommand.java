package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateMenuSoldOutHistoryCommand {

    private Long menuId;
    private String changedBy;
    private Boolean previousSoldOutStatus;
    private Boolean newSoldOutStatus;
    private SoldOutChangeType changeType;
    private Date changedAt;
}
