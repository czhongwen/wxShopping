/***********************************************************************
 * Module:  Address.java
 * Author:  Administrator
 * Purpose: Defines the Class Address
 ***********************************************************************/

package modle;

/** @pdOid 944c7946-254a-4796-81ee-e274dd189a91 */
public class Address {
   /** @pdOid 9c672849-dce2-43dc-a825-2b484e9c09fc */
   private int aId;
   /** @pdOid b8e3d8da-4112-4d39-81a1-d6aacd4e160c */
   private String oppenid;
   /** @pdOid 761a8441-f762-42d0-b56e-f95fbf82e781 */
   private String name;
   /** @pdOid 02099529-f8c6-49c6-b40e-0c46b476e377 */
   private String telephone;
   /** @pdOid d0411103-ab5a-45ec-9bbe-fdc52eba7cc8 */
   private String provice;
   /** @pdOid f0ca9abf-d80a-4fc9-9143-f0e49106f9ae */
   private String city;
   /** @pdOid 67370ca5-b917-4f9b-aa45-cd2890bc90f5 */
   private String county;
   /** @pdOid 3828ade7-b8e0-4886-9c07-f98b6fa45c73 */
   private String detail;
   /** @pdOid da548f96-9484-4827-9dc7-ca314c003d28 */
   private int defaultAdress;
   
   /** @pdOid 5aae0588-d7f5-42a5-98a2-f495e7c89dd0 */
   public String getOppenid() {
      return oppenid;
   }
   
   /** @param newOppenid
    * @pdOid bb30d425-2dd4-43bf-9674-ec00cac85d16 */
   public void setOppenid(String newOppenid) {
      oppenid = newOppenid;
   }
   
   /** @pdOid e21fe37f-554e-40c5-9f03-27d0a8455453 */
   public String getName() {
      return name;
   }
   
   /** @param newName
    * @pdOid 1288497d-03fe-4368-900d-6226fb4f4deb */
   public void setName(String newName) {
      name = newName;
   }
   
   /** @pdOid 2b85f1fb-6b18-48d7-aad6-d4fc1521d25a */
   public String getTelephone() {
      return telephone;
   }
   
   /** @param newTelephone
    * @pdOid d6b18d1a-b943-41be-9296-ee5964183646 */
   public void setTelephone(String newTelephone) {
      telephone = newTelephone;
   }
   
   /** @pdOid 4c6a331f-a47d-4940-b152-9d103e83fd1c */
   public String getProvice() {
      return provice;
   }
   
   /** @param newProvice
    * @pdOid 770048d2-3158-42e0-a7d8-ffec7605dfad */
   public void setProvice(String newProvice) {
      provice = newProvice;
   }
   
   /** @pdOid c3ef782e-ab4d-4bfe-8006-8ca08c9866a5 */
   public String getCity() {
      return city;
   }
   
   /** @param newCity
    * @pdOid 9382f38f-c481-4df9-bdbc-faf55e803ffb */
   public void setCity(String newCity) {
      city = newCity;
   }
   
   /** @pdOid 3561075c-efda-4336-8d1d-52cfe6629845 */
   public String getCounty() {
      return county;
   }
   
   /** @param newCounty
    * @pdOid 7155868d-21e0-4422-b364-611ef79db20d */
   public void setCounty(String newCounty) {
      county = newCounty;
   }
   
   /** @pdOid ea924f2b-c00b-482d-8f1b-60e5271e4fd0 */
   public String getDetail() {
      return detail;
   }
   
   /** @param newDetail
    * @pdOid 70a7973d-5de9-4a46-bd1e-b06b9c83997a */
   public void setDetail(String newDetail) {
      detail = newDetail;
   }
   
   /** @pdOid 23483519-1222-4490-9a11-72c989afd8e0 */
   public int getDefaultAdress() {
      return defaultAdress;
   }
   
   /** @param i
    * @pdOid ff0f1e76-bca6-44c2-a30a-23073bdbf871 */
   public void setDefaultAdress(int i) {
      defaultAdress = i;
   }
   
   /** @pdOid b3e3c53a-dfb9-4b00-aab7-45d2fbeb3c8f */
   public int getAId() {
      return aId;
   }
   
   /** @param i
    * @pdOid 45302fcf-4de8-457c-83af-a5db784bad89 */
   public void setAId(int i) {
      aId = i;
   }

}