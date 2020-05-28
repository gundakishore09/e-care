
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class addemployee1 extends HttpServlet
{

    public addemployee1()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside try");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
            st = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        String s = "";
        String s2 = "";
        String s4 = "";
        String s6 = "";
        String s8 = "";
        String s10 = "";
        String s12 = "";
        String s14 = "";
        String s16 = "";
        String s18 = "";
        String s20 = "";
        String s22 = "";
        String s24 = "";
        String s26 = "";
        String s28 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            String s1 = httpservletrequest.getParameter("levelname");
            System.out.println("name is " + s1);
            String s17 = httpservletrequest.getParameter("categoryid");
            System.out.println("catid is " + s17);
            String s19 = httpservletrequest.getParameter("moduleid");
            System.out.println("modid is " + s19);
            String s11 = httpservletrequest.getParameter("supportid");
            System.out.println("supid is " + s11);
            String s3 = httpservletrequest.getParameter("userid");
            System.out.println("uid is " + s3);
            String s21 = httpservletrequest.getParameter("employeename");
            System.out.println("employeename is " + s21);
            String s5 = httpservletrequest.getParameter("address");
            System.out.println("address is " + s5);
            String s7 = httpservletrequest.getParameter("city");
            System.out.println("city is " + s7);
            String s9 = httpservletrequest.getParameter("state");
            System.out.println("state is " + s9);
            String s13 = httpservletrequest.getParameter("country");
            System.out.println("country is " + s13);
            String s30 = httpservletrequest.getParameter("zipcode");
            int j = Integer.parseInt(s30);
            System.out.println("zipcode is " + j);
            String s31 = httpservletrequest.getParameter("phoneno");
            int i = Integer.parseInt(s31);
            System.out.println("phonenumber is " + i);
            System.out.println("hello");
            String s15 = httpservletrequest.getParameter("email");
            System.out.println("email is " + s15);
            String s23 = httpservletrequest.getParameter("password1");
            System.out.println("password is " + s23);
            String s29 = httpservletrequest.getParameter("password2");
            System.out.println("password is " + s29);
            String s25 = httpservletrequest.getParameter("hintquestion");
            System.out.println("hintqt is " + s25);
            String s27 = httpservletrequest.getParameter("hintsolution");
            System.out.println("hintsol is " + s27);
            System.out.println("Before inserting");
            int k = st.executeUpdate("insert into hdemp1 values('" + s1 + "','" + s17 + "','" + s19 + "','" + s11 + "','" + s3 + "','" + s21 + "','" + s5 + "','" + s7 + "','" + s9 + "','" + s13 + "'," + j + "," + i + ",'" + s15 + "','" + s23 + "','" + s29 + "','" + s25 + "','" + s27 + "')");
            System.out.println(k + " One row is inserted");
            httpservletresponse.sendRedirect("./employeeconfirmed.html");
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    Connection con;
    Statement st;
    ResultSet rs;
}