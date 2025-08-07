package Lib;

import java.util.ArrayList;
//  class ทำหน้าที่ catalog สินค้า (Repository)
public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();


    private void checkRep(){
        if (products == null) {
            throw new RuntimeException("RI violated : products");
        }
        //check for duplicate products
        for(int i = 0;i < products.size(); i++){
            for(int j = i + 1 ;j < products.size(); j++ ){
                if(products.get(i).equals(products.get(j))){
                    throw new RuntimeException("RI violated");
                }
            }
        }
    }

    public ProductCatalog(){
        checkRep();
    }
    /**
     * เพิ่มสินค้าใหม่เข้าสู่Catalog
     * @param product สินค้าที่ต้องการเพ่ิม
     */
    public void addProduct(Product product){
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
        checkRep();
    }
    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param producted รหัสสินค้าที่ต้องการค้นหา
     * @return obj product หากพบ, หรือ null หากไม่พบ
     */

     public Product findById(String productId){
        for(Product p : products){
            if(p.getproductId().equals(productId)){
                return p;
            }
        }
        return null;
     }
}
