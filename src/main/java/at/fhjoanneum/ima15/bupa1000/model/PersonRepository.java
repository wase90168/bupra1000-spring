package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource
public interface PersonRepository extends PagingAndSortingRepository<Person,Long>{

    List<Person> findByPrefix (@Param(value = "prefix") String prefix);

    Person findByPrefixAndSuffix(@Param("prefix") String prefix, @Param("suffix") String suffix);
}
