package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MenuHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Menu>> {

    @Override
    public EntityModel<Menu> process(EntityModel<Menu> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatemenusoldoutstatus"
                )
                .withRel("updatemenusoldoutstatus")
        );

        return model;
    }
}
