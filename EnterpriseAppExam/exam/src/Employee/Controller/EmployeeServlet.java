package Employee.Controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeServlet extends HttpServlet {

        public void init() throws ServletException {
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Deletion
            String emp_no = request.getParameter("emp_no");
            String cmd = request.getParameter("cmd");

            // Insertion
            String first_name = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String gender = request.getParameter("gender");



            // Set response content type
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();


            // Insertion
            out.println(first_name+"<br/>");
            out.println(lastName+"<br/>");
            out.println(gender+"<br/>");

            Context envContext = null;
            try {
                envContext = new InitialContext();
                out.println(envContext+"<br>");

                Context initContext = envContext;

                DataSource ds = (DataSource)envContext.lookup("java:/comp/env/jdbc/employees");
                Connection con = ds.getConnection();


                String sql = "";
                if (cmd != null && cmd.equals("d")) {
                    // Delete
                    sql = "DELETE FROM employees WHERE emp_no = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setInt(1, Integer.parseInt(emp_no));
                    stmt.execute();
                } else if (cmd != null && cmd.equals("u")) {
                    // Update
                    sql = "UPDATE employees SET fist_name = ?, last_name = ?, gender = ? WHERE emp_no = ?";
                    PreparedStatement stmt=con.prepareStatement(sql);
                    stmt.setString(1,first_name);
                    stmt.setDouble(2,Double.parseDouble(lastName));
                    stmt.setString(3,gender);
                    stmt.setInt(4,Integer.parseInt(emp_no));
                    stmt.execute();

                } else {
                    // Insert
                    sql = "insert into employees (first_name ,last_name,gender,emp_no)  values (?,?,?,?)";
                    PreparedStatement stmt=con.prepareStatement(sql);
                    stmt.setString(1,first_name);
                    stmt.setDouble(2,Double.parseDouble(lastName));
                    stmt.setString(3,gender);
                    stmt.execute();
                }
//            out.println("Row affect "+r+"<br>");
                response.sendRedirect("Employees.jsp");

            }  catch (SQLException | NamingException e) {
                e.printStackTrace();
                out.print(e);
            }
        }

        public void destroy() {

        }
    }

