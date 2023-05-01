package com.exam.service;

import java.util.List;

import com.exam.dao.RoleDao;
import com.exam.entity.Role;


public interface RoleService {
	public Role addRole(RoleDao roleDao);
	public Role updateRole(RoleDao roleDao,Long roleId);
	public List<Role> getRole();
	public Role getRoleById(Long roleId);
	public void deleteRoleById(Long roleId);
}
