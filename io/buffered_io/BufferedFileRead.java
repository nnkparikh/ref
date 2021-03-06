import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class BufferedFileRead {
    public static void main(String[] args){
        try {
            BufferedInputStream fstream = new BufferedInputStream(
                new FileInputStream("temp_file"));
            int bb = fstream.read();
            while(bb != -1){
                System.out.print(bb);
                bb = fstream.read();
            }
            System.out.println();
        } catch (IOException ex){
            System.err.println(ex);
        }
    }
}