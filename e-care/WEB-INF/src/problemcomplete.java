import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class problemcomplete extends HttpServlet
{

    public problemcomplete()
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
        String s2 = "";
        String s4 = "";
        String s6 = "Finished";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        printwriter.println("<html>");
        printwriter.println("<center><h1><font color=forestgreen>HD Problem Desk</h1>");
        printwriter.println("<body>");
        printwriter.println("<form> ");
        printwriter.println("<TABLE bgcolor=white border=1 cellPadding=1 cellSpacing=1 width=80% align=center>");
        printwriter.println("<P>");
        printwriter.println(" <Tr> ");
        printwriter.println(" <TD>Ticket</TD> ");
        printwriter.println(" <TD>Prob.Report Date</TD> ");
        printwriter.println(" <TD>Solution Date</TD> ");
        printwriter.println(" <TD>Solved By</TD> ");
        printwriter.println("</Tr>");
        try
        {
            for(rs = st.executeQuery("select * from problemhistory where status='" + s6 + "'"); rs.next(); printwriter.println(" </tr>  "))            
{                int i = rs.getInt(1);
                String s1 = rs.getString(2);
                String s5 = rs.getString(5);
                String s3 = rs.getString(6);
                printwriter.println(" <tr><TD>" + i + "</TD>");
                printwriter.println(" <TD>" + s1 + "</TD> ");
                printwriter.println(" <TD>" + s3 + "</TD> ");
                printwriter.println(" <TD>" + s5 + "</TD> ");
            }

            printwriter.println("</Table>");
            printwriter.println("</P>");
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