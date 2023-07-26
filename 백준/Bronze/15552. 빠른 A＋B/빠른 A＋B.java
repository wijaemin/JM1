import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer in;
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            in = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(in.nextToken());
            int b = Integer.parseInt(in.nextToken());

            out.write(a+b+"\n");

        }
        out.flush();
        out.close();
        input.close();

    }
}