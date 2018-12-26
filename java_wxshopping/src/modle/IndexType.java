/***********************************************************************
 * Module:  IndexType.java
 * Author:  Administrator
 * Purpose: Defines the Class IndexType
 ***********************************************************************/

package modle;

import java.util.*;

/** @pdOid ffd2519e-56fd-461b-bc78-3b90740d6de2 */
public class IndexType {
   /** @pdOid 128ab8e2-47c9-436e-aee2-2254019fd357 */
   private int itId;
   /** @pdOid c79960c0-0c2f-4408-bca6-a6e1425504f0 */
   private String itImage;
   /** @pdOid a98054d2-5ad9-464d-ad4e-884b161eed61 */
   private String itName;
   /** @pdOid d911b570-082e-47d2-a027-ffd57bf4f85b */
   private List<IndexDetail> listId;
   
   /** @pdOid 344669d5-10ab-49b1-b19e-f4d42d2f78e4 */
   public List<IndexDetail> getListId() {
      return listId;
   }
   
   /** @param newListId
    * @pdOid 323d95b2-d8ab-4b56-8e60-f429a36e44fc */
   public void setListId(List<IndexDetail> newListId) {
      listId = newListId;
   }
   
   /** @pdOid 732e1b5d-bda9-43ec-a9ea-550c095a2116 */
   public int getItId() {
      return itId;
   }
   
   /** @param newItId
    * @pdOid 2d5fccba-387c-4899-93eb-5ebd3f0dd23a */
   public void setItId(int newItId) {
      itId = newItId;
   }
   
   /** @pdOid 066fccf0-a933-4ffd-84b8-82684b9b27a3 */
   public String getItImage() {
      return itImage;
   }
   
   /** @param newItImage
    * @pdOid 4d1b5616-157a-474d-838e-0b876476f286 */
   public void setItImage(String newItImage) {
      itImage = newItImage;
   }
   
   /** @pdOid 064eede2-7945-465b-ba0a-c5be1a939857 */
   public String getItName() {
      return itName;
   }
   
   /** @param newItName
    * @pdOid c23d674f-2e64-4241-9b4f-f9faeec8e336 */
   public void setItName(String newItName) {
      itName = newItName;
   }

}