package ex01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex01.Member;

public class DatabaseServiceImpl implements DatabaseService{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.0.14:1521:xe";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String user = "java001";
	private String pwd = "1234";
	
	public DatabaseServiceImpl() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean insert(Member member) {
		System.out.println("======insert=====");
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println("=====insert======");
		String sql = "insert into member(id, pw, name, gender, age, hobby) values(?, ?, ?, ?, ?, ?)";
		int gender = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPw());
			ps.setString(3,  member.getName());
			if(member.isGender()) {
				gender = 0;
			}else {
				gender = 1;
			}
			ps.setInt(4,  gender);
			ps.setString(5,  member.getAge());
			ps.setInt(6,  member.getHobby());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Member select(String id) {
		String sql = "select * from member where id=?";
		Member member = null;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	
	}

}
