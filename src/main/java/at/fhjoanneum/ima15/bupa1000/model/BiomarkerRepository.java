package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RepositoryRestResource
public interface BiomarkerRepository extends PagingAndSortingRepository <Biomarker, Long> {

    List<Biomarker> findAllByCategory_Id(@Param("category_id") Long category_id);

}
