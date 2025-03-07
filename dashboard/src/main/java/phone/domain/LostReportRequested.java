package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import phone.infra.AbstractEvent;

@Data
public class LostReportRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private String IMEI;
    private String lostStatus;
    private String IMEIStatus;
    private String lockStatus;
    private Long phoneId;
    private Boolean cancel;
}
