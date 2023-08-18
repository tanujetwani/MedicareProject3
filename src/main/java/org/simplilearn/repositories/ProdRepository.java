package org.simplilearn.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends JpaRepository<Product,Integer> {
	
	//@Query(value="select * from product p where CHARINDEX('?1',p.name)>0 OR CHARINDEX('?1',p.category)>0 OR CHARINDEX('?1',p.description)>0 OR "
			//+ "CHARINDEX('?1',p.seller)>0 OR CHARINDEX('?1',CONCAT(p.price,' '))>0",nativeQuery=true)
	@Query(value="select * from product p where p.name like %?1% OR p.category like %?1% OR p.description like %?1% OR  p.seller like %?1% OR CONCAT( p.price,' ') like %?1%", nativeQuery=true)  
	List<Product> findByKeyword(String keyword);
	
	   @Transactional
	   @Modifying
	   @Query(value="delete from product p where p.pid=?1",nativeQuery=true)
	   int deleteById(int pid);
	   
	   
	   @Transactional
	   @Modifying
	   @Query(value="delete from product p where p.category like %?1%",nativeQuery=true)
	   int deleteByCategory(String category);
	   
	   
	   @Transactional
	   @Modifying
	   @Query(value="delete from product p where p.name=?1",nativeQuery=true)
	   int deleteByName(String name);
	   
	   
	   @Query(value="select count(*) from product p where p.category like %?1%",nativeQuery=true)
	   int findByCategory(String category);
	  
	  
	  
	  
/*	  @Query(value="select * from product p where CONCAT(p.name,' ',p.seller,' ',p.category,' ',p.description,' ', p.price) like %?1%  Order By p.price",nativeQuery=true)
	  List<Product> findByKeywordAndSortByPrice(String keyword);
	  
	  @Query(value="select * from product p where CONCAT(p.name,' ',p.seller,' ',p.category,' ',p.description,' ', p.price) like %?1%  Order By p.name", nativeQuery=true)
	  List<Product> findByKeywordAndSortByName(String keyword);

	  @Query(value="select * from product p where CONCAT(p.name,' ',p.seller,' ',p.category,' ',p.description,' ', p.price) like %?1%  Order By p.category", nativeQuery=true)
	  List<Product> findByKeywordAndSortByCategory(String keyword);
      
	  @Query(value="select * from product p where CONCAT(p.name,' ',p.seller,' ',p.category,' ',p.description,' ', p.price) like %?1%  Order By p.category", nativeQuery=true)
      List<Product> findByKeywordAndSortBySeller(String keyword);

*/
}
