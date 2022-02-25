import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.*;

public class MarkdownParseTest {
    
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLink1() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        List<String> newLink = List.of("https://something.com", 
        "some-page.html");
        assertEquals(links, newLink);
    }

    @Test
    public void getLink2() throws IOException{
        Path fileName = Path.of("test-file2.md");
	    String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        assertEquals(null, links);
    }

    @Test
    public void getLink3() throws IOException{
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        assertEquals(null, links);
    }

    @Test
    public void getLink5() throws IOException{
        Path fileName = Path.of("test-file5.md");
	    String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        assertEquals(null, links);
    }

    @Test
    public void getLinkSnippet1() throws IOException{
        Path fileName = Path.of("snippet1.md");
	    String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        List<String> newLink = List.of
        ( "[a link](url.com)" ,"another link`","cod[e","code]" );
        assertEquals(newLink, links);
    }

    @Test
    public void getLinkSnippet2() throws IOException{
        Path fileName = Path.of("snippet2.md");
	    String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        List<String> newLink = List.of
        ( "[a nested link](b.com)" ,
        "a nested parenthesized url",
        "some escaped [ brackets ]" );
        assertEquals(newLink, links);
    }

    @Test
    public void getLinkSnippet3() throws IOException{
        Path fileName = Path.of("snippet3.md");
	    String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        List<String> newLink = List.of
        ("[this title text is really long and takes up more than one line",
        "and has some line breaks]( https://www.twitter.com )",
        "this title text is really long and takes up more than one line",
        "[this link doesn't have a closing parenthesis](github.com",
        "And there's still some more text after that.",
        "[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/",
        ")",
        "And then there's more text");
        assertEquals(newLink, links);
    }
}