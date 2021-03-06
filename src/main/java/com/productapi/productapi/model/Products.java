package com.productapi.productapi.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_qty")
    private Integer product_qty;

    public Products() {

    }
	
	public Products(Integer product_id, String product_name, Integer product_qty) {
        super();
		this.product_id = product_id;
		this.product_name = product_name;
        this.product_qty = product_qty;
	}
                
        public Integer getProduct_id() {
            return product_id;
        }

        public void setProduct_id(Integer product_id) {
            this.product_id = product_id;
        }

        public String getProductName() {
            return product_name;
        }

        public void setProductName(String product_name) {
            this.product_name = product_name;
        }

        public Integer getProductQty() {
            return product_qty;
        }

        public void setProductQty(Integer product_qty) {
            this.product_qty = product_qty;
        }
       
}