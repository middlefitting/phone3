package phone.domain;

import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

@Data
@ToString
public class PhoneChangeAccessed extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lostPhoneId;
    private String status;
}
