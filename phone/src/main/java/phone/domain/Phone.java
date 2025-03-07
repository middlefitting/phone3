package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.PhoneApplication;
import phone.domain.PhoneCreated;
import phone.domain.PhoneDeleted;

@Entity
@Table(name = "Phone_table")
@Data
//<<< DDD / Aggregate Root
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imei;

    private Long userId;

    @PostPersist
    public void onPostPersist() {
        PhoneCreated phoneCreated = new PhoneCreated(this);
        phoneCreated.publishAfterCommit();

        PhoneDeleted phoneDeleted = new PhoneDeleted(this);
        phoneDeleted.publishAfterCommit();
    }

    public static PhoneRepository repository() {
        PhoneRepository phoneRepository = PhoneApplication.applicationContext.getBean(
            PhoneRepository.class
        );
        return phoneRepository;
    }

    //<<< Clean Arch / Port Method
    public static void phoneChange(PhoneChangeAccessed phoneChangeAccessed) {
        //implement business logic here:

        /** Example 1:  new item 
        Phone phone = new Phone();
        repository().save(phone);

        PhoneDeleted phoneDeleted = new PhoneDeleted(phone);
        phoneDeleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(phoneChangeAccessed.get???()).ifPresent(phone->{
            
            phone // do something
            repository().save(phone);

            PhoneDeleted phoneDeleted = new PhoneDeleted(phone);
            phoneDeleted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
