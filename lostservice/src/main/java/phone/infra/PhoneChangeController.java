package phone.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phone.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/phoneChanges")
@Transactional
public class PhoneChangeController {

    @Autowired
    PhoneChangeRepository phoneChangeRepository;

    @RequestMapping(
        value = "/phoneChanges/{id}/phonechangeaccess",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public PhoneChange phoneChangeAccess(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /phoneChange/phoneChangeAccess  called #####"
        );
        Optional<PhoneChange> optionalPhoneChange = phoneChangeRepository.findById(
            id
        );

        optionalPhoneChange.orElseThrow(() -> new Exception("No Entity Found"));
        PhoneChange phoneChange = optionalPhoneChange.get();
        phoneChange.phoneChangeAccess();

        phoneChangeRepository.save(phoneChange);
        return phoneChange;
    }
}
//>>> Clean Arch / Inbound Adaptor
