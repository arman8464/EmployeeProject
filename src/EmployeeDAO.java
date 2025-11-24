import java.sql.*;

public class EmployeeDAO {

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ems?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "root123"
        );
    }

    // Insert employee
    public void addEmployee(Employee e) {
        try {
            Connection con = getConnection();
            String q = "INSERT INTO employees VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setDouble(3, e.getSalary());
            ps.setString(4, e.getDepartment());
            ps.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    // View all employees
    public void viewEmployees() {
        try {
            Connection con = getConnection();
            String q = "SELECT * FROM employees";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);

            while(rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDouble(3) + " | " +
                    rs.getString(4)
                );
            }

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    // Update salary
    public void updateSalary(int id, double salary) {
        try {
            Connection con = getConnection();
            String q = "UPDATE employees SET salary = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setDouble(1, salary);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Salary updated!");
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    // Delete employee
    public void deleteEmployee(int id) {
        try {
            Connection con = getConnection();
            String q = "DELETE FROM employees WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employee deleted!");
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    // Search employee by ID
    public void searchEmployee(int id) {
        try {
            Connection con = getConnection();
            String q = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDouble(3) + " | " +
                    rs.getString(4)
                );
            } else {
                System.out.println("Employee not found!");
            }

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}