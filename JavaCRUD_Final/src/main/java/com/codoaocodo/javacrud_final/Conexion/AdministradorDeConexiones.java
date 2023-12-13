/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codoaocodo.javacrud_final.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author leanm
 */
public class AdministradorDeConexiones {
    	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/oradores";
		String username = "root";
		String password = "admin";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		Connection con = null;
		try {
			Class.forName(driverName);//carga en memoria el Driver
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();//muestra la excepción y el error
		}
                finally{
                    return con;
                }
	}
	
	public static void main(String[] args) {
		Connection con = AdministradorDeConexiones.getConnection();//f5
		if(con != null) {
			System.out.println("Conexion ok");
		}else {
			System.err.println("Conexion fail");
		}
	}
}
