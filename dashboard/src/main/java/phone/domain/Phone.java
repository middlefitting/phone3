package phone.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Phone_table")
@Data
public class Phone {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long userId;
    private Long phoneId;
    private Long imei;
    private String lostStatus;
    private String imeiLockStatus;
    private String lockStatus;
    private String phoneChangeStatus;
    private Long lostPhoneId;
}
