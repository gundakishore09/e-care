import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class updatecategory1 extends HttpServlet
{

    public updatecategory1()
    {
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            System.out.println("inside init");
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
        System.out.println("This is my service");
        String s = "";
        String s2 = "";
        String s4 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        s6 = (String)httpsession.getValue("co");
        s7 = (String)httpsession.getValue("na");
        s8 = (String)httpsession.getValue("ss");
        try
        {
            String s1 = httpservletrequest.getParameter("text1");
            String s3 = httpservletrequest.getParameter("text2");
            String s5 = httpservletrequest.getParameter("text3");
            System.out.println("code iiiiis" + s1);
            System.out.println("cname iss" + s3);
            System.out.println("status iss" + s5);
            int i = st.executeUpdate("update categoryies set categoryname='" + s3 + "',status='" + s5 + "' where categoryid='" + s1 + "'");
            System.out.println("update categoryies set categoryname='" + s3 + "' where categorycode='" + s1 + "'");
            System.out.println(i + " is updated");
            httpservletresponse.sendRedirect("./categories");
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