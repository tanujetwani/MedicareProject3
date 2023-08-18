package org.simplilearn.repositories;

import java.util.List;

import org.simplilearn.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
	
	@Query(value="select * from users u where u.uname=?1 and u.upwd=?2",nativeQuery=true)
	Users findByUnameAndUpwd(String name, String pwd);

	@Query(value="select upwd from org.simplilearn.entities.Users")
	List<String> findAllPwds();
}
