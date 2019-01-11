import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class Main {
	
	private final String mysql_username = "giris_sistemi";
	private final String mysql_password = "sifre123";
	private final String url = "jdbc:mysql://localhost:3306/kullanici_giris";
	private Connection myconn = null;
	private Statement mystmt = null;
	private JLabel info_label = null;
	
	public Main(JLabel info_label) {
		this.info_label = info_label;
	}
	
	public void mysql_settings() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			myconn = DriverManager.getConnection(url, mysql_username, mysql_password); //MySQL'i atıyoruz.
			mystmt = myconn.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void register(String username,String password) {
		
		try {
			if ((username != null) && (password !=null)) { //Eğer username ve password boş değilse.
				ResultSet rs;
				PreparedStatement st = myconn.prepareStatement("SELECT * FROM hesaplar WHERE username=?");
				st.setString(1, username);
				rs = st.executeQuery();
				boolean check = false;
				while(rs.next()) { //SQL'de WHERE yazdığım için bir tane değer dönecek. O yüzden programı yavaşlatmaz.
					if (rs.getString("username").equals(username)) {
						check = true;
					}
				}
				if (check == false) {
					st = myconn.prepareStatement("INSERT INTO hesaplar (username,password) VALUES (?,?)");
					st.setString(1, username);
					st.setString(2, password);
					st.executeUpdate();
					info_label.setText("Register succesfully!");
				}
				else {
					info_label.setText("Already there is an username like this.");
				}
			}
		}
		catch(SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	public void login(String username,String password) {
		try {
			if ((username != null) && (password !=null)) { // Eğer username ve password boş değilse.
				ResultSet rs;
				
				PreparedStatement st = myconn.prepareStatement("SELECT * FROM hesaplar WHERE username=? AND password=?");
				st.setString(1,username);
				st.setString(2, password);
				rs = st.executeQuery();
				
				int sayac = 0;
	
				while(rs.next()) {
					++sayac;
				}
				if (sayac == 1) {
					info_label.setText("Login succesfully!");
				}
				else {
					info_label.setText("Invalid username or password.");
				}
			}
		}
		catch(SQLException exc) {
			exc.printStackTrace();
		}
	}
	

}
