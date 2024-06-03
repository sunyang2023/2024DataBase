package com.example;

import java.util.Vector;

import javax.swing.JFrame;

public class MainFrame {
    public static void main(String[] args)throws Exception {
        JFrame f = new JFrame("负责人界面");
        PrincipalDAO principalDAO = new PrincipalDAO();
        principalDAO.insert(20031015, "孙燕姿", "女","198198198198",9001);
        principalDAO.insert(20041014, "陈奕迅", "男","22222222@qq.com",9002);
        Vector<Vector<Object>> show = principalDAO.allImformation();
        principalDAO.delete(9001);
        principalDAO.update(20041014, "陈奕迅", "男","22222222@qq.com",9001);
        principalDAO.allImformation();
        System.out.println(show);
    }
}