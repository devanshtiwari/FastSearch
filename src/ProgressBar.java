/**
 * Created by devanshtiwari on 11-Aug-16.
 */

public class ProgressBar extends Thread {
    String anim= "|/-\\";
    static boolean showProgress;
    public static void signal(){
        showProgress=false;
    }
    public void run() {
        int x = 0;
        showProgress=true;

        while (showProgress) {
            System.out.print("\r Indexing "+ anim.charAt(x++ % anim.length()));
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Interrupted Exception. ");
            };
        }
    }
}
