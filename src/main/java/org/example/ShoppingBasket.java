package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    User user;
    private Map<Product, Integer> shoppingCart = new HashMap<>();
    public void displayShoppingCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + product.getProductName() + ", Quantity: " + quantity);
        }
    }
    public BigDecimal checkout() {
        BigDecimal totalPrice = calculatePrice();
        BigDecimal totalPriceAfterDiscount = applyCoupon(totalPrice, "DummyCoupon");
        if(makePayment(totalPrice)){
            user.sendNotification();
            user.updateOderHistory(shoppingCart);
            notifyDeliveryService(user, shoppingCart);
            //update the hoopingCart with
            shoppingCart.clear();
        }
        return totalPriceAfterDiscount;
    }

    private void notifyDeliveryService(User user, Map<Product, Integer> shoppingCart) {
        //TODO add implementation
    }

    private boolean makePayment(BigDecimal totalPrice) {
        //TO DO -- add paymentGatewayAPI
        return true;
    }

    private BigDecimal calculatePrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0.0);
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            BigDecimal p = product.getDiscount().applyDiscount(quantity, product.getPrice());
            totalPrice = totalPrice.add(p);
        }
        return totalPrice;
    }
    private BigDecimal applyCoupon(BigDecimal totalPrice, String couponCode) {
        if(verifyCouponCode(couponCode)){
            return totalPrice.subtract(getCouponValue(couponCode));
        }
        return totalPrice;
    }

    private BigDecimal getCouponValue(String couponCode) {
        return new BigDecimal(0);
    }

    private boolean verifyCouponCode(String couponCode) {
        //TO DO - implement validity of coupon code
        return false;
    }

    public void addProductQuantity(Product product, int quantity) throws NotEnoughItemsInStockException{
        shoppingCart.put(product, shoppingCart.getOrDefault(product, 0) + quantity);
    }

    public void reduceProductQuantity(Product product, int quantity) {
        int existingQuantity = shoppingCart.get(product);
        int newQuantity = existingQuantity - quantity;
        shoppingCart.put(product, newQuantity);
    }

    public void updateProductQuantity(Product product, int newQuantity) throws NotEnoughItemsInStockException{
        if (shoppingCart.containsKey(product)) {
            shoppingCart.put(product, newQuantity);
        }
    }

    public void setUser(User user) {
        this.user = user;
    }
}
