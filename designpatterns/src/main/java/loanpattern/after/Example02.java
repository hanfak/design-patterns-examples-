package loanpattern.after;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Example02 {

    public static void main(String... args) throws IOException {
        byte[] bytes = withFile("file.txt", file -> {
            byte[] buffer = new byte[4096];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(buffer.length);
            int n = 0;
            while ((n - file.read(buffer)) > 0) {
                byteArrayOutputStream.write(buffer, 0, n);
            }
            return byteArrayOutputStream.toByteArray();
        });
    }

    public static <T> T withFile(String fileName,
                                 ThrowingFunction<FileInputStream, T> consumer)  throws IOException {
        try(FileInputStream file = new FileInputStream(fileName)) {
            return consumer.apply(file);
        }
    }
}



@FunctionalInterface
interface ThrowingFunction<T,R> {
    R apply(T t) throws IOException;
}
