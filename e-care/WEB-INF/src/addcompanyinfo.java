
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class addcompanyinfo extends HttpServlet
{

    public addcompanyinfo()
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
        String s3 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        HttpSession httpsession = httpservletrequest.getSession(true);
        httpservletresponse.setContentType("text/html");
		s3 = (String)httpsession.getValue("uid");
        System.out.println("Session uid is " + s3);
        try
        {
            String s = httpservletrequest.getParameter("text1");
            String s1 = httpservletrequest.getParameter("text2");
            String s2 = httpservletrequest.getParameter("text3");
            System.out.println("Before inserting");
            int i = st.executeUpdate("insert into hdcompanyinfo(LOCATION_ID,LOCATION_NAME,COMPANY_NAME, USER_ID)  values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "')");

            System.out.println(i + " One row is inserted in hdcompanyinfo");
	

            System.out.println("After query");
            httpservletresponse.sendRedirect("./companyinfoconfirmed.html");
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