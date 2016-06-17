package bootdemo.user.dao;

import bootdemo.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by trq on 2016/6/16.
 */
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String> {
    User findByName(String name);

    Page<User> findAllBySex(Boolean sex, Pageable pageable);
}
