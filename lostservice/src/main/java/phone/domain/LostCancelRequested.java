package phone.domain;

import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

@Data
@ToString
public class LostCancelRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long phoneId;
    private String lostStatus;
    private String imei;
    private String imeiStatus;
    private String lockStatus;
}
