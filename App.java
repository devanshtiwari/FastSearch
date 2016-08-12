import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.FastSearch.*;
/**
 * Created by devanshtiwari on 11-Aug-16.
 */
public class App {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        FastSearch N=new FastSearch();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the directory to be indexed: ");
        String dir=in.nextLine();
        long start = System.currentTimeMillis();
        N.init(dir);
        long stop = System.currentTimeMillis();
        System.out.println( "\nIndexing Time: " + (stop - start) + " ms" );
        //TO Search
        ArrayList<String> directory;
        String name;
        while(true) {
            System.out.println("Enter file name: ");
            name = in.nextLine();
            start = System.currentTimeMillis();
            directory =N.Fsearch(name,false);
            for (String s :directory)
                System.out.println(s);
            stop = System.currentTimeMillis();
            System.out.println( "Searching Time: " + (stop - start) + " ms" );
        }
    }
}
