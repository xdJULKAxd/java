import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Zad1 {
    public static void main(String[] args){
        String path = "./file.txt";

        try(OutputStream file = new FileOutputStream(path)){
            String text = "Test text";

            byte bytes[] = text.getBytes(StandardCharsets.UTF_8);

            file.write(bytes);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}