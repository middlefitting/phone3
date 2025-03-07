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
    PhoneChangeRepository phoneChangeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostCancelRequested'"
    )
    public void wheneverLostCancelRequested_ReportCancel(
        @Payload LostCancelRequested lostCancelRequested
    ) {
        LostCancelRequested event = lostCancelRequested;
        System.out.println(
            "\n\n##### listener ReportCancel : " + lostCancelRequested + "\n\n"
        );

        // Sample Logic //
        PhoneChange.reportCancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReportRequested'"
    )
    public void wheneverLostReportRequested_PhoneChangeRequest(
        @Payload LostReportRequested lostReportRequested
    ) {
        LostReportRequested event = lostReportRequested;
        System.out.println(
            "\n\n##### listener PhoneChangeRequest : " +
            lostReportRequested +
            "\n\n"
        );

        // Sample Logic //
        PhoneChange.phoneChangeRequest(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
