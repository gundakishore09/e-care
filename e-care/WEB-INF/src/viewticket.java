import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class viewticket extends HttpServlet
{

    public viewticket()
    {
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
        throws ServletException, IOException
    {
        String s = "";
        String s1 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s2 = httpservletrequest.getParameter("tickno");
        int i = Integer.parseInt(s2);
        try
        {
            for(rs = st.executeQuery("select * from problemhistory where ticket=" + i); rs.next();)
            {
                s = rs.getString(3);
                s1 = rs.getString(4);
            }

            printwriter.println("<html>");
            printwriter.println("<center><h1><font color=forestgreen>HD Problem Desk</h1>");
            printwriter.println("<body>");
            printwriter.println("<form> ");
            printwriter.println("<TABLE bgcolor=white border=0 cellPadding=1 cellSpacing=1 width=80% align=center>");
            printwriter.println("<P>");
            printwriter.println(" <Tr> ");
            printwriter.println(" <TD>Ticket</TD><td>" + i + "</td></tr>");
            printwriter.println(" <tr><TD>Problem Desc</td>");
            printwriter.println("<td><textarea name=probdesc id=probdesc>" + s + "</textarea></td></tr>");
            printwriter.println("<tr><TD>Problem Solution</td>");
            printwriter.println("<td>" + s1 + "</td></tr>");
            printwriter.println("<td><a href=./viewproblem>Back</a></td></tr>");
            printwriter.println("</Table> ");
            printwriter.println("</P> ");
            printwriter.println("</form>");
            printwriter.println("</body>");
            printwriter.println("</html>");
        }
        catch(Exception exception)
        {
            printwriter.println(exception.getMessage());
        }
    }

    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
}