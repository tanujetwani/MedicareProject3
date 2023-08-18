package org.simplilearn.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	        @Id
	        @GeneratedValue(strategy=GenerationType.IDENTITY)
	        private int order_detail_id;
	        
	        private int qty;
	        
	        @OneToOne
	        @JoinColumn(name="pid")
	        private Product product;
	        
	        
	        @ManyToOne(cascade=CascadeType.MERGE)
	        @JoinColumn(name="order_id")
	        private Orders order;
	        
	        
            private float amount;


            
            //Getters and Setters
			public int getOrder_detail_id() {
				return order_detail_id;
			}


			public void setOrder_detail_id(int order_detail_id) {
				this.order_detail_id = order_detail_id;
			}


			public int getQty() {
				return qty;
			}


			public void setQty(int qty) {
				this.qty = qty;
			}


			public Product getProduct() {
				return product;
			}


			public void setProduct(Product product) {
				this.product = product;
			}


			public Orders getOrder() {
				return order;
			}


			public void setOrder(Orders order) {
				this.order = order;
			}


			public float getAmount() {
				return amount;
			}


			public void setAmount(float amount) {
				this.amount = amount;
			}


               


}
