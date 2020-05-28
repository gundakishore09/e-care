import java.io.*;
import java.sql.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class solreplyto extends HttpServlet
{

    public solreplyto()
    {
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
            st1 = con.createStatement();
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
        HttpSession httpsession = httpservletrequest.getSession(true);
        PrintWriter printwriter = httpservletresponse.getWriter();
        httpservletresponse.setContentType("text/html");
        String s = httpservletrequest.getParameter("ftickno");
         System.out.println("the ticketno="+s);
        String s1 = httpservletrequest.getParameter("probQry");
        String s2 = "";
        String s4 = "";
        Object obj = httpsession.getValue(s4);
        System.out.println("solby" + obj.toString());
        Date date = new Date();
        int j = date.getYear();
        j += 1900;
        int k = date.getMonth();
		System.out.println("Month:" +k);
        int l = date.getDay();
		System.out.println("Day:" +l);
        String s5 = date.getDay() + "/" + date.getMonth() + "/" + j;
        System.out.println("strdate" + s5);
        int i1 = Integer.parseInt(s);
        String s6 = "";
        String s7 = "";
        boolean flag = false;
        String s8 = httpservletrequest.getParameter("probSol");
        System.out.println("problem solution  =  " + s8);
        try
        {
         
            //for(rs = st.executeQuery("select * from problemrequest where ticket=" + i1); //rs.next();)
       rs= st.executeQuery("select * from problemrequest where ticket=" + i1);
	while(rs.next())
            	{
                System.out.println("hai hai hai");
                s7 = rs.getString(6);
	s6 = rs.getString(7);
                
            }
            String s3 = s5;
            String s9 = "Finished";
            System.out.println(" report date  :  " + s6);
            System.out.println("prob date = " + s6 + "  userid  :  " + s7);
            int k1 = st.executeUpdate("update problemrequest set lastsolution='" + s8 + "' where ticket="+i1);
            printwriter.println("<html><body>");
            if(k1 == 1)
            {
                //printwriter.println("insert into problemhistory values(" + i1 + ",'" + s6 + "','" + s1 + "','" + s8 + "','" + obj + "','" + s9 + "')");
                int j1 = st.executeUpdate("update problemhistory set solution='" + s8 + "',solutionby='" + obj + "',status='" + s9 + "',solutiondate=sysdate  where ticket='" + i1 + "'");
                System.out.println("AFTER UPDATE strdate   " + s5);
                printwriter.println("k value is     " + j1);
                printwriter.println("<Strong>THE QUESTION BEARING TICKET ID :" + i1 + " IS ANSWERED ");
                printwriter.println(" THE SOLUTION IS  :  " + s8);
                System.out.println(" i value  =  " + k1 + "   k value   : " + j1);
            } else
            {
                printwriter.println("<b>THE QUESTION BEARING TICKET ID :" + i1 + " IS NOT ANSWERED ");
            }
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
    String level;
    int i;
}