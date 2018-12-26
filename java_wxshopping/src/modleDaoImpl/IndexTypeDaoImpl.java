/***********************************************************************
 * Module:  IndexTypeDaoImpl.java
 * Author:  Administrator
 * Purpose: Defines the Class IndexTypeDaoImpl
 ***********************************************************************/

package modleDaoImpl;

import modle.IndexDetail;
import modle.IndexType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import connection.ConnectionMysql;

/** @pdOid 68988ff7-00e4-4426-be3f-53839f34ef8e */
public class IndexTypeDaoImpl implements dao.IndexTypeDao {
   /** @pdOid 63745775-f840-4727-9ca1-5bbc5e96637f */
   private Connection con;
   /** @pdOid 68678f4a-4a41-45b5-a620-961c8b1799c7 */
   private PreparedStatement psmt;
   /** @pdOid 40b117b4-aec2-4e04-9604-71e11a0dab48 */
   private String sql;
   /** @pdOid 8cc2ce1d-3498-4837-b399-4cd4153ff0ae */
   private ResultSet rs;
   
   /** @pdOid 4082a2be-9178-4cc0-a08c-605e1d729fa5 */
   public List<IndexType> getAll() {
      // TODO: implement
	   con=ConnectionMysql.getConnection();
	   List<IndexType> indexTypeList=new ArrayList<>();
	   try {
		sql="Select * from index_type";
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		while(rs.next()) {
			IndexType it=new IndexType();
			it.setItId(rs.getInt("it_id"));
			it.setItImage(rs.getString("it_image"));
			it.setItName(rs.getString("it_name"));
				String sql1="select * from index_detail where it_id=?";
				PreparedStatement psmt1=con.prepareStatement(sql1);
				psmt1.setInt(1, it.getItId());
				ResultSet rs1=psmt1.executeQuery();
				List<IndexDetail> IndexDetailList=new ArrayList<>();
				while(rs1.next()) {
					IndexDetail id =new IndexDetail();
					id.setIdId(rs1.getInt("id_id"));
					id.setItId(rs1.getInt("it_id"));
					id.setIdName(rs1.getString("id_name"));
					id.setIdImage(rs1.getString("id_image"));
					IndexDetailList.add(id);
				}
			it.setListId(IndexDetailList);
			indexTypeList.add(it);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return indexTypeList;
   }
   
   /** @param itId 
    * @param indexType
    * @pdOid d60d4706-9b0a-49ab-aa5f-13c8911bbeae */
   public boolean updateIndexType(int itId, IndexType indexType) {
      // TODO: implement
      return false;
   }

}