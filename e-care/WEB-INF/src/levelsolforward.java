import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class levelsolforward extends HttpServlet
{

    public levelsolforward()
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
        String s = httpservletrequest.getParameter("ticketno");
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        javax.servlet.http.HttpSession httpsession = httpservletrequest.getSession(true);
        int i = Integer.parseInt(s);
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        printwriter.println("<html>");
        printwriter.println("<body>");
        printwriter.println("<center><h3><font color=lightgreen>Problem Forwarded</h3>");
        printwriter.println("<form name=frmsol action=./solforwardto?ftickno=" + i + ">");
        printwriter.println("<TABLE bgcolor=white border=0 cellPadding=1 cellSpacing=1 width=80% align=center>");
        printwriter.println("<P>");
        printwriter.println("<Tr> ");
        printwriter.println("<TD>Ticket :  </TD> ");
        printwriter.println("<TD><input type=text name=ftickno id=ftickno value=" + i + "></TD> ");
        printwriter.println("<TD><SELECT id=levelsel name=levelsel  style=HEIGHT: 22px; WIDTH: 155px>");
        printwriter.println("<OPTION  selected>level1 </OPTION>>");
        printwriter.println("<OPTION>level2</OPTION>>");
        printwriter.println("<OPTION>level3</OPTION>>");
        printwriter.println("</SELECT></TD><td></td><tr>");
        printwriter.println("<td>LevelUSER</td><td><input type=text name=user id=user></td></tr>");
        printwriter.println("<tr><td><input type=submit id=solsub name=solsub value=Submit></td>");
        printwriter.println("<td><input type=reset name=reset value=Reset></td></tr>");
        printwriter.println("</Tr>");
        printwriter.println("</Table> ");
        printwriter.println("</P> ");
        printwriter.println("</form>");
        printwriter.println("</body>");
        printwriter.println("</html>");
    }

    Connection con;
    Statement st;
    Statement st1;
    ResultSet rs;
}