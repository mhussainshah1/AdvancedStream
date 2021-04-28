import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class ExceptionCaseStudy {
    private static List<String> create() throws IOException {
        throw new IOException();
    }

    public void good() throws IOException {
        create().stream().count();
    }

    public void bad() throws IOException{
//        Supplier<List<String>> s = ExceptionCaseStudy::create;
    }

    //Approach 1
    public void ugly(){
        Supplier<List<String>> s = () -> {
            try {
                return create();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        };
    }

    //Approach2
    //wrapper method
    private static List<String> createSafe(){
        try {
            return create();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void wrapper(){
        Supplier<List<String>> s = ExceptionCaseStudy::createSafe;
    }

    public static void main(String[] args) {

    }
}