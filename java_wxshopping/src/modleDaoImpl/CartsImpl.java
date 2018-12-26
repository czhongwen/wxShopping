/***********************************************************************
 * Module:  CartsImpl.java
 * Author:  Administrator
 * Purpose: Defines the Class CartsImpl
 ***********************************************************************/

package modleDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMysql;
import modle.Product;

/** @pdOid 9d5fb5aa-73dd-4e08-8eeb-0aa676a57163 */
public class CartsImpl implements dao.CartsDao {
	/** @pdOid 7533bfb4-f451-4836-8178-7c37b6129ffe */
	private Connection con;
	/** @pdOid 2b92ee59-fb48-4f54-b46d-640f1f51eb89 */
	private PreparedStatement psmt;
	/** @pdOid 576bbdca-bf72-40d0-a507-174d588c892a */
	private String sql;
	/** @pdOid 855eceac-6324-464f-a446-3875389a812d */
	private ResultSet rs;

	/**
	 * @param oppenId
	 * @param pId
	 * @param pNum
	 * @pdOid 776f3405-92f1-4b4f-91ed-b57cc14625b8
	 */
	public String addProducts(String oppenId, int[] pIds, int[] pNums) {
		// TODO: implement
		con = ConnectionMysql.getConnection();
		sql = "delete from carts where oppenid=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, oppenId);
			Boolean flag = true;
			while (flag) {
				flag = psmt.execute();
				if (flag) {
					flag = false;
				}
			}
			sql = "insert into carts (p_id,oppenid,p_num) values(?,?,?)";
			PreparedStatement psmt1 = con.prepareStatement(sql);
			for (int i=0 ;i < pIds.length;i++) {
				boolean flag1 = true;
				while (flag1) {
					psmt1.setInt(1, pIds[i]);
					psmt1.setString(2, oppenId);
					psmt1.setInt(3, pNums[i]);
					flag1 = psmt1.execute();
					if(flag1) {
						flag1=false;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param oppenId
	 * @pdOid 7a6622be-7398-45dc-922a-87b02e6d8439
	 */
	public List<Product> findCarets(String oppenId) {
		// TODO: implement
		List<Product> cartsList = new ArrayList<Product>();
		con = ConnectionMysql.getConnection();
		sql = "select p_id,p_num from carts where oppenid=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, oppenId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setPNum(rs.getInt("p_num"));
				sql = "select * from products_info where p_id=?";
				PreparedStatement psmt1 = con.prepareStatement(sql);
				psmt1.setInt(1, rs.getInt("p_id"));
				ResultSet rs1 = psmt1.executeQuery();
				while (rs1.next()) {
					product.setPId(rs1.getInt("p_id"));
					product.setPName(rs1.getString("p_name"));
					product.setPPrice(rs1.getInt("p_price"));
					product.setpPic1(rs1.getString("p_pic1"));
					product.setPInfo(rs1.getString("p_info"));
				}
				cartsList.add(product);
				rs1.close();
				psmt1.close();
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartsList;
	}

	/**
	 * @param oppenId
	 * @param pId
	 * @pdOid 889d61a0-e204-43a6-92b2-0c8f5e768525
	 */
	public boolean deleteProducts(String oppenId, int pId) {
		// TODO: implement
		return false;
	}

}