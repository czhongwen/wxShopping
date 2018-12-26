/***********************************************************************
 * Module:  Product.java
 * Author:  Administrator
 * Purpose: Defines the Class Product
 ***********************************************************************/

package modle;

/** @pdOid d8bec9a7-365b-44c8-9893-a8044031e02e */
public class Product {
   /** @pdOid 50795f43-c524-436d-af72-9c41001d00b7 */
   private int pId;
   /** @pdOid f7ad2d1b-7d60-449a-aec9-f07c567fc578 */
   private String pName;
   /** @pdOid e71dcbaf-c724-46ba-b9bb-eae9e716031d */
   private String pDetail;
   /** @pdOid b43076b2-cd08-4c3b-9f5b-23af2e320f26 */
   private String pInfo;
   /** @pdOid d18343b2-f0e2-4986-80d2-6581b53592fd */
   private String rDate;
   /** @pdOid 7be72fb7-237f-4135-be49-f01b8929e9a8 */
   private String pColor;
   /** @pdOid 705ed63b-788b-4d63-9769-03866666dd1b */
   private String pTypical;
   /** @pdOid ac0914f4-ca59-439b-af00-913cc96989d6 */
   private int pPrice;
   /** @pdOid 3f64d834-c129-4885-ae90-2200c683bd2d */
   private int pNum;
   /** @pdOid 2fecd712-5417-48ea-a683-262165d86242 */
   private int pDiscunt;
   /** @pdOid 3e0218bb-b48b-4ac7-b5c0-b61d72abee6d */
   private String pPic1;
   /** @pdOid 552cf52f-8230-43c7-a3b7-d6803ee1c306 */
   private String pPic2;
   /** @pdOid 32966d2b-ceb1-42af-8c64-fcf40712fb87 */
   private String pPic3;
   /** @pdOid b56e140f-2eff-40c1-a052-37e9f3c5cf5f */
   private String pPic4;
   /** @pdOid c19b62f5-ebc2-40fd-83e9-f1c4d2348d80 */
   private String pPic5;
   private int pType;
   /** @pdOid a6ddda36-6b69-4117-aa02-8aeeb08a6922 */
   public String getPName() {
      return pName;
   }
   
   /** @param newPName
    * @pdOid cdc0ee6a-a95d-405a-a900-a296b3e76881 */
   public void setPName(String newPName) {
      pName = newPName;
   }
   
   /** @pdOid 1266cd0f-683b-4f7f-8bb1-a4add5a6b0ab */
   public String getPDetail() {
      return pDetail;
   }
   
   /** @param newPDetail
    * @pdOid 3e7fb813-3e45-4ecf-9369-b273ab1dff55 */
   public void setPDetail(String newPDetail) {
      pDetail = newPDetail;
   }
   
   /** @pdOid 348b32bd-7ef1-46e3-8e55-9d1ccb3cb6db */
   public String getPInfo() {
      return pInfo;
   }
   
   /** @param newPInfo
    * @pdOid 2a15f6dc-9273-4330-9c43-54ddab4d3b4f */
   public void setPInfo(String newPInfo) {
      pInfo = newPInfo;
   }
   
   /** @pdOid 15644e10-5ae7-4ae2-b883-7181e98b2077 */
   public String getRDate() {
      return rDate;
   }
   
   /** @param newRDate
    * @pdOid 9cad9732-99b6-4182-a7b1-2e82356801ab */
   public void setRDate(String newRDate) {
      rDate = newRDate;
   }
   
   /** @pdOid f9165b6c-35ee-4c69-a21f-b79f51bc658e */
   public int getPId() {
      return pId;
   }
   
   /** @param newPId
    * @pdOid 99415c43-ac18-4828-aea7-48a0baf5a96a */
   public void setPId(int newPId) {
      pId = newPId;
   }
   
   /** @pdOid fa16d71c-270b-4f22-a01e-ad7457bbe200 */
   public String getPColor() {
      return pColor;
   }
   
   /** @param newPColor
    * @pdOid 224976fc-04d6-427e-8e61-1e9826fe0ed0 */
   public void setPColor(String newPColor) {
      pColor = newPColor;
   }
   
   /** @pdOid aa3d710f-2975-47e5-aa5f-7c99c3a6dc99 */
   public String getPTypical() {
      return pTypical;
   }
   
   /** @param newPTypical
    * @pdOid 79d98401-efdd-484f-a8ca-f9b5daddf3e8 */
   public void setPTypical(String newPTypical) {
      pTypical = newPTypical;
   }
   
   /** @pdOid 5f223019-39e2-430d-a745-3a70c626faf8 */
   public int getPPrice() {
      return pPrice;
   }
   
   /** @param newPPrice
    * @pdOid 4d6857c9-607b-435c-8219-1a6ec116afad */
   public void setPPrice(int newPPrice) {
      pPrice = newPPrice;
   }
   
   /** @pdOid 8a95363b-1f4c-4974-8387-f1799a3224da */
   public int getPNum() {
      return pNum;
   }
   
   /** @param newPNum
    * @pdOid d1d2e4a0-5249-4c55-85bd-1bb64ed99013 */
   public void setPNum(int newPNum) {
      pNum = newPNum;
   }
   
   /** @pdOid 2c463b9a-5660-4e2a-a07d-18d79f828927 */
   public int getPDiscunt() {
      return pDiscunt;
   }
   
   /** @param newPDiscunt
    * @pdOid 52abd35b-e898-4cdf-948e-178f229e43a9 */
   public void setPDiscunt(int newPDiscunt) {
      pDiscunt = newPDiscunt;
   }

public String getpPic1() {
	return pPic1;
}

public void setpPic1(String pPic1) {
	this.pPic1 = pPic1;
}

public String getpPic2() {
	return pPic2;
}

public void setpPic2(String pPic2) {
	this.pPic2 = pPic2;
}

public String getpPic3() {
	return pPic3;
}

public void setpPic3(String pPic3) {
	this.pPic3 = pPic3;
}

public String getpPic4() {
	return pPic4;
}

public void setpPic4(String pPic4) {
	this.pPic4 = pPic4;
}

public String getpPic5() {
	return pPic5;
}

public void setpPic5(String pPic5) {
	this.pPic5 = pPic5;
}

public int getpType() {
	return pType;
}

public void setpType(int pType) {
	this.pType = pType;
}

}