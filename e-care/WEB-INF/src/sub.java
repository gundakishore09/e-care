import java.io.PrintStream;

class sub
{

    sub()
    {
    }

    public static void main(String args[])
    {
        String s = str.substring(2, 3);
        System.out.println(" 0 to 2 " + s);
        System.out.println(" 0 to 2 " + str.substring(0, 2));
        System.out.println(" 3 to 5 " + str.substring(3));
    }

    static String str = "hareesh";

}