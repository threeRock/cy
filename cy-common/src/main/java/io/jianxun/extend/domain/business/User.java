package io.jianxun.extend.domain.business;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.collect.Lists;

import io.jianxun.extend.domain.AbstractBusinessEntity;;

/**
 * 系统用户
 * 
 * @author tongtn
 *
 *         createDate: 2017-03-14
 */
@Entity
@Table(name = "jx_sys_user")
public class User extends AbstractBusinessEntity implements UserDetails {

	private static final long serialVersionUID = 585375273427805552L;

	public static final String SUPER_ADMIN_USERNAME = "admin";
	public static final String SUPER_ADMIN_DISPLAYNAME = "系统管理员";
	public static final String SUPER_ADMIN_PASSWORD = "cjye!ypgl-";

	// 登录名称
	@NotBlank(message = "{user.username.notnull}")
	private String username;
	// 密码
	private String password;
	// 显示名称
	private String displayName;
	// 登录令牌
	private String token;
	@ManyToOne
	@JoinColumn(name = "depart_id")
	private Depart depart;

	// 角色信息
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "jx_sys_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序.
	@OrderBy("id")
	private List<Role> roles = Lists.newArrayList();
	
	//所属区域
	private String range;
	
	//客户编号
	private String customCode;

	private Date lastPasswordResetDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.roles.size() == 0)
			return AuthorityUtils.commaSeparatedStringToAuthorityList("");
		StringBuilder commaBuilder = new StringBuilder();
		for (Role role : roles) {
			if (!role.isActive())
				continue;
			List<String> permissions = role.getPermissions();
			if (permissions == null || permissions.size() < 1) {
				continue;
			}
			for (String permission : permissions) {
				commaBuilder.append(permission.toUpperCase()).append(",");
			}
		}
		String authorities = "";
		if (commaBuilder.length() > 1)
			authorities = commaBuilder.substring(0, commaBuilder.length() - 1);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	
	

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
	
	

	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("[用户id:%d,用户名称%s]", this.getId(), this.getUsername());
	}

}
