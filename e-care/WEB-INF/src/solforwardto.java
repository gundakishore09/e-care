import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class solforwardto extends HttpServlet
{

    public solforwardto()
    {
        fid = "F001";
        ffrom = "f001";
        fto = "";
        status = "";
        level = "";
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver is created");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            System.out.println("Connection is created");
            st = con.createStatement();
            System.out.println("statement is created");
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException, NumberFormatException
    {
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s = httpservletrequest.getParameter("ftickno");
        int j = Integer.parseInt(s);
        level = httpservletrequest.getParameter("levelsel");
        fto = httpservletrequest.getParameter("user");
        try
        {
            i = st.executeUpdate("insert into forward values('" + j + "','" + ffrom + "','" + fto + "','" + status + "')");
            printwriter.println("<html>");
            printwriter.println("<body>Succesfully eI Val is " + i);
            printwriter.println("PROBLEM WITH TICKET ID " + j + "    IS FORWARDED TO    " + fto + "  IN LEVEL NO   :" + level);
            printwriter.println("</body></html>");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
    String fid;
    String ffrom;
    String fto;
    String status;
    String level;
    int i;
}