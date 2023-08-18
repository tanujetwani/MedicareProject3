package org.simplilearn.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Cart {
	
	     @Id
	     @GeneratedValue(strategy=GenerationType.IDENTITY)
	     private int cartid;
	     private int qty;
	     
	     @OneToOne(cascade=CascadeType.ALL)
	     @JoinColumn(name="prodid")
	     private Product prod;
	     
	     @ManyToOne(cascade=CascadeType.MERGE)
	     @JoinColumn(name="userid")
	     private Users user;
	     
	     
	     //Default constructor
	     
	     public Cart() {}

       
	     //Getters and Setters
		public int getCartid() {
			return cartid;
		}


		public void setCartid(int cartid) {
			this.cartid = cartid;
		}


		public int getQty() {
			return qty;
		}


		public void setQty(int qty) {
			this.qty = qty;
		}


		public Product getProd() {
			return prod;
		}


		public void setProd(Product prod) {
			this.prod = prod;
		}


		public Users getUser() {
			return user;
		}


		public void setUser(Users user) {
			this.user = user;
		}
	     
	     
	     

}
