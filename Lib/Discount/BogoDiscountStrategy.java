package Lib.Discount;

import Lib.CartItem;
/**
 * ซื้อ 1 แถม 1
 */
public class BogoDiscountStrategy implements Discountstrategy {
    @Override
    public double calculatePrice(CartItem item){
        int quantity = item.getQuantity();
        double price = item.getProduct().getprice();
        int quantityToPay = (quantity / 2) + (quantity % 2);
        return price * quantityToPay;
    }

}
