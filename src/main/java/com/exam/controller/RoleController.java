package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dao.RoleDao;
import com.exam.dao.StandardDao;
import com.exam.entity.Answer;
import com.exam.entity.Role;
import com.exam.entity.Standard;
import com.exam.entity.User;
import com.exam.service.RoleService;



@RestController
@RequestMapping("/Roles")
public class RoleController {
	@Autowired
	private RoleService roleService;


	@GetMapping("/get")
	 public List<Role> getRole() {
//	   Set<Standard> standards = standardservice.getStandard();
//	   return standards;
	   return roleService.getRole();
	   //return (Set<Standard>) ResponseEntity.ok(this.standardservice.getStandard());
		 
	 }
	 
	 //getting the details of a specific answer
	@GetMapping("/get/{roleId}")
	 private Role getstandard(@PathVariable("id") Long id){
		 return roleService.getRoleById(id);
	 }

	 @PostMapping("/add")  // requesting data that is why we use RequestBody annotation
	 public ResponseEntity<?> addRole(@RequestBody RoleDao roleDao){
		Role r=this.roleService.addRole(roleDao);
		return ResponseEntity.ok(r);
		 
	 }
	 
	 //delete the user by id 
	 
	 
	 @PutMapping("/update/{roleId}")
	 public Answer updateRole(@PathVariable("roleId")Long RoleId, @RequestBody Role role) {
		return null;
		 
	 }
	 @DeleteMapping("/delete/{roleId}")
	 public ResponseEntity<String> deleteStandard(@PathVariable("roleId") Long roleId) {
		  roleService.deleteRoleById(roleId);
		  return new ResponseEntity<String>("Role deleted successfully",HttpStatus.OK);
	 }
	 
}
