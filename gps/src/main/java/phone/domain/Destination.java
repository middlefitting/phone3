package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.GpsApplication;
import phone.domain.GpsInfoSaved;

@Entity
@Table(name = "Destination_table")
@Data
//<<< DDD / Aggregate Root
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date time;

    private String x;

    private String y;

    private Long phoneId;

    @PostPersist
    public void onPostPersist() {
        GpsInfoSaved gpsInfoSaved = new GpsInfoSaved(this);
        gpsInfoSaved.publishAfterCommit();
    }

    public static DestinationRepository repository() {
        DestinationRepository destinationRepository = GpsApplication.applicationContext.getBean(
            DestinationRepository.class
        );
        return destinationRepository;
    }
}
//>>> DDD / Aggregate Root
