package phone.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phone.domain.*;

@Component
public class PhoneHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Phone>> {

    @Override
    public EntityModel<Phone> process(EntityModel<Phone> model) {
        return model;
    }
}
