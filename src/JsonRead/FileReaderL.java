package JsonRead;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderL {

public static String read(String file) throws IOException {

StringBuilder content = new StringBuilder();

try (BufferedReader reader = Files.newBufferedReader(Paths.get(file), Charset.defaultCharset())) {

String line = null;

while ((line = reader.readLine()) != null) {

content.append(line).append("\n");

}

return content.toString();

}

}
}
