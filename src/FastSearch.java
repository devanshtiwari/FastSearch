import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by devanshtiwari on 11-Aug-16.
 */

public class FastSearch extends Thread {

    private ArrayList<FileDetail> F=new ArrayList<>();

    public void  init(String filePath){
        ProgressBar pb=new ProgressBar();
        pb.start();
        try {
            indexit(filePath);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProgressBar.signal();
    }
    private void indexit(String filePath) throws InterruptedException {
        Path dir = FileSystems.getDefault().getPath( filePath );
        DirectoryStream<Path> stream = null;
        try {
            stream = Files.newDirectoryStream( dir );
        } catch (IOException e) {
            ProgressBar.showProgress=false;
            e.printStackTrace();
            System.out.println("\nUnable to read the Directory. Does not Exist");
        }
        for (Path path : stream) {
            FileDetail fil=new FileDetail();
            fil.setF(new File(path.toString()));
            fil.setName(path.getFileName().toString());
            if(new File(String.valueOf(path)).isDirectory()) {
                fil.setDir(true);
                indexit(String.valueOf(path));
            }
            else
                fil.setDir(false);
            if(F.contains(fil)) {
                FileDetail t=F.get(F.indexOf(fil));
                while(t.getNext()!=null) {
                    t=t.getNext();
                }
                t.setNext(fil);
                F.add(fil);
            }
            else
                F.add(fil);
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to close File.");
        }
    }

    public ArrayList<String> Fsearch(String filename) {
        return Fsearch(filename,false);
    }

    public ArrayList<String> Fsearch(String filename, Boolean dir) {
        ProgressBar.showProgress=false;
        FileDetail temp = new FileDetail();
        temp.setName(filename);
        temp.setDir(dir);
        ArrayList<String> dirs=new ArrayList<>();
        if (F.contains(temp)) {
            int s=F.indexOf(temp);
            FileDetail t;
            t=F.get(s);
            while(t!=null){
                dirs.add(t.getF().getAbsolutePath());
                t=t.getNext();
            }
        }
        return dirs;
    }
}
