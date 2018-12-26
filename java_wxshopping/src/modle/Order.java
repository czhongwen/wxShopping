/***********************************************************************
 * Module:  Order.java
 * Author:  Administrator
 * Purpose: Defines the Class Order
 ***********************************************************************/

package modle;

import java.util.List;

/** @pdOid 2b8657af-90e7-4cdf-9fc3-b395c93263a2 */
public class Order {
	/** @pdOid ffcdb849-585b-4fae-8a06-87475377efd2 */
	private int oId;
	/** @pdOid 80d974f8-30ee-4f11-b396-ce540c9af2e1 */
	private int aId;
	/** @pdOid c4639272-eb1f-410c-97e7-f326d7d2cfc5 */
	private String oppenId;
	/** @pdOid 6f972aba-0560-46b3-b60e-d22bfd76dc4d */
	private String date;
	/** @pdOid 5201dc3a-898f-4ddc-adfa-5b3bd0d357a0 */
	private String aTelephone;
	/** @pdOid ab0aecec-5022-4e66-becb-c9ade1e87dab */
	private String aProvice;
	/** @pdOid 0009834a-82b8-4293-a6de-d67fbde9f0aa */
	private String aCity;
	/** @pdOid a118ae83-35f9-4b7a-bdbe-21e180f7b9ff */
	private String status;
	/** @pdOid 3bc161d5-1dc3-4a57-b333-ff708317fbe0 */
	private List<OrderDetail> listDetal;

	private String name;
	
	private String county;
	
	private String aDetail;
	
	private List<Product> Products;
	/** @pdOid ae39d0e8-f205-4151-89fd-cb69502f084f */
	public int getOId() {
		return oId;
	}

	/**
	 * @param newOId
	 * @pdOid 490fa4c5-191d-490e-b89d-2a5fd9d2bd59
	 */
	public void setOId(int newOId) {
		oId = newOId;
	}

	/** @pdOid 80f12eb2-0a1e-4c45-ad5c-5971e74c15f3 */
	public int getAId() {
		return aId;
	}

	/**
	 * @param newAId
	 * @pdOid ed25ce1d-ffa6-438a-90a8-5e7936ef815d
	 */
	public void setAId(int newAId) {
		aId = newAId;
	}

	/** @pdOid 29bc755e-6619-4cd0-acf1-332ac6ec9473 */
	public String getOppenId() {
		return oppenId;
	}

	/**
	 * @param newOppenId
	 * @pdOid 7766e5b6-f505-4a3d-8896-40537fd26335
	 */
	public void setOppenId(String newOppenId) {
		oppenId = newOppenId;
	}

	/** @pdOid edccf3ab-173f-4789-bfb2-2f62b9be2e96 */
	public String getATelephone() {
		return aTelephone;
	}

	/**
	 * @param newATelephone
	 * @pdOid 597b040a-e9bd-4789-ab67-7339b1bcb94c
	 */
	public void setATelephone(String newATelephone) {
		aTelephone = newATelephone;
	}

	/** @pdOid 767cf5f6-5955-4888-8207-c0071fb23b4f */
	public String getAProvice() {
		return aProvice;
	}

	/**
	 * @param newAProvice
	 * @pdOid 22280a10-0bdf-40b7-bfe3-217da7c2ace3
	 */
	public void setAProvice(String newAProvice) {
		aProvice = newAProvice;
	}

	/** @pdOid 7c7ee0c0-4d7d-4b9c-b2ae-a7fe2311f7fd */
	public String getACity() {
		return aCity;
	}

	/**
	 * @param newACity
	 * @pdOid ef607198-5ce9-4c30-9e5d-507bda35e955
	 */
	public void setACity(String newACity) {
		aCity = newACity;
	}

	/** @pdOid 52a23ce7-834b-4236-81c5-6f16d0f586e3 */
	public List<OrderDetail> getListDetal() {
		return listDetal;
	}

	/**
	 * @param newListDetal
	 * @pdOid c1d0646d-b989-49b2-9f6f-6fcde8b3f5b6
	 */
	public void setListDetal(List<OrderDetail> newListDetal) {
		listDetal = newListDetal;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getaDetail() {
		return aDetail;
	}

	public void setaDetail(String aDetail) {
		this.aDetail = aDetail;
	}

	public List<Product> getProducts() {
		return Products;
	}

	public void setProducts(List<Product> products) {
		Products = products;
	}

}