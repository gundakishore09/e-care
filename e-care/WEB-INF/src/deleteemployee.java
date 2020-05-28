
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class deleteemployee extends HttpServlet
{

    public deleteemployee()
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
        String s11 = "";
        boolean flag = false;
        boolean flag1 = false;
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            String s1 = httpservletrequest.getParameter("l");
            System.out.println("levelname is" + s1);
            String s3 = httpservletrequest.getParameter("c");
            System.out.println("categoryid is" + s3);
            String s5 = httpservletrequest.getParameter("m");
            System.out.println("moduleid is" + s5);
            String s7 = httpservletrequest.getParameter("s");
            System.out.println("supportid is" + s7);
            String s9 = httpservletrequest.getParameter("u");
            System.out.println("id is" + s9);
            int i = st.executeUpdate("delete from hdemp1 where user_id='" + s9 + "'");
            System.out.println("Deleted:" + i);
            httpservletresponse.sendRedirect("./employee");
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