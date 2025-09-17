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
// @RequestMapping(value="/menus")
@Transactional
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @RequestMapping(
        value = "/menus/{id}/updatemenusoldoutstatus",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Menu updateMenuSoldOutStatus(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateMenuSoldOutStatusCommand updateMenuSoldOutStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /menu/updateMenuSoldOutStatus  called #####");
        Optional<Menu> optionalMenu = menuRepository.findById(id);

        optionalMenu.orElseThrow(() -> new Exception("No Entity Found"));
        Menu menu = optionalMenu.get();
        menu.updateMenuSoldOutStatus(updateMenuSoldOutStatusCommand);

        menuRepository.save(menu);
        return menu;
    }
}
//>>> Clean Arch / Inbound Adaptor
