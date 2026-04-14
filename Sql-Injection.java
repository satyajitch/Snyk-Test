import java.sql.*;

public class VulnerableSQL {
    public static void main(String[] args) throws Exception {
        String userInput = "' OR '1'='1"; // attacker input

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "password");

        Statement stmt = conn.createStatement();

        // ❌ Vulnerable query
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("User: " + rs.getString("username"));
        }
    }
}
