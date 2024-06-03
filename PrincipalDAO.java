package com.example;
// 其他的 import 语句和类定义

import java.util.*;
import java.sql.*;

public class PrincipalDAO {
    Connection con = DBConn.getConn();
    public Vector<Vector<Object>> allImformation() {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        try {
            Statement s = con.createStatement();
            String sql = "select * from 负责人";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Vector<Object> newItem = new Vector<Object>();
                newItem.add(rs.getInt("负责人工号"));
                newItem.add(rs.getString("姓名"));
                newItem.add(rs.getString("性别"));
                newItem.add(rs.getString("联系方式"));
                newItem.add(rs.getInt("仓库编号"));
                data.add(newItem);
                //System.out.println(newItem);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void insert(int work_number, String name, String sex,String contact_way,int whid) {
        String sql = "insert into 负责人 values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, work_number);
            ps.setString(2, name);
            ps.setString(3, sex);
            ps.setString(4, contact_way);
            ps.setInt(5, whid);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int whid) {
        String sql = "delete from 负责人 where whid=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, whid);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 更新负责人信息的方法
    public void update(int work_number, String name, String sex, String contact_way, int whid) {
        String sql = "update 负责人 set 姓名 = ?, 性别 = ?, 联系方式 = ?, 仓库编号 = ? where 负责人工号 = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, contact_way);
            ps.setInt(4, whid);
            ps.setInt(5, work_number);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}