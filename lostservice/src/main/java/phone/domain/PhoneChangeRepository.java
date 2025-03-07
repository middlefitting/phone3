package phone.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phone.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "phoneChanges",
    path = "phoneChanges"
)
public interface PhoneChangeRepository
    extends PagingAndSortingRepository<PhoneChange, Long> {}
