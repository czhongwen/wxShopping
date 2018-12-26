/***********************************************************************
 * Module:  ProductImpl.java
 * Author:  Administrator
 * Purpose: Defines the Class ProductImpl
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
import until.GetDate;

/** @pdOid 958b8535-b52e-413c-b421-ca9ba6d7abef */
public class ProductImpl implements dao.ProductsDao {
	/** @pdOid cfce3f19-ff6f-4e7e-bf46-c6c91e095cf1 */
	private Connection con;
	/** @pdOid ec97a8b5-000a-4a83-964d-a7ab2faa6d02 */
	private PreparedStatement psmt;
	/** @pdOid d35e901f-9d04-43c9-94f7-34ef65858f06 */
	private String sql;
	/** @pdOid e58e472e-c851-4656-87d4-d6bae2cba99f */
	private ResultSet rs;

	/**
	 * @param products
	 * @pdOid b1149d39-b060-478d-bad5-1750d2e2961a
	 */
	public boolean addProduct(Product product) {
		// TODO: implement
		boolean flag = false;
		con = ConnectionMysql.getConnection();
		sql = "insert into products_info (p_name,p_info,id_id,r_date,p_detail,p_index,p_pic1,p_pic2,p_pic3,p_pic4,p_pic5,p_price,p_num,p_discount) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, product.getPName());
			psmt.setString(2, product.getPInfo());
			psmt.setInt(3, product.getpType());
			psmt.setString(4, GetDate.getDate());
			psmt.setString(5, product.getPDetail());
			psmt.setInt(6, 0);
			psmt.setString(7, product.getpPic1());
			psmt.setString(8, product.getpPic2());
			psmt.setString(9, product.getpPic3());
			psmt.setString(10, product.getpPic4());
			psmt.setString(11, product.getpPic5());
			psmt.setInt(12, product.getPPrice());
			psmt.setInt(13, product.getPNum());
			psmt.setInt(14, 0);
			flag = psmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * @param pId
	 * @pdOid 7cd2aa3f-4ff6-4def-80ac-74842b5023ca
	 */
	public boolean deleteProduct(int pId) {
		// TODO: implement
		return false;
	}

	/**
	 * @param product
	 * @pdOid ec22f49a-daeb-4581-a31c-4e1d21319d74
	 */
	public boolean updateProducts(Product product) {
		// TODO: implement
		return false;
	}

	/** @pdOid 4c777136-715b-47d1-84e9-858d2337693f */
	public List<Product> findProducts() {
		// TODO: implement
		List<Product> listProduct=new ArrayList<Product>();
		con=ConnectionMysql.getConnection();
		sql="select * from products_info";
		try {
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPId(rs.getInt("p_id"));
				p.setPName(rs.getString("p_name"));
				p.setPInfo(rs.getString("p_info"));
				p.setRDate(rs.getString("r_date"));
				p.setPDetail(rs.getString("p_detail"));
				p.setpPic1(rs.getString("p_pic1"));
				p.setpPic2(rs.getString("p_pic2"));
				p.setpPic3(rs.getString("p_pic3"));
				p.setpPic4(rs.getString("p_pic4"));
				p.setpPic5(rs.getString("p_pic5"));
				p.setPPrice(rs.getInt("p_price"));
				p.setPNum(rs.getInt("p_num"));
				p.setPDiscunt(rs.getInt("p_discount"));
				listProduct.add(p);
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listProduct;
	}

	/**
	 * @param key
	 * @pdOid 0e717000-48eb-4ea0-bce4-b638f475e7a5
	 */
	public List<Product> findProductsByKey(int no, String key) {
		// TODO: implement
		return null;
	}

	@Override
	public List<Product> findProductsByType(int no, int typeNum) {
		// TODO Auto-generated method stub
		List<Product> listProducts = new ArrayList<Product>();
		con = ConnectionMysql.getConnection();
		sql = "select p_id,p_name,p_pic1,p_price from products_info where id_id=? limit ?,8";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, typeNum);
			psmt.setInt(2, no);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setPId(rs.getInt("p_id"));
				product.setPName(rs.getString("p_name"));
				product.setpPic1(rs.getString("p_pic1"));
				product.setPPrice(rs.getInt("p_price"));
				listProducts.add(product);
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProducts;
	}

	@Override
	public Product findProductsById(int pId) {
		// TODO Auto-generated method stub
		Product product=new Product();
		con=ConnectionMysql.getConnection();
		sql="select * from products_info where p_id=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, pId);
			rs=psmt.executeQuery();
			while(rs.next()) {
				product.setPId(rs.getInt("p_id"));
				product.setPName(rs.getString("p_name"));
				product.setPInfo(rs.getString("p_info"));
				product.setPDetail(rs.getString("p_detail"));
				product.setpPic1(rs.getString("p_pic1"));
				product.setpPic2(rs.getString("p_pic2"));
				product.setpPic3(rs.getString("p_pic3"));
				product.setpPic4(rs.getString("p_pic4"));
				product.setpPic5(rs.getString("p_pic5"));
				product.setPPrice(rs.getInt("p_price"));
				product.setPDiscunt(rs.getInt("p_discount"));
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> findProducts(int arrs, int typeNum) {
		// TODO Auto-generated method stub
		List<Product> listProducts = new ArrayList<Product>();
		con = ConnectionMysql.getConnection();
		sql = "select p_id,p_name,p_pic1,p_price from products_info where id_id=? limit ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, typeNum);
			psmt.setInt(2, arrs);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setPId(rs.getInt("p_id"));
				product.setPName(rs.getString("p_name"));
				product.setpPic1(rs.getString("p_pic1"));
				product.setPPrice(rs.getInt("p_price"));
				listProducts.add(product);
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listProducts;
	}

}