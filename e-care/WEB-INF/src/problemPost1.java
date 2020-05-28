import java.io.*;
import java.sql.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class problemPost1 extends HttpServlet
{

    public problemPost1()
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
        String s6 = "";
        String s7 = "";
        String s8 = "";
        String s10 = "";
        String s12 = "";
        String s14 = "";
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        HttpSession httpsession = httpservletrequest.getSession(true);
        try
        {
            Date date = new Date();
            String s1 = httpservletrequest.getParameter("select1");
            String s3 = httpservletrequest.getParameter("select2");
            String s5 = httpservletrequest.getParameter("TEXTAREA1");
            String s9 = httpservletrequest.getParameter("day");
            String s11 = httpservletrequest.getParameter("month");
            String s13 = httpservletrequest.getParameter("year");
            String s16 = s11 + "/" + s9 + "/" + s13;
            Date date1 = new Date(s16);
            System.out.println(" cureent date : " + date);
            System.out.println(" report  date : " + date1);
            if(date1.before(date))
            {
                httpservletresponse.sendRedirect("./postproblemd.html");
            } else
            {
                int i = Integer.parseInt(s9);
                int j = Integer.parseInt(s13);
                String s15 = i + "/" + s11 + "/" + j;
                System.out.println(s15);
                System.out.println("repdate.before(curdate)  " + date1.before(date));
                httpsession.putValue("catid1", s1);
                httpsession.putValue("modid1", s3);
                System.out.println("before select nvl");
                rs = st.executeQuery("select max(ticket) from problemrequest");
                System.out.println("result set");
                int k;
                for(k = 0; rs.next(); k = rs.getInt(1));
                if(k == 0)
                    k = 1;
                else
                    k++;
                String s17 = "null";
                String s18 = "unfinished";
                String s19 = "";
                String s20 = "";
                String s21 = "";
                int l = st1.executeUpdate("insert into problemrequest( TICKET, CATEGORYID, MODULEID, PROBLEMDESCRIPTION,LASTSOLUTION, USER_ID, PROBLEMREPORTDATE)  values('" + k + "','" + s1 + "','" + s3 + "','" + s5 + "','" + s17 + "','" + s6 + "','" + s15 + "')");
                if(l == 1)
                {
                    int i1 = st.executeUpdate(" insert into problemhistory values('" + k + "','" + s15 + "','" + s5 + "','" + s19 + "','" + s20 + "','" + s21 + "','" + s18 + "')");
                    printwriter.println("<HTML>");
                    printwriter.println("<HEAD><TITLE></TITLE>");
                    printwriter.println("<script language = 'JavaScript'>");
                    printwriter.println("</script>");
                    printwriter.println("<BODY>");
                    printwriter.println("<form name=f1 action='./corporateuserview.html' target='_parent'>");
                    printwriter.println("<P>&nbsp;</P>");
                    printwriter.println("<P>&nbsp;</P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P align=center style='COLOR: forestgreen'><STRONG> ");
                    printwriter.println("<U>Ticket Confirmation</U></STRONG></P>");
                    printwriter.println("<P align=center>&nbsp;</P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printwriter.println("<TABLE border=0 cellPadding=1 cellSpacing=1 width=75% align=center>");
                    printwriter.println("<TR>");
                    printwriter.println("<TD></TD>");
                    printwriter.println("<TD></TD></TR>");
                    printwriter.println("<TR>");
                    printwriter.println("<TD>");
                    printwriter.println(" <P align=left><STRONG>Problem is posted and your ");
                    printwriter.println("      Ticket Number is&nbsp;&nbsp;:</STRONG></P></TD>");
                    printwriter.println("    <TD>" + k + "</TD></TR>");
                    printwriter.println("  <TR>");
                    printwriter.println("    <TD>");
                    printwriter.println("      <P align=left><STRONG>  ");
                    printwriter.println("       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P></TD>");
                    printwriter.println("    <TD></TD></TR>");
                    printwriter.println("  <TR>");
                    printwriter.println("    <TD>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                    printwriter.println("<INPUT id=submit1 name=submit1 type=submit value='Ok'></TD>");
                    printwriter.println("    <TD>");
                    printwriter.println("      <P>&nbsp;</P>");
                    printwriter.println("      <P>&nbsp;</P></TD></TR></TABLE>&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
                    printwriter.println("</STRONG></P>");
                    printwriter.println("<P><STRONG>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</STRONG></P></form>");
                    printwriter.println("</BODY></HTML>");
                }
                System.out.println("i value is   :  " + l);
            }
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