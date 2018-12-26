/***********************************************************************
 * Module:  OrderDetail.java
 * Author:  Administrator
 * Purpose: Defines the Class OrderDetail
 ***********************************************************************/

package modle;

/** @pdOid 1402a6e6-17ac-436c-be66-946a500102c0 */
public class OrderDetail {
   /** @pdOid b3c7f1aa-d634-4d91-9e81-ff20170c8f41 */
   private int oId;
   /** @pdOid aac30724-6776-413e-b5a9-a17908f54f29 */
   private int pId;
   /** @pdOid 1ba823f1-31da-4243-a712-cc336ecacd27 */
   private int pNum;
   /** @pdOid 783a14e2-4767-487b-9817-a8bfab214323 */
   private String pName;
   /** @pdOid 8bf42ba8-f38f-499f-9c16-d63488c09c5c */
   private String pPic1;
   
   /** @pdOid cf48e2a2-354a-4992-8e88-ad9c60be4f38 */
   public int getOId() {
      return oId;
   }
   
   /** @param newOId
    * @pdOid f1f80e89-e8b5-45a3-8e19-033f09119e5b */
   public void setOId(int newOId) {
      oId = newOId;
   }
   
   /** @pdOid 5b884f79-375f-43a8-ad0e-9bf80aeec0a8 */
   public int getPId() {
      return pId;
   }
   
   /** @param newPId
    * @pdOid 96aa3b6a-9c43-4b98-a771-86fa9c7a7800 */
   public void setPId(int newPId) {
      pId = newPId;
   }
   
   /** @pdOid 0a70de70-897f-4a32-b3e6-36f2f3e08631 */
   public int getPNum() {
      return pNum;
   }
   
   /** @param newPNum
    * @pdOid 6676ca67-55fe-4424-aa38-49a029c03b1f */
   public void setPNum(int newPNum) {
      pNum = newPNum;
   }
   
   /** @pdOid abe09a4e-5691-4898-b880-f49d078d446f */
   public String getPName() {
      return pName;
   }
   
   /** @param newPName
    * @pdOid 90e1e5a7-e75b-4a2f-93d8-2e32b6316073 */
   public void setPName(String newPName) {
      pName = newPName;
   }
   
   /** @pdOid 0710608c-90c1-4b81-bb77-73ad326e6d37 */
   public String getPPic1() {
      return pPic1;
   }
   
   /** @param newPPic1
    * @pdOid dd4bc5f6-2bcd-4a2f-8911-634209c57293 */
   public void setPPic1(String newPPic1) {
      pPic1 = newPPic1;
   }

}