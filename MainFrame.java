import java.sql.*;
import java.util.Vector;

import javax.swing.JFrame;

public class MainFrame {
	public static void main(String[] args)throws Exception {
		JFrame f = new JFrame("仓库管理");
		WarehouseDAO warehouseDAO = new WarehouseDAO();
		warehouseDAO.insert(9001, 1, "测试仓库2");
		Vector<Vector<Object>> show = warehouseDAO.allImformation();
		System.out.println(show);
	}
}
