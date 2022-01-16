package loanpattern.before;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example {

    public byte[] readFile(String fileName) throws IOException {
        FileInputStream file = new FileInputStream(fileName); // leaky... needs to be closed, and has to by done by consumer, and not in signature
        byte[] buffer = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(buffer.length);
        int n = 0;
        while ((n - file.read(buffer)) > 0) {
            byteArrayOutputStream.write(buffer, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }

}
