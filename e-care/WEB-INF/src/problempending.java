import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class problempending extends HttpServlet
{

    public problempending()
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
            st1 = con.createStatement();
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
        String s3 = "";
        String s5 = "unfinished";
        String s6 = "";
        String s7 = "";
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
        printwriter.println(" <TD>Category</TD> ");
        printwriter.println(" <TD>Module</TD> ");
        printwriter.println(" <TD>Prob.Description</TD> ");
        printwriter.println(" <TD>Prob.Report Date</TD> ");
        printwriter.println("</Tr>");
        try
        {
           for(rs = st.executeQuery("select * from problemhistory where status ='"+s5+"'"); rs.next(); printwriter.println(" </tr>  "))
        	{
	 printwriter.println(" </tr>  ");
                int i = rs.getInt(1);
           System.out.println(i);
        String s1=rs.getString(2);
                String s4 = rs.getString(3);
           System.out.println(s4);
    for(rs1 = st1.executeQuery("select * from problemrequest where ticket=" + i); rs1.next();)
    
 {
                   s6 = rs1.getString(2);
           System.out.println(s6);
                    s7 = rs1.getString(3);
                }

                printwriter.println(" <tr><TD>" + i + "</TD>");
                printwriter.println(" <TD>" + s6 + "</TD>");
                printwriter.println(" <TD>" + s7 + "</TD>");
                printwriter.println(" <TD>" + s4 + "</TD> ");
                printwriter.println(" <TD>" + s1 + "</TD> ");
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
    ResultSet rs1;
}