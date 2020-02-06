package acmp.Num0755;
import java.util.*;
import java.io.*;
// "Сбор земляники"
public class Main{
    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    PrintWriter pw;
    Scanner sc;
    public void run() throws IOException{
        sc = new Scanner(new File("input.txt"));
        int x=sc.nextInt(), y=sc.nextInt(), z=sc.nextInt();
        pw = new PrintWriter(new File("output.txt"));
        if(x+y>=z){
            pw.print(x+y-z);
        }else{
            pw.print("Impossible");
        }
        pw.close();
    }
}
