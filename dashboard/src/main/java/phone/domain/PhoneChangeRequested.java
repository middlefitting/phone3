package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phone.infra.AbstractEvent;

@Data
public class PhoneChangeRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lostPhoneId;
    private String status;
}
