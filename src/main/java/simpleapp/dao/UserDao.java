package simpleapp.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import simpleapp.domain.User;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserDao  extends PagingAndSortingRepository<User,Long> {

    List<User> findByUsername(@Param("username") String username);

}
