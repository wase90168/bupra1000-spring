package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Person_PersonRepository extends PagingAndSortingRepository<Person_Person,Long>{
}
