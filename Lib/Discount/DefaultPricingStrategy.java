package Lib.Discount;

import Lib.*;
/**
 * คิดราคาแบบปกติ
 */
public class DefaultPricingStrategy implements Discountstrategy {
    @Override
    public double calculatePrice(CartItem item){
        return item.getProduct().getprice() * item.getQuantity();
    }
}
