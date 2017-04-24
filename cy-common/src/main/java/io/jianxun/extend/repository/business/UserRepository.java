package io.jianxun.extend.repository.business;

import java.util.Optional;

import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.repository.BusinessBaseRepository;

public interface UserRepository extends BusinessBaseRepository<User> {

	Optional<User> findByUsernameAndActive(String username, boolean active);

}
