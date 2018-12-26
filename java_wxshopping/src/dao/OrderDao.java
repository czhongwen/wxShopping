/***********************************************************************
 * Module:  OrderDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface OrderDao
 ***********************************************************************/

package dao;

import modle.*;
import java.util.*;

/** @pdOid 5fb8f32e-fe12-4f41-94a8-13a242139b18 */
public interface OrderDao {
   /** @param poducts 
    * @param oppenId
    * @pdOid 7f5c9c01-4be3-49a2-a897-05b6058a1ef2 */
   boolean addOrder(Order order, String oppenId);
   /** @pdOid 5df53052-fca9-4ff1-9904-f6d4a7334d63 */
   List<Order> findOrders();
   /** @param oppenId
    * @pdOid d62a635b-a0f5-42c5-8465-04f72d7d77b3 */
   List<Order> findOrders(String oppenId);
   /** @param order
    * @pdOid 439c52e6-07e4-431c-90dc-fcd0a38fbb09 */
   boolean updateOrder(Order order);
   
   List<Product> getHotProducts();
}