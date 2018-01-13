package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigDecimal;
import java.util.List;

@RepositoryRestResource(excerptProjection = InlineValue.class)
public interface ValueRepository extends PagingAndSortingRepository<Value,Long> {
    List<Value> findAllBy ();

    //void saveValue(@Param("value")BigDecimal value, @Param("state"), @Param("person"), @Param("mr"), @Param("source"), @Param("dimension"))
}
