package fooddeliveryapp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.MenuManagementApplication;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MenuSoldOutHistory_table")
@Data
//<<< DDD / Aggregate Root
public class MenuSoldOutHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    private MenuId menuId;

    private String changedBy;

    private Boolean previousSoldOutStatus;

    private Boolean newSoldOutStatus;

    private SoldOutChangeType changeType;

    private Date changedAt;

    public static MenuSoldOutHistoryRepository repository() {
        MenuSoldOutHistoryRepository menuSoldOutHistoryRepository = MenuManagementApplication.applicationContext.getBean(
            MenuSoldOutHistoryRepository.class
        );
        return menuSoldOutHistoryRepository;
    }

    //<<< Clean Arch / Port Method
    public void createMenuSoldOutHistory(
        CreateMenuSoldOutHistoryCommand createMenuSoldOutHistoryCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
