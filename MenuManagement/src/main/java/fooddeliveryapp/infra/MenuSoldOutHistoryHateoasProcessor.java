package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MenuSoldOutHistoryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<MenuSoldOutHistory>> {

    @Override
    public EntityModel<MenuSoldOutHistory> process(
        EntityModel<MenuSoldOutHistory> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "createmenusoldouthistory"
                )
                .withRel("reatemenusoldouthistory")
        );

        return model;
    }
}
