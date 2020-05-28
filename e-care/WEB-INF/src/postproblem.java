import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class postproblem extends HttpServlet
{

    public postproblem()
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
        String s = "";
        String s2 = "";
        String s4 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        s4 = (String)httpsession.getValue("user");
        System.out.println("uid is" + s4);
        try
        {
            printwriter.println("<HTML>");
            printwriter.println("<HEAD>");
            printwriter.println("<TITLE></TITLE>");
            printwriter.println("</HEAD>");
            printwriter.println("<BODY>");
            printwriter.println("<form name=f action='./problemPost'>");
            printwriter.println("<P align=center><FONT color=forestgreen ");
            printwriter.println("size=5><STRONG><U>Query Form</U></STRONG></FONT></P>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("<P align=center>");
            rs = st.executeQuery("select categoryname from categoryies");
            printwriter.println("<TABLE border=0 align='center' cellPadding=1 cellSpacing=1 width=75%>");
            printwriter.println("  <TR>");
            printwriter.println("    <TD>Category Name</TD>");
            printwriter.println("    <TD><SELECT id=select1 name=select1 style='HEIGHT: 22px; WIDTH: ");
            printwriter.println("163px' selected> ");
            String s1;
            for(; rs.next(); printwriter.println("<OPTION value=" + s1 + ">" + s1 + "</OPTION>"))
                s1 = rs.getString(1);

            printwriter.println("</SELECT></TD></TR>");
            printwriter.println("  <TR>");
            printwriter.println("<TD>Module Name</TD>");
            printwriter.println("    <TD><SELECT id=select2 name=select2 style='HEIGHT: 22px; WIDTH: ");
            printwriter.println("164px'> ");
            String s3;
            for(rs1 = st1.executeQuery("select modulename from module"); rs1.next(); printwriter.println("<OPTION value=" + s3 + ">" + s3 + "</OPTION>"))
                s3 = rs1.getString(1);

            printwriter.println("</SELECT></TD></TR>");
            printwriter.println("  <TR>");
            printwriter.println("    <TD>Problem Description</TD>");
            printwriter.println("    <TD><TEXTAREA id=TEXTAREA1 name=TEXTAREA1 style='HEIGHT: 142px; ");
            printwriter.println("WIDTH: 232px'></TEXTAREA></TD></TR>");
            printwriter.println("  <TR>");
            printwriter.println("    <TD><STRONG>Report Date</STRONG></TD>");
            printwriter.println("    <TD><SELECT id=select3 name=day ");
            printwriter.println("      style='HEIGHT: 22px; WIDTH: 39px'> <OPTION selected ");
            printwriter.println("        value='01'>01</OPTION>");
            printwriter.println("        <OPTION value='02'>02</OPTION><OPTION ");
            printwriter.println("        value='03'>03</OPTION><OPTION value='04'>04</OPTION><OPTION ");
            printwriter.println("        value='05'>05</OPTION><OPTION value='06'>06</OPTION><OPTION ");
            printwriter.println("        value='07'>07</OPTION><OPTION value='08'>08</OPTION><OPTION ");
            printwriter.println("        value='09'>09</OPTION><OPTION value='10'>10</OPTION><OPTION ");
            printwriter.println("        value='11'>11</OPTION><OPTION value='12'>12</OPTION><OPTION ");
            printwriter.println("        value='13'>13</OPTION><OPTION value='14'>14</OPTION><OPTION ");
            printwriter.println("        value='15'>15</OPTION><OPTION value='16'>16</OPTION><OPTION ");
            printwriter.println("        value='17'>17</OPTION><OPTION value='18'>18</OPTION><OPTION ");
            printwriter.println("        value='19'>19</OPTION><OPTION value='20'>20</OPTION><OPTION ");
            printwriter.println("      value='21'>21</OPTION><OPTION value='22'>22</OPTION><OPTION ");
            printwriter.println("value='23'>23</OPTION><OPTION value='24'>24</OPTION><OPTION ");
            printwriter.println("        value='25'>25</OPTION><OPTION value='26'>26</OPTION><OPTION ");
            printwriter.println("        value='27'>27</OPTION><OPTION value='28'>28</OPTION><OPTION ");
            printwriter.println("        value='29'>29</OPTION><OPTION value='30'>30</OPTION><OPTION ");
            printwriter.println("        value='31>31</OPTION></SELECT>&nbsp;&nbsp;&nbsp;<SELECT");
            printwriter.println("id=select4 ");
            printwriter.println("      name=month style='HEIGHT: 22px; WIDTH: 45px'> <OPTION selected ");
            printwriter.println("        value=Jan>Jan</OPTION><OPTION value=Feb>Feb</OPTION><OPTION ");
            printwriter.println("        value=Mar>Mar</OPTION><OPTION value=Apr>Apr</OPTION><OPTION ");
            printwriter.println("        value=May>May</OPTION> <OPTION value=Jun>Jun</OPTION> <OPTION ");
            printwriter.println("        value=Jul>Jul</OPTION> <OPTION value=Aug>Aug</OPTION> <OPTION ");
            printwriter.println("        value=Sept>Sept</OPTION> <OPTION value=Oct>Oct</OPTION> <OPTION ");
            printwriter.println("        value=Nov>Nov</OPTION> <OPTION ");
            printwriter.println("      value=Dec>Dec</OPTION></SELECT>&nbsp'&nbsp;&nbsp; <INPUT id=text1 ");
            printwriter.println("      name=year style='HEIGHT: 22px; WIDTH: 40px' value=2003></TD></");
            printwriter.println("<TR>");
            printwriter.println("    <TD></TD>");
            printwriter.println("    <TD></TD></TR>");
            printwriter.println("  <TR>");
            printwriter.println("<TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nb");
            printwriter.println("&nbsp;&nbsp; ");
            printwriter.println("<INPUT id=submit1 name=submit1 type=submit value=Submit></TD>");
            printwriter.println("    <TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <INPUT id=reset1 ");
            printwriter.println("name=reset1 type=reset value=' Reset '></TD></TR></TABLE></P>");
            printwriter.println("<P align=center>&nbsp;</P>");
            printwriter.println("</form>");
            printwriter.println("</BODY>");
            printwriter.println("</HTML>");
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