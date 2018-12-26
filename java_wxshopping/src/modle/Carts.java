/***********************************************************************
 * Module:  Carts.java
 * Author:  Administrator
 * Purpose: Defines the Class Carts
 ***********************************************************************/

package modle;

import java.util.*;

/** @pdOid 384846fc-fc06-47a5-a19b-13a980e4ab65 */
public class Carts {
   /** @pdOid e87f8aa7-2703-45e7-ab11-0c7549427490 */
   private String oppendid;
   /** @pdOid 9a7f6861-9950-468e-af8f-aacf0e014454 */
   private List<Integer> listPid;
   
   /** @pdOid 0eaeeb49-ded8-4f82-8283-645268111338 */
   public String getOppendid() {
      return oppendid;
   }
   
   /** @param newOppendid
    * @pdOid dcc785f8-c68f-4dba-a864-0e1a2577bc5e */
   public void setOppendid(String newOppendid) {
      oppendid = newOppendid;
   }
   
   /** @pdOid 6a9889b9-5d6e-4553-ad3f-7e4f25391986 */
   public List<Integer> getListPid() {
      return listPid;
   }
   
   /** @param newListPid
    * @pdOid 11386574-e2d4-4534-855b-c6b869358387 */
   public void setListPid(List<Integer> newListPid) {
      listPid = newListPid;
   }

}