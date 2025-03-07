package phone.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phone.domain.*;

@Component
public class PhoneChangeHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PhoneChange>> {

    @Override
    public EntityModel<PhoneChange> process(EntityModel<PhoneChange> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/phonechangeaccess"
                )
                .withRel("phonechangeaccess")
        );

        return model;
    }
}
