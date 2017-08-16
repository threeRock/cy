package io.jianxun.extend.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;

import io.jianxun.extend.domain.business.Depart;
import io.jianxun.extend.domain.business.Role;
import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.dto.ChangePasswordDto;
import io.jianxun.extend.service.AbstractBaseService;
import io.jianxun.extend.service.BusinessException;

@Service
@Transactional(readOnly = true)
public class UserService extends AbstractBaseService<User> implements UserDetailsService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Autowired
	private RoleService roleService;


	@Transactional(readOnly = false)
	public void changePassword(ChangePasswordDto password) {
		User selected = this.findActiveOne(password.getUserId());
		if (selected == null)
			throw new BusinessException(messageSourceService.getMessage("user.notfound"));
		selected.setPassword(bCryptPasswordEncoder.encode(password.getNewPassword()));
		save(selected);
		return;

	}

	/**
	 * 验证密码是否匹配
	 * 
	 * @param rawPassword
	 *            密码明文
	 * @param encodedPassword
	 *            加密后密码
	 * @return
	 */
	public boolean validateOldePassword(String rawPassword, String encodedPassword) {
		if (StringUtils.isEmpty(encodedPassword)) {
			logger.debug("密码为空,验证失败");
			throw new BusinessException(messageSourceService.getMessage("user.encodedPasswordIsNull"));
		}
		return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
	}

	/**
	 * 修改用户密码
	 * 
	 * @param user
	 * @param newPassword
	 */
	@Transactional(readOnly = false)
	public void changePassword(User user, String newPassword) {
		user.setPassword(bCryptPasswordEncoder.encode(newPassword));
		save(user);

	}

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 */
	@Transactional(readOnly = false)
	public User register(User user) {
		if (user.isNew()) {
			// 密码加密
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			return save(user);
		}
		logger.debug("注册操作失败，用户 {} 已经注册", user);
		throw new BusinessException(
				messageSourceService.getMessage("user.isRegistered", new Object[] { user.getUsername() }));
	}

	/**
	 * 通过登录名加载用户
	 */
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User loginUser = this.repository.findActiveOne(UserPredicates.usernamePredicate(username));
		if(validateIsSuperAdmin(loginUser))
			loginUser.setRoles(Lists.newArrayList(roleService.createSuperRole()));
		if (loginUser == null)
			throw new BusinessException(messageSourceService.getMessage("user.notfound"));
		return loginUser;

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

	/**
	 * 验证用户是否是超级管理员
	 * 
	 * @param id
	 * @param model
	 */
	public boolean validateIsSuperAdmin(User user) {
		if (user != null && user.getId() != null)
			return 1L == user.getId();
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public <S extends User> S save(S user) {
		if (validateIsSuperAdmin(user))
			throw new BusinessException(messageSourceService.getMessage("cannot.modify.superadmin"));
		return super.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public User delete(User user) {
		if (validateIsSuperAdmin(user))
			throw new BusinessException(messageSourceService.getMessage("cannot.modify.superadmin"));
		return super.delete(user);
	}

	@Transactional(readOnly = false)
	public User createAdminIfInit(Depart depart) {
		if (this.repository.findAll().isEmpty())
			return initAdminUser(depart);
		User user = this.repository.findActiveOne(1L);
		user.setRoles(Lists.newArrayList(roleService.createSuperRole()));
		return user;

	}

	private User initAdminUser(Depart root) {
		logger.debug("创建超级管理员用户");
		Role role = roleService.createSuperRole();
		if (role == null)
			throw new BusinessException(messageSourceService.getMessage("user.admininit.error"));
		User user = new User();
		user.setUsername(User.SUPER_ADMIN_USERNAME);
		user.setDisplayName(User.SUPER_ADMIN_DISPLAYNAME);
		user.setPassword(User.SUPER_ADMIN_PASSWORD);
		user.setDepart(root);
		user.setRoles(Lists.newArrayList(role));
		return this.register(user);
	}
}
