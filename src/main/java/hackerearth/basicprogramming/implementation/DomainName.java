package hackerearth.basicprogramming.implementation;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xml.internal.resolver.Catalog.URI;

public class DomainName {

    public static void main(String[] args) throws URISyntaxException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());

        Pattern pa = Pattern.compile("http[s]?://(ww[w2]\\.)?(([a-zA-Z0-9\\-]+\\.)+([a-zA-Z\\-])+)");

        TreeSet<String> set = new TreeSet<>();

        while (n-- > 0) {
            String input = in.nextLine();
            Matcher ma = pa.matcher(input);
            while (ma.find()) set.add(ma.group(2));
        }

        for (String str : set) {
            //System.out.print((str != set.last()) ? str + ";" : str);

        }
    }

}

