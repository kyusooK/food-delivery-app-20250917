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
@Table(name = "Menu_table")
@Data
//<<< DDD / Aggregate Root
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;

    private MenuSpecification specification;

    private MenuStatus status;

    private Boolean isSoldOut;

    private Boolean isOrderable;

    private Date createdAt;

    private Date updatedAt;

    public static MenuRepository repository() {
        MenuRepository menuRepository = MenuManagementApplication.applicationContext.getBean(
            MenuRepository.class
        );
        return menuRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateMenuSoldOutStatus(
        UpdateMenuSoldOutStatusCommand updateMenuSoldOutStatusCommand
    ) {
        //implement business logic here:

        MenuSoldOutUpdated menuSoldOutUpdated = new MenuSoldOutUpdated(this);
        menuSoldOutUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
