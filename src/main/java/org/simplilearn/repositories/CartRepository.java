package org.simplilearn.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	   @Query(value="select * from cart c where c.prodid=?1 and c.userid=?2",nativeQuery=true)
	   Cart findByProdidAndUserid(int pid,int userid);
	   
	   @Modifying
	   @Transactional
	   @Query(value="delete from cart c where c.prodid=?1 and c.userid=?2", nativeQuery=true)
	   int deleteByProdidAndUserid(int pid, int userid);
	   
	   @Query(value="select * from cart c where c.userid=?1",nativeQuery=true)
	   List<Cart> findByUserid(int userid);
	   
	   @Modifying
	   @Transactional
	   @Query(value="delete from cart c where c.userid=?1",nativeQuery=true)
	   void deleteByUserid(int userid);

}
