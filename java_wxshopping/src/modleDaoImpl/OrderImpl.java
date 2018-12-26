/***********************************************************************
 * Module:  OrderImpl.java
 * Author:  Administrator
 * Purpose: Defines the Class OrderImpl
 ***********************************************************************/

package modleDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMysql;
import modle.Order;
import modle.OrderDetail;
import modle.Product;

/** @pdOid d82c4068-5e8f-426d-888e-4fe1d92be9f0 */
public class OrderImpl implements dao.OrderDao {
	/** @pdOid 2ba0398e-9fa7-4e9f-b027-ba5b8f046405 */
	private Connection con;
	/** @pdOid 67350bc9-827b-4ba8-aa67-7593455849bb */
	private PreparedStatement psmt;
	/** @pdOid a709cee4-325f-4ebb-9f19-e870e041f1e4 */
	private String sql;
	/** @pdOid 269854e3-61db-4392-a281-f10fb45538eb */
	private ResultSet rs;

	/**
	 * @param poducts
	 * @param oppenId
	 * @pdOid 54fd05d2-5cf2-4b0c-b8ce-121a982ff21f
	 */
	public boolean addOrder(Order order, String openId) {
		// TODO: implement
		con = ConnectionMysql.getConnection();
		sql = "insert into order_info (a_id,o_date,o_status,u_oppenId) value(?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, order.getAId());
			psmt.setString(2, order.getDate());
			psmt.setString(3, order.getStatus());
			psmt.setString(4, order.getOppenId());
			boolean flag = true;
			while (flag) {
				int a = psmt.executeUpdate();
				flag = a > 0 ? false : true;
			}
			if (!flag) {
				String sql1 = "select o_id from order_info where u_oppenId=? order by o_id desc limit 1";
				PreparedStatement psmt1 = con.prepareStatement(sql1);
				psmt1.setString(1, openId);
				rs = psmt1.executeQuery();
				int o_id = 0;
				while (rs.next()) {
					o_id = rs.getInt("o_id");
				}
				String sql2 = "insert into order_detail (o_id,p_id,od_num) value(?,?,?)";
				PreparedStatement psmt2 = con.prepareStatement(sql2);
				for (int i = 0; i < order.getListDetal().size(); i++) {
					OrderDetail od = order.getListDetal().get(i);
					psmt2.setInt(1, o_id);
					psmt2.setInt(2, od.getPId());
					psmt2.setInt(3, od.getPNum());
					int a = psmt2.executeUpdate();
					if (a<=0) {
						i--;
					}
				}
				psmt2.close();
				rs.close();
				psmt1.close();
			}
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

		return true;
	}

	/** @pdOid e10f9677-eeff-47b3-9bad-33ab8a8556f7 */
	public List<Order> findOrders() {
		// TODO: implement
		return null;
	}

	/**
	 * @param oppenId
	 * @pdOid 05d84219-6ace-4d25-a4d1-97cf616be47e
	 */
	
	public List<Order> findOrders(String openId) {
		// TODO: implement
		List<Order> orderList=new ArrayList<>();
		sql="select * from order_info where u_oppenId=? order by o_id desc";
		con=ConnectionMysql.getConnection();
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, openId);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Order order=new Order();
				order.setOId(rs.getInt("o_id"));
				order.setDate(rs.getString("o_date"));
				order.setStatus(rs.getString("o_status"));
				sql="select * from address_info where a_id=?";
				PreparedStatement psmt1=con.prepareStatement(sql);
				psmt1.setInt(1, rs.getInt("a_id"));
				ResultSet rs1=psmt1.executeQuery();
				while(rs1.next()) {
					order.setName(rs1.getString("a_name"));
					order.setATelephone(rs1.getString("a_telephone"));
					order.setAProvice(rs1.getString("a_provice"));
					order.setACity(rs1.getString("a_city"));
					order.setCounty(rs1.getString("a_county"));
					order.setaDetail(rs1.getString("a_detail"));
				}
				rs1.close();
				psmt1.close();
				sql="select * from order_detail where o_id=?";
				PreparedStatement psmt2=con.prepareStatement(sql);
				psmt2.setInt(1, rs.getInt("o_id"));
				ResultSet rs2=psmt2.executeQuery();
				List<Product> products=new ArrayList<>();
				while(rs2.next()) {
					sql="select * from Products_info where p_id=?";
					PreparedStatement psmt3=con.prepareStatement(sql);
					psmt3.setInt(1, rs2.getInt("p_id"));	
					ResultSet rs3=psmt3.executeQuery();
					Product p=new Product();
					while(rs3.next()) {
						p.setPId(rs3.getInt("p_id"));
						p.setPName(rs3.getString("p_name"));
						p.setPInfo(rs3.getString("p_info"));
						//p.setRDate(rs3.getString("r_date"));
						//p.setPDetail(rs3.getString("p_detail"));
						p.setpPic1(rs3.getString("p_pic1"));
//						p.setpPic2(rs3.getString("p_pic2"));
//						p.setpPic3(rs3.getString("p_pic3"));
//						p.setpPic4(rs3.getString("p_pic4"));
//						p.setpPic5(rs3.getString("p_pic5"));
						p.setPPrice(rs3.getInt("p_price"));
						p.setPNum(rs2.getInt("od_num"));
						p.setPDetail(order.getStatus());
					}
					products.add(p);
					rs3.close();
					psmt3.close();
				}
				order.setProducts(products);
				orderList.add(order);
				psmt2.close();
				rs2.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orderList;
	}

	/**
	 * @param order
	 * @pdOid fd038a4c-4e43-43b2-8b1d-31396a011b18
	 */
	public boolean updateOrder(Order order) {
		// TODO: implement
		return false;
	}

	@Override
	public List<Product> getHotProducts() {
		// TODO Auto-generated method stub
		List<Product> listProducts=new ArrayList<>();
		con=ConnectionMysql.getConnection();
		sql="SELECT p_id,sum(order_detail.od_num) as allnum from order_detail GROUP BY p_id ORDER BY allnum DESC LIMIT 0, 10";
		try {
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			PreparedStatement psmt1=null;
			ResultSet rs1=null;
			while(rs.next()) {
				sql="select * from products_info where p_id=?";
				psmt1=con.prepareStatement(sql);
				psmt1.setInt(1, rs.getInt("p_id"));
				rs1=psmt1.executeQuery();
				while(rs1.next()) {
					Product p=new Product();
					p.setPId(rs1.getInt("p_id"));
					p.setPName(rs1.getString("p_name"));
					p.setPInfo(rs1.getString("p_info"));
//					p.setRDate(rs1.getString("r_date"));
//					p.setPDetail(rs1.getString("p_detail"));
					p.setpPic1(rs1.getString("p_pic1"));
//					p.setpPic2(rs1.getString("p_pic2"));
//					p.setpPic3(rs1.getString("p_pic3"));
//					p.setpPic4(rs1.getString("p_pic4"));
//					p.setpPic5(rs1.getString("p_pic5"));
					p.setPPrice(rs1.getInt("p_price"));
					p.setPNum(rs1.getInt("p_num"));
					p.setPDiscunt(rs1.getInt("p_discount"));
					listProducts.add(p);
				}
			}
			rs1.close();
			psmt1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listProducts;
	}

}