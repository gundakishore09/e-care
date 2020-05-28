import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class compose1 extends HttpServlet
{

    public compose1()
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
        int i = 0;
        int j = 0;
        int k = 0;
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        try
        {
            String s = httpservletrequest.getParameter("select1");
            System.out.println("To name is:" + s);
            String s1 = httpservletrequest.getParameter("from");
            System.out.println("from name is:" + s1);
            String s2 = httpservletrequest.getParameter("subject");
            System.out.println("subject is:" + s2);
            String s3 = httpservletrequest.getParameter("compose1");
            System.out.println("description is:" + s3);
            String s5 = httpservletrequest.getParameter("day");
            int l = Integer.parseInt(s5);
            String s6 = httpservletrequest.getParameter("month");
            String s7 = httpservletrequest.getParameter("year");
            int i1 = Integer.parseInt(s7);
            String s4 = l + "/" + s6 + "/" + i1;
            if(s.equals("superuser"))
                i = st.executeUpdate("insert into hdmessages values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')");
            else
            if(s.equals("level2"))
            {
                System.out.println("second level admin");
                j = st.executeUpdate("insert into level2messages values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')");
            } else
            if(s.equals("level3"))
                k = st.executeUpdate("insert into level3messages values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')");
            else
            if(s.equals("all"))
            {
                i = st.executeUpdate("insert into hdmessages values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')");
                j = st.executeUpdate("insert into level2messages values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')");
                k = st.executeUpdate("insert into level3messages values('" + s + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')");
            }
            System.out.println("After query");
            if(i == 1 || j == 1 || k == 1)
                httpservletresponse.sendRedirect("./messageconfirm1.html");
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