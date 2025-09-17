package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/menuSoldOutHistories")
@Transactional
public class MenuSoldOutHistoryController {

    @Autowired
    MenuSoldOutHistoryRepository menuSoldOutHistoryRepository;

    @RequestMapping(
        value = "/menuSoldOutHistoriescreatemenusoldouthistory",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public MenuSoldOutHistory createMenuSoldOutHistory(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateMenuSoldOutHistoryCommand createMenuSoldOutHistoryCommand
    ) throws Exception {
        System.out.println(
            "##### /menuSoldOutHistory/createMenuSoldOutHistory  called #####"
        );
        MenuSoldOutHistory menuSoldOutHistory = new MenuSoldOutHistory();
        menuSoldOutHistory.createMenuSoldOutHistory(
            createMenuSoldOutHistoryCommand
        );
        menuSoldOutHistoryRepository.save(menuSoldOutHistory);
        return menuSoldOutHistory;
    }
}
//>>> Clean Arch / Inbound Adaptor
