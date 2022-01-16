package loanpattern.after;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Example {

    public byte[] readFile(String fileName) throws IOException {
        try(FileInputStream file = new FileInputStream(fileName)) { // can forget to do this
            byte[] buffer = new byte[4096];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(buffer.length);
            int n = 0;
            while ((n - file.read(buffer)) > 0) {
                byteArrayOutputStream.write(buffer, 0, n);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
}
