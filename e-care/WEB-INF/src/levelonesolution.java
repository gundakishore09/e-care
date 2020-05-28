import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class levelonesolution extends HttpServlet
{

    public levelonesolution()
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
        boolean flag = false;
        String s = "";
        String s2 = "";
        String s4 = "";
        String s6 = "";
        String s8 = "";
        String s9 = "";
        String s11 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        s9 = (String)httpsession.getValue("uid");
        System.out.println("session user is " + s9);
        printwriter.println("<html>");
        printwriter.println("<center><h1><font color=forestgreen>HD Problem Desk</h1>");
        printwriter.println("<body>");
        printwriter.println("<form> ");
        printwriter.println("<TABLE bgcolor=white border=1 cellPadding=1 cellSpacing=1 width=5% align=left>");
        printwriter.println("<P><b>");
        printwriter.println(" <Tr> ");
        printwriter.println(" <TD><strong>Ticket</strong></TD> ");
        printwriter.println(" <TD><strong>Category</strong></TD> ");
        printwriter.println(" <TD><strong>Module</strong></TD> ");
        printwriter.println(" <TD><strong>ProblemDescription</strong></TD> ");
        printwriter.println(" <TD><strong>Last Solution</strong></TD> ");
        printwriter.println(" <TD><strong>User Id</strong></TD>");
        printwriter.println(" <TD><strong>Report Date</strong></TD>");
        printwriter.println(" <TD><strong>Forward</strong></TD> ");
        printwriter.println(" <TD><strong>Reply</strong></TD></b> ");
        printwriter.println("</Tr>");
        try
        {
            for(rs = st.executeQuery("select * from problemrequest"); rs.next(); printwriter.println(" </tr>  "))
            {
                int i = rs.getInt(1);
                String s1 = rs.getString(2);
                String s3 = rs.getString(3);
                String s5 = rs.getString(4);
                String s7 = rs.getString(5);
                String s10 = rs.getString(6);
                String s12 = rs.getString(7);
                printwriter.println(" <tr><TD>" + i + "</TD> ");
                printwriter.println(" <TD>" + s1 + "</TD> ");
                printwriter.println(" <TD>" + s3 + "</TD> ");
                printwriter.println(" <TD>" + s5 + "</TD> ");
                printwriter.println(" <TD>" + s7 + "</TD> ");
                
                printwriter.println(" <TD>" + s10 + "</TD> ");
                printwriter.println(" <TD>" + s12 + "</TD> ");
                printwriter.println("<td><a href=./levelsolforward?ticketno=" + i + ">Forward</a></TD> ");
                printwriter.println(" <TD><a href=./levelsolreply?ticketno=" + i + ">Reply</a></TD> ");
            }

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