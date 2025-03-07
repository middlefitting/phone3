package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneCreated extends AbstractEvent {

    private Long id;
    private String imei;
    private Long userId;

    public PhoneCreated(Phone aggregate) {
        super(aggregate);
    }

    public PhoneCreated() {
        super();
    }
}
//>>> DDD / Domain Event
