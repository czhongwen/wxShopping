/***********************************************************************
 * Module:  IndexTypeDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface IndexTypeDao
 ***********************************************************************/

package dao;

import modle.IndexType;
import java.util.*;

/** @pdOid bab04218-64cb-4895-a658-a3328e56b41b */
public interface IndexTypeDao {
   /** @pdOid c219132e-6a37-497c-a4ea-834aea1521c1 */
   List<IndexType> getAll();
   /** @param itId 
    * @param indexType
    * @pdOid 04792c63-f596-405d-a217-2583c4df52d9 */
   boolean updateIndexType(int itId, IndexType indexType);

}