package phone.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phone.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "lostPhones",
    path = "lostPhones"
)
public interface LostPhoneRepository
    extends PagingAndSortingRepository<LostPhone, Long> {}
