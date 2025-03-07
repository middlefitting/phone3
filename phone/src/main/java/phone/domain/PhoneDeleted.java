package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneDeleted extends AbstractEvent {

    private Long id;
    private String imei;
    private Long userId;

    public PhoneDeleted(Phone aggregate) {
        super(aggregate);
    }

    public PhoneDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
