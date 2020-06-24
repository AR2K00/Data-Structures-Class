import java.io.*;
import java.util.*;
import java.net.URL;
import java.net.URLConnection;

// In is a helper class written for CIS-2168 Labs 1 & 2. Its purpose is to help
// read a text file. The file can be remote (accessed through an URL) or local.
// Each line of the input file is assumed to be a single entry that needs to be
// interpreted as an integer. For example, the file contents might be:  23
//                                                                      85
//                                                                      121689
//
// Method readAllInts() returns the contents of the file as an array of ints.
// The main() method shows an example of using the In class.
public final class In {
    private Scanner scanner;

    // Constructor. Initializes an input stream from a filename (local or URL).
    public In(String name) {
        if (name == null) throw new IllegalArgumentException("please tell me which file to open. exiting for now...");
        try {
            // first try to read file from local file system
            File file = new File(name);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
                return;
            }

            // resource on the web
            URL url = new URL(name);
            URLConnection site = url.openConnection();
            InputStream is     = site.getInputStream();
            scanner            = new Scanner(new BufferedInputStream(is));
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Could not open " + name, ioe);
        }
    }

    // Reads all lines from this input stream and returns them as
    // an array of strings.
    public String[] readAllLines() {
        ArrayList<String> lines = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

    // Reads all lines from this input stream, parses them as integers,
    // and returns them as an array of integers.
    public int[] readAllInts() {
        String[] fields = readAllLines();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Integer.parseInt(fields[i].trim());
        return vals;
    }

    // Unit tests the In data type.
    public static void main(String[] args) {
        // initialize in with tinyT.txt data file (stored on github)
        In in = new In("https://gist.githubusercontent.com/david-dobor/b4817f435bb4cc58adefc8f101f44efa/raw/d43fee7207dbac6fd70a1a111dd4992ffbd318ec/tinyT.txt");
        //int[] a = in.readAllInts();

        //In in = new In("largeT.txt");
        int[] a = in.readAllInts();
        System.out.println(Arrays.toString(a));

    }
}