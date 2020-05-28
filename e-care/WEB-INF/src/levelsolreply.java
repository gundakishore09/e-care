
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class levelsolreply extends HttpServlet
{

    public levelsolreply()
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
        try
        {
            for(rs = st.executeQuery("select * from problemrequest where ticket=" + i); rs.next();)
            {
                s1 = rs.getString(2);
                s2 = rs.getString(3);
                s3 = rs.getString(4);
            }

            System.out.println("for the ticket no = " + i + "\ncategory = " + s1);
            System.out.println("\nmodule  =  " + s2 + "\nproblem query  =  " + s3);
        }
        catch(Exception _ex) { }
        printwriter.println("<html>");
        printwriter.println("<body>");
        printwriter.println("<center><h3><font color=gray>Solution Reply</h3>");
        printwriter.println("<form name=frmsol action=./solreplyto>");
        printwriter.println("<TABLE bgcolor=lightyellow border=0 cellPadding=1 cellSpacing=1 width=80% align=center>");
        printwriter.println("<P>");
        printwriter.println("<Tr> ");
        printwriter.println("<TD>Ticket :  </TD> ");
        printwriter.println("<TD><input type=text name=ftickno id=ftickno value=" + i + "></TD></tr> ");
        printwriter.println("<tr>");
        printwriter.println("<td>Category  : </td>");
        printwriter.println("<TD><input type=text name=category id=category value='" + s1 + "'></TD></tr> ");
        printwriter.println("<tr>");
        printwriter.println("<td>Module  : </td>");
        printwriter.println("<TD><input type=text name=module id=module value='" + s2 + "'></TD></tr> ");
        printwriter.println("<TR>");
        printwriter.println("<TD>Problem Description</TD>");
        printwriter.println("<TD><TEXTAREA id=probQry name=probQry style=HEIGHT: 169px; WIDTH: 314px >" + s3 + "</TEXTAREA></TD><tr>");
        printwriter.println("<TR>");
        printwriter.println("<TD>Problem Solution</TD>");
        printwriter.println("<TD><TEXTAREA id=probSol name=probSol style=HEIGHT: 169px; WIDTH: 314px></TEXTAREA></TD></TR>");
        printwriter.println("<tr><td><input type=submit id=solsub name=solsub value=Submit></td>");
        printwriter.println("<td><input type=reset name=reset value=Reset></td></tr>");
        printwriter.println("</Table> ");
        printwriter.println("</P> ");
        printwriter.println("</form>");
        printwriter.println("</body>");
        printwriter.println("</html>");
    }

    Connection con;
    Statement st;
    ResultSet rs;
}