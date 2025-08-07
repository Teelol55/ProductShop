package Lib;

import java.util.ArrayList;

import Lib.Discount.DefaultPricingStrategy;
import Lib.Discount.Discountstrategy;

public class PricingService {

    private record StrategyRule(String sku, Discountstrategy strategy){}
    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final Discountstrategy defaulStrategy = new DefaultPricingStrategy();
    /**
     * เพิ่มหรืออัปเดตกลยุทธ์สำหรับสินค้าเฉพาะ SKU
     * หากมีอยู่แล้วจะทำการแทนที่กลยุทธ์เก่า
     *
     * @param sku รหัสสินค้า (Product ID)
     * @param strategy กลยุทธ์ส่วนลดที่จะใช้กับสินค้า
     */
    public void addStrategy(String sku, Discountstrategy strategy){
        StrategyRule ruleToRemove = null;
        for(StrategyRule rule : strategies){
            if(rule.sku().equals(sku)){
                ruleToRemove = rule;
                break;
            }
        }
        if (ruleToRemove != null){
            strategies.remove(ruleToRemove);
        }
        strategies.add(new StrategyRule(sku, strategy));
    }
    /**
     * คำนวณราคาสินค้าในตะกร้าตามกลยุทธ์ที่กำหนดไว้
     * หากไม่พบกลยุทธ์เฉพาะ จะใช้กลยุทธ์เริ่มต้น
     *
     * @param item สินค้าในตะกร้า
     * @return ราคาที่คำนวณแล้วตามกลยุทธ์ที่กำหนด
     */
    public double calculateItemPrice(CartItem item){
        String sku = item.getProduct().getproductId();
        for(StrategyRule rule : strategies){
            if(rule.sku().equals(sku)){
                return rule.strategy().calculatePrice(item);
            }
        }
        return defaulStrategy.calculatePrice(item);
    }
}
