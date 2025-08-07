package Lib;

public class CartItem {
    private final Product product;
    private int quantity;

    private void checkRep(){
        if(product == null) {
            throw new RuntimeException("RI violated : product");
        }
        if(quantity <= 0){
            throw new RuntimeException("RI violated : quantity");
        }
    }

    /**
     * สร้างรายการสินค้าในตระกร้า
     * @param product obj สินค้า
     * @param quantity จำนวนสินค้า ต้องมากกว่า 0 
     */
    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        checkRep();
    }

    /**
     * ดึงสินค้าในรายการ
     *
     * @return สินค้า {@link Product}
     */
    public Product getProduct() { return product;}
    /**
     * ดึงจำนวนสินค้าที่อยู่ในตะกร้า
     *
     * @return จำนวนสินค้า
     */
    
    public int getQuantity() { return quantity;}
    /**
     * เพิ่มจำนวนสินค้าจากค่าที่ระบุ
     *
     * @param amount จำนวนที่ต้องการเพิ่ม (ต้องเป็นค่าบวกหรือศูนย์)
     * @throws RuntimeException ถ้า amount < 0
     */

    /**
     * เพิ่มจำนวนสินค้าในรายการนี้
     * @param amount
     */
    public void increasesQuantity(int amount){
        if(amount > 0) {
            this.quantity += amount;
        }
        checkRep(); //ตรวจสอบการเปลี่ยนแปลงสถานะ
    }
}
