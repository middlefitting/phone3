package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phone.infra.AbstractEvent;

@Data
public class PhoneCreated extends AbstractEvent {

    private Long id;
    private String IMEI;
    private Long userId;
}
