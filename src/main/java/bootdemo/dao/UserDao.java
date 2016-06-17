package bootdemo.dao;

import bootdemo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by trq on 2016/6/16.
 */
@Transactional
public interface UserDao extends CrudRepository<User, String> {
}
