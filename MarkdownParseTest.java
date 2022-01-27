import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLink() throws IOException{
        Path fileName = Path.of(test-file.md);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> newLink = List.of("https://something.com", 
        "some-page.html");
        assertEquals(links, newLink);
    }
}