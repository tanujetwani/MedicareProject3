package org.simplilearn.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Orders {
	
	        @Id
	        @GeneratedValue(strategy=GenerationType.IDENTITY)
	        private int order_id;
	        
	        
	        @CreationTimestamp
	        private LocalDateTime order_date;
	        
	        
	        private float total_amount;
	        
	        @ManyToOne
	        @JoinColumn(name="userid")
	        private Users user;
	        
	        
	        @OneToMany(mappedBy="order")
	        private Set<OrderDetails> ord_details=new HashSet<>();

           
	        //Getters and Setters
			public int getOrder_id() {
				return order_id;
			}


			public void setOrder_id(int order_id) {
				this.order_id = order_id;
			}


			public LocalDateTime getOrder_date() {
				return order_date;
			}


			public void setOrder_date(LocalDateTime order_date) {
				this.order_date = order_date;
			}


			public float getTotal_amount() {
				return total_amount;
			}


			public void setTotal_amount(float total_amount) {
				this.total_amount = total_amount;
			}


			public Users getUser() {
				return user;
			}


			public void setUser(Users user) {
				this.user = user;
			}


			public Set<OrderDetails> getOrd_details() {
				return ord_details;
			}


			public void setOrd_details(Set<OrderDetails> ord_details) {
				this.ord_details = ord_details;
			}

             
			//helper methods to add OrderDetails
			
			public void addOrd_Details(OrderDetails ord_detail) {
				
				ord_details.add(ord_detail);
			}
	        
}
