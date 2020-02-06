package acmp.Num0001;
import java.util.*;
import java.io.*;
// "A+B"
public class Main{
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        int a=sc.nextInt(), b=sc.nextInt();
        pw = new PrintWriter(new File("output.txt"));
        pw.print(a+b);
        pw.close();
    }
}
