package org.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Product {
    String productName;
    ProductCategory productCategory;
    BigDecimal price;
    Discount discount;
    public Product(String productName, ProductCategory productCategory, BigDecimal price, Discount discount) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.discount = discount;
    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(productName, productCategory, price, discount);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Product product = (Product) obj;
//        return Float.compare(product.price, price) == 0 &&
//                Objects.equals(productName, product.productName) &&
//                Objects.equals(productCategory, product.productCategory) &&
//                Objects.equals(discount, product.discount);
//    }
}
