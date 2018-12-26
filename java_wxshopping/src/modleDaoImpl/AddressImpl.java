/***********************************************************************
 * Module:  AddressImpl.java
 * Author:  Administrator
 * Purpose: Defines the Class AddressImpl
 ***********************************************************************/

package modleDaoImpl;

import modle.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import connection.ConnectionMysql;

/** @pdOid 672537ae-47d6-4777-a834-e93c0238d2a1 */
public class AddressImpl implements dao.AddressDao {
   /** @pdOid 107711ff-361d-453c-bcca-baf9523ed0ff */
   private Connection con;
   /** @pdOid 63e2778c-bd81-4222-9c09-447cdeb71862 */
   private PreparedStatement psmt;
   /** @pdOid d7e64683-13bf-4f8c-8693-fb9375d0b584 */
   private String sql;
   /** @pdOid 3209e145-2fa5-4700-b659-ab1413658f1a */
   private ResultSet rs;
   
   /** @param oppenId
    * @pdOid 4c5a033b-ee87-4748-97cd-06d15f2b789b */
   public List<Address> getAddress(String oppenId) {
      // TODO: implement
	   List<Address> listAddress=new ArrayList<Address>();
	   con=ConnectionMysql.getConnection();
	   sql="select * from address_info where u_oppenid=? and (a_default=? or a_default=?)";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, oppenId);
		psmt.setInt(2, 0);
		psmt.setInt(3, 1);
		rs=psmt.executeQuery();
		while(rs.next()) {
			Address address=new Address();
			address.setAId(rs.getInt("a_id"));
			address.setName(rs.getString("a_name"));
			address.setTelephone(rs.getString("a_telephone"));
			address.setProvice(rs.getString("a_provice"));
			address.setCity(rs.getString("a_city"));
			address.setCounty(rs.getString("a_county"));
			address.setDetail(rs.getString("a_detail"));
			address.setDefaultAdress(rs.getInt("a_default"));
			listAddress.add(address);
		}
		rs.close();
		psmt.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return listAddress;
   }
   
   /** @param address
    * @pdOid 652dee35-1c79-4225-aea7-649ba072d3a8 */
   public boolean updateAddress(Address address) {
      // TODO: implement
	   boolean flag=false;
	   con=ConnectionMysql.getConnection();
	   sql="update address_info  set a_name=?,a_telephone=?,a_provice=?,a_city=?,a_county=?,"
	   		+ "a_detail=?,a_default=? where a_id=? and u_oppenid=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, address.getName());
		psmt.setString(2, address.getTelephone());
		psmt.setString(3, address.getProvice());
		psmt.setString(4, address.getCity());
		psmt.setString(5, address.getCounty());
		psmt.setString(6, address.getDetail());
		psmt.setInt(7, address.getDefaultAdress());
		psmt.setInt(8, address.getAId());
		psmt.setString(9, address.getOppenid());
		flag=psmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
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
   
   /** @param aId
    * @pdOid 7caa0cc2-ab3c-4313-b59a-65939caa3c6f */
   public boolean deleteAddress(int aId) {
      // TODO: implement
	   boolean flag=false;
	   con=ConnectionMysql.getConnection();
	   sql="update address_info  set a_default=? where a_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, 3);
		psmt.setInt(2, aId);
		flag=psmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
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
   
   /** @param address
    * @pdOid 189e45cb-60ae-475a-81c3-73252cd122ca */
   public boolean addAddress(Address address) {
      // TODO: implement
	  int temp=0;
	  con=ConnectionMysql.getConnection();
	  sql="insert into address_info (u_oppenid,a_name,a_telephone,a_provice,a_city,a_county,a_detail,a_default) value (?,?,?,?,?,?,?,?)";
	  try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, address.getOppenid());
		psmt.setString(2, address.getName());
		psmt.setString(3, address.getTelephone());
		psmt.setString(4, address.getProvice());
		psmt.setString(5, address.getCity());
		psmt.setString(6, address.getCounty());
		psmt.setString(7, address.getDetail());
		psmt.setInt(8, address.getDefaultAdress());
		temp=psmt.executeUpdate();
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
      return temp>0?true:false;
   }

}