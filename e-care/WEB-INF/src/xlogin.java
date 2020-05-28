import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class xlogin extends HttpServlet
{

    public xlogin()
    {
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        boolean flag = true;
        httpservletresponse.setContentType("text/html");
        PrintWriter printwriter = httpservletresponse.getWriter();
        String s = httpservletrequest.getParameter("logtxt");
        String s1 = httpservletrequest.getParameter("pwd");
        printwriter.println("in the welcome page");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
            Statement statement = con.createStatement();
            ResultSet resultset;
            for(resultset = statement.executeQuery("select * from login"); resultset.next();)
                if(s.equals(resultset.getString(1)) && s1.equals(resultset.getString(2)))
                {
                    System.out.println("authorised user");
                    flag = false;
                }

            if(flag)
                System.out.println("not authorised user");
            resultset.close();
            statement.close();
            con.close();
        }
        catch(Exception exception)
        {
            System.out.println("some problem with databse" + exception);
        }
    }
}