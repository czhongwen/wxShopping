/***********************************************************************
 * Module:  CartsDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface CartsDao
 ***********************************************************************/

package dao;

import java.util.List;

import modle.*;

/** @pdOid 4231f694-7781-4f81-b064-3c874d57fe28 */
public interface CartsDao {
   /** @param oppenId 
    * @param pId 
    * @param pNum
    * @pdOid ec11e3dd-9bfa-41c6-8811-1210f73d2259 */
   String addProducts(String oppenId, int[] pIds, int[] pNums);
   /** @param oppenId
    * @pdOid 75419e57-0431-4134-b55a-4cb7b38a0b8c */
   List<Product> findCarets(String oppenId);
   /** @param oppenId 
    * @param pId
    * @pdOid 95022a1a-9139-4e60-af0b-2db3fd1d186a */
   boolean deleteProducts(String oppenId, int pId);

}