package phone.domain;

import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

@Data
@ToString
public class LostReportRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String lostStatus;
    private String imeiStatus;
    private String lockStatus;
    private Long phoneId;
    private Boolean cancel;
}
