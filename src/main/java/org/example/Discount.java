package org.example;

import java.math.BigDecimal;

public enum Discount {
    BUY_ONE_GET_ONE_FREE {
        @Override
        public BigDecimal applyDiscount(int quantity, BigDecimal price) {
            int discountQuantity = quantity / 2;
            return price.multiply(BigDecimal.valueOf(quantity - discountQuantity));
        }
    },
    THREE_FOR_PRICE_OF_TWO {
        @Override
        public BigDecimal applyDiscount(int quantity, BigDecimal price) {
            int discountQuantity = quantity / 3;
            return price.multiply(BigDecimal.valueOf(quantity - discountQuantity));
        }
    },
    NO_DISCOUNT {
        @Override
        public BigDecimal applyDiscount(int quantity, BigDecimal price) {
            return price.multiply(BigDecimal.valueOf(quantity));
        }
    };

    public abstract BigDecimal applyDiscount(int quantity, BigDecimal price);
}

