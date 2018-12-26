/***********************************************************************
 * Module:  AddressDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface AddressDao
 ***********************************************************************/

package dao;

import modle.Address;
import java.util.*;

/** @pdOid 8e98b1d0-dfc5-4d48-b796-10ca798d5e57 */
public interface AddressDao {
   /** @param oppenId
    * @pdOid ea1aff67-275c-4c7a-969d-648bdd8a75fb */
   List<Address> getAddress(String oppenId);
   /** @param address
    * @pdOid 5ef6cde2-0687-4fe6-bbf8-e5443e1cc65f */
   boolean updateAddress(Address address);
   /** @param aId
    * @pdOid 484df19c-911a-45af-8f5d-4487881630da */
   boolean deleteAddress(int aId);
   /** @param address
    * @pdOid e64fc3d5-b9cb-4ec2-87e6-ae73cdd9fcd9 */
   boolean addAddress(Address address);

}