package fooddeliveryapp.infra;

import fooddeliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Order>> {

    @Override
    public EntityModel<Order> process(EntityModel<Order> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "createorder")
                .withRel("reateorder")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/pickupfood")
                .withRel("pickupfood")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/startcooking")
                .withRel("startcooking")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/completecooking"
                )
                .withRel("completecooking")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/acceptdelivery")
                .withRel("acceptdelivery")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/confirmdelivery"
                )
                .withRel("confirmdelivery")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deliverfood")
                .withRel("deliverfood")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cancelorder")
                .withRel("cancelorder")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/assigndelivery")
                .withRel("assigndelivery")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/receiveorder")
                .withRel("receiveorder")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/rejectdelivery")
                .withRel("rejectdelivery")
        );

        return model;
    }
}
