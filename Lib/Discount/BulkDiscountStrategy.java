package Lib.Discount;

import Lib.CartItem;

/**
 * ซื้อเยอะลดราคา
 */
public class BulkDiscountStrategy implements Discountstrategy {
    private final int minimumQuantity;
    private final double discountpercentage;

    public BulkDiscountStrategy(int minimumQuantity, double discountpercentage){
        this.minimumQuantity = minimumQuantity;
        this.discountpercentage = discountpercentage;
    }

    @Override
    public double calculatePrice(CartItem item){
        double originalPrice = item.getProduct().getprice();
        if(item.getQuantity() >= minimumQuantity){
            return (originalPrice * item.getQuantity()) - (originalPrice * item.getQuantity() * discountpercentage);
        }
        return originalPrice * item.getQuantity();
    }
}
