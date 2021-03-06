package io.jianxun.extend.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jianxun.extend.domain.business.PermissionDef;
import io.jianxun.extend.domain.business.Role;
import io.jianxun.extend.service.AbstractBaseService;

@Service
public class RoleService extends AbstractBaseService<Role> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String SUPER_ROLE_NAME = "系统管理员角色";

	/**
	 * 创建所有权限角色
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	public Role createSuperRole() {
		Role role;
		if (this.repository.count() == 0) {
			role = new Role();
			role.setName(SUPER_ROLE_NAME);
			role.setPermissions(PermissionDef.getPermissionCodeList());
			return this.save(role);
		}
		return this.repository.findActiveOne(1L);

	}

	public boolean validateNameUnique(String name, Long id) {
		return 0 == countActiveAll(RolePredicates.nameAndIdNotPredicate(name, id));
	}

}
