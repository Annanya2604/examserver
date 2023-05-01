package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.RoleDao;
import com.exam.dao.StandardDao;
import com.exam.entity.Role;
import com.exam.entity.Standard;
import com.exam.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Role addRole(RoleDao roleDao) {
		// TODO Auto-generated method stub
		Role role=new Role();
		role.setRoleName(roleDao.getRoleName());
		
		return this.roleRepository.save(role);
		

	}

	@Override
	public Role updateRole(RoleDao roleDao, Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return this.roleRepository.findById(id).get();
	}
	

	@Override
	public void deleteRoleById(Long id) {
		// TODO Auto-generated method stub
		this.roleRepository.deleteById(id);
		
	}

}
