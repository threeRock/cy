package io.jianxun.extend.service.business;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.service.AbstractBaseService;

@Service
@Transactional(readOnly = true)
public class UserService extends AbstractBaseService<User> implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User loginUser = this.repository.findActiveOne(UserPredicates.usernamePredicate(username));
		return loginUser;
	}

	public User register(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		final String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		user.setLastPasswordResetDate(new Date());
		return save(user);
	}

	/**
	 * 验证用户名是否重复
	 * 
	 * @param username
	 * @param id
	 * @return
	 */
	public boolean validateUsernameUnique(String username, Long id) {
		Long count = countActiveAll(UserPredicates.usernameAndIdNotPredicate(username, id));
		return count == 0;

	}

}
