import java.sql.*;

public class Auth {

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ems?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "root123"
        );
    }

    public boolean login(String uname, String pass) {
        try {
            Connection con = getConnection();
            String q = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // if row exists → login success

        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
}