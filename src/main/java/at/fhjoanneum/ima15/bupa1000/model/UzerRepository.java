package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UzerRepository extends PagingAndSortingRepository<Uzer,Long> {

    Uzer findByUsername(@Param("username") String username);





}
