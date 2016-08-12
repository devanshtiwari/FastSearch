import java.io.File;

/**
 * Created by devanshtiwari on 11-Aug-16.
 */

public class FileDetail {

    private String name;
    private File f;
    private Boolean dir;
    private FileDetail next=null;

    public void setName(String name) {
        this.name = name;
    }

    public void setF(File f) {
        this.f = f;
    }

    public void setDir(Boolean dir) {
        this.dir = dir;
    }

    public void setNext(FileDetail next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public File getF() {
        return f;
    }

    public Boolean getDir() {
        return dir;
    }

    public FileDetail getNext() {
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        FileDetail t= (FileDetail) obj;
        if(this.name.equals(t.name) && this.dir.equals(t.dir))
            return true;
        else
            return false;
    }
}
