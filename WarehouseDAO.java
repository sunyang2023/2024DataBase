import java.util.*;
import java.sql.*;

public class WarehouseDAO {
	Connection con = DBConn.getConn();
	public Vector<Vector<Object>> allImformation() {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		try {
			Statement s = con.createStatement();
			String sql = "select * from 仓库";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Vector<Object> newItem = new Vector<Object>();
				newItem.add(rs.getInt("仓库编号"));
				newItem.add(rs.getInt("区域id"));
				newItem.add(rs.getString("仓库名称"));
				data.add(newItem);
				//System.out.println(newItem);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return data; 
	}
	
	public void insert(int whid, int areaid, String name) {
		String sql = "insert into 仓库 values(?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, whid);
			ps.setInt(2, areaid);
			ps.setString(3, name);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int whid) {
		String sql = "delete from 仓库 where whid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, whid);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
