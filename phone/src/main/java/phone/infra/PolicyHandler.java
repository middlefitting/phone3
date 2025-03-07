package phone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phone.config.kafka.KafkaProcessor;
import phone.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    LostPhoneRepository lostPhoneRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PhoneChangeAccessed'"
    )
    public void wheneverPhoneChangeAccessed_PhoneChange(
        @Payload PhoneChangeAccessed phoneChangeAccessed
    ) {
        PhoneChangeAccessed event = phoneChangeAccessed;
        System.out.println(
            "\n\n##### listener PhoneChange : " + phoneChangeAccessed + "\n\n"
        );

        // Sample Logic //
        Phone.phoneChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PhoneDeleted'"
    )
    public void wheneverPhoneDeleted_PhoneChange(
        @Payload PhoneDeleted phoneDeleted
    ) {
        PhoneDeleted event = phoneDeleted;
        System.out.println(
            "\n\n##### listener PhoneChange : " + phoneDeleted + "\n\n"
        );

        // Sample Logic //
        LostPhone.phoneChange(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
