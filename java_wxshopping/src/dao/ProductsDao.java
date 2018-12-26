/***********************************************************************
 * Module:  ProductsDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface ProductsDao
 ***********************************************************************/

package dao;

import modle.Product;
import java.util.*;

/** @pdOid b3cc86fa-4c71-4790-b47f-f38095ab39e4 */
public interface ProductsDao {
   /** @param products
    * @pdOid dee74892-b703-4d25-90fd-0b79dc27151e */
   boolean addProduct(Product products);
   /** @param pId
    * @pdOid 6bb9e235-f564-45f0-b6d5-df9161ad48bb */
   boolean deleteProduct(int pId);
   /** @param product
    * @pdOid 1016a0f7-b49b-4768-aa6d-4c1c287a7c88 */
   boolean updateProducts(Product product);
   /** @pdOid 9a5e4888-fbea-4af7-a81b-4ffb8b1cd050 */
   List<Product> findProducts();
   /** @param key
    * @pdOid 93c999ff-980e-423d-8bec-a2cbb2e0c2a5 */
   List<Product> findProductsByKey(int no,String key);
   
   List<Product> findProductsByType(int no,int typeNum);
   
   Product findProductsById(int pId);
   
   List<Product> findProducts(int arrs,int typeNum);
}