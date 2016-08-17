/**
 * <h1>ProgressBar</h1>
 * <p>A Class that will help to implement the Progess Bar</p>
 * @author Devansh Tiwari
 * @version 1.0
 * @since 2016-08-11
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
