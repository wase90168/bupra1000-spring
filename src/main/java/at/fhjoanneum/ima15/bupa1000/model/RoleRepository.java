package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RoleRepository extends PagingAndSortingRepository<Role,Long> {

    List<Role> findAll();

    List<Role> findRoleByName(@Param("name") String name);


}
