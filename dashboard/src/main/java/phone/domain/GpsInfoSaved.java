package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phone.infra.AbstractEvent;

@Data
public class GpsInfoSaved extends AbstractEvent {

    private Long id;
    private Date time;
    private String x;
    private String y;
    private Long phoneId;
}
