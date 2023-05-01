package com.exam.dao;

public class RoleDao {
private Long roleId; //PK
	
    
	private String roleName;
	
	public RoleDao() {
		
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	


}
