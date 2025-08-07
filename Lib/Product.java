package Lib;
/**
 * ADT ที่ไม่เปลี่ยนรูป (immutable)  สำหรับเก็บข้อมูล
 */

public final class Product {
    private final String productId;
    private final String productName;
    private final double price;


    /**
     * ตรวจว่า RI เป็นจรืงป่าว
     */
    private void checkRep(){
        if(productId == null || productId.isBlank()) {
            throw new RuntimeException("RI violate: productId error");
        }
        if (productName == null || productName.isBlank()) {
            throw new RuntimeException("RI violated: productName error");
        }
        if(price < 0) {
            throw new RuntimeException("RI violated: price error");
        }
    }

    /** สร้าง obj product
     * @param productID รหัสสินค้าห้าม เป็นค่าว่าง
     * @param productName ชื่อสินค้าห้าม เป็นค่าว่าง
     * @param price ราคาสินค้าห้าม เป็นค่าว่าง
     */

    public Product(String productId, String productName, Double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        checkRep();//ตรวจสอบความถูกต้องทุกครั้งที่สร้าง
    }

    public String getproductId() { return productId; }

    public String getproductName() { return productName; }

    public double getprice() { return price; }

    /**
     * เปรียบเทียบ product สองชิ้นโดยใช้ productId
     * @param obj; obj ต้องการเปรียบเทียบ
     * @return true หาก productId เหมือนกัน
     */

    @Override
    public boolean equals(Object obj){
        // ถ้าอ็อบเจกต์นี้เป็นอ็อบเจกต์เดียวกับที่ส่งเข้ามา ก็ถือว่าเท่ากันเลย
        if(this == obj) return true;
        // ถ้าอ็อบเจกต์ที่ส่งมาเป็น null หรือคลาสไม่ตรงกัน ก็ไม่เท่ากัน
        if(obj == null || getClass() != obj.getClass()) return false;
        // แปลงอ็อบเจกต์เป็นคลาส Product
        Product product = (Product) obj;
        // เช็คว่า productId เท่ากันหรือไม่ (ต้องตรวจ null ด้วย)
        return productId.equals(product.productId);
    }
}
