package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(excerptProjection = InlineValue.class)
public interface ValueRepository extends PagingAndSortingRepository<Value,Long> {
    List<Value> findAllBy();

    //void save(@Param("value")BigDecimal value, @Param("state") State state, @Param("person") Person person, @Param("mr") MR mr, @Param("source") Source source, @Param("dimension") Dimension dimension);

    Value findById(Long id);

    @Override
    void deleteAll();


    @Override
    Page<Value> findAll(Pageable pageable);

    List<Value> findValuesByPerson_PrefixAndPerson_Suffix(@Param("prefix") String prefix,@Param("suffix") String suffix);

    List<Value> findAllByOrderByIdDesc();



    //@Query(query)
    //List<Value> findByQuery(@Param("query") String query);


}
