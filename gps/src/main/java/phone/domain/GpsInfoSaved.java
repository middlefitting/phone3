package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class GpsInfoSaved extends AbstractEvent {

    private Long id;
    private Date time;
    private String x;
    private String y;
    private Long phoneId;

    public GpsInfoSaved(Destination aggregate) {
        super(aggregate);
    }

    public GpsInfoSaved() {
        super();
    }
}
//>>> DDD / Domain Event
