/***********************************************************************
 * Module:  IndexDetail.java
 * Author:  Administrator
 * Purpose: Defines the Class IndexDetail
 ***********************************************************************/

package modle;

/** @pdOid dcaf7192-5469-46e5-9d01-443b3f50c9d8 */
public class IndexDetail {
   /** @pdOid a8875747-d04e-48ef-a0d4-8416849271cb */
   private int idId;
   /** @pdOid d5b6ae3f-ecca-489d-a353-2fdfb9106af1 */
   private int itId;
   /** @pdOid 7722a798-6e7b-4f91-8376-69094c546dad */
   private String idName;
   /** @pdOid fda53ac0-d86f-4ca6-bde7-52c4a0f411b8 */
   private String idImage;
   
   /** @pdOid 17dda97e-37be-4ab4-838d-f0039ff3a0bc */
   public int getIdId() {
      return idId;
   }
   
   /** @param newIdId
    * @pdOid 4bcb3092-66da-48f0-a47f-d36a85a1f002 */
   public void setIdId(int newIdId) {
      idId = newIdId;
   }
   
   /** @pdOid b0a625e5-a68c-493e-bff5-8940dd9bfd59 */
   public int getItId() {
      return itId;
   }
   
   /** @param newItId
    * @pdOid aa7ce5b7-6b7f-44fb-a5c7-0f1faa04dc77 */
   public void setItId(int newItId) {
      itId = newItId;
   }
   
   /** @pdOid 25472893-5133-4b8d-9018-c65f8c4f4d57 */
   public String getIdName() {
      return idName;
   }
   
   /** @param newIdName
    * @pdOid a9132433-9659-4744-8c56-ab0b9adc522e */
   public void setIdName(String newIdName) {
      idName = newIdName;
   }
   
   /** @pdOid fb72108a-5b16-40e3-9c77-83bc31a07560 */
   public String getIdImage() {
      return idImage;
   }
   
   /** @param newIdImage
    * @pdOid 1d10f83f-6a17-47d7-8530-d9a92aaa4ef6 */
   public void setIdImage(String newIdImage) {
      idImage = newIdImage;
   }

}