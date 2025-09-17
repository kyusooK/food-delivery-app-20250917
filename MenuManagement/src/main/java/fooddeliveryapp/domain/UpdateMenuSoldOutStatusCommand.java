package fooddeliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateMenuSoldOutStatusCommand {

    private Long menuId;
    private Boolean newSoldOutStatus;
    private String changedBy;
}
