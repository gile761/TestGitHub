package kame.ch22.ex01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ch22Ex01 {

	public static void main(String[] args) {
		String driver = "org.git.mm.mysql.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "1234";
		Connection con = null;
		Statement stmt = null;
		
		String sql;
		ResultSet rs = null;
		
		try{
			Class.forName(driver);
			con = DriverMan
		}
		
		
	}

}
