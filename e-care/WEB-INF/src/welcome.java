import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

class welcome extends HttpServlet
{

    welcome()
    {
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        httpservletresponse.setContentType("text/html");
        java.io.PrintWriter printwriter = httpservletresponse.getWriter();
        String s = httpservletrequest.getParameter("text1");
        String s1 = httpservletrequest.getParameter("password1");
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
                    System.out.println("accepted");
                else
                    System.out.println("access denied");

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