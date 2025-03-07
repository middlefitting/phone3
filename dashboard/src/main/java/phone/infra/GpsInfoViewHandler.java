package phone.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phone.config.kafka.KafkaProcessor;
import phone.domain.*;

@Service
public class GpsInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private GpsInfoRepository gpsInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenGpsInfoSaved_then_CREATE_1(
        @Payload GpsInfoSaved gpsInfoSaved
    ) {
        try {
            if (!gpsInfoSaved.validate()) return;

            // view 객체 생성
            GpsInfo gpsInfo = new GpsInfo();
            // view 객체에 이벤트의 Value 를 set 함
            gpsInfo.setId(gpsInfoSaved.getId());
            gpsInfo.setTime(gpsInfoSaved.getTime());
            gpsInfo.setX(gpsInfoSaved.getX());
            gpsInfo.setY(gpsInfoSaved.getY());
            gpsInfo.setPhoneId(gpsInfoSaved.getPhoneId());
            // view 레파지 토리에 save
            gpsInfoRepository.save(gpsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
