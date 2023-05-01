package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.entity.Section;
import com.exam.entity.Standard;
import com.exam.entity.StudentQuestionAnswer;
import com.exam.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    public User searchByUsername(String username);
    //public void deleteByStandardId(Standard standard);
    public List<User> findByStandard(Standard standard);
//    @Query(nativeQuery=true,value = "DELETE FROM USER WHERE ID=12")
//	public List<Section> findByStandardId(Long standardId);
    
    public List<User> findBySection(Section section);
    
    
//    @Query(value="SELECT COUNT(u) FROM User u ")
//	public Long countuser(User user);
    
    @Query(value="SELECT COUNT(u) FROM User u  ")
	public Long countuser(User user);
    
    
    
    @Query("SELECT u FROM User u WHERE u.role.roleName <> 'Admin' ")
    public List<User> findUsers();
}
