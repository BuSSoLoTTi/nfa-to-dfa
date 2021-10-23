package mais;

import org.json.JSONObject;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String jsonString = readFile("C:\\Users\\BuSSoLoTTi\\IdeaProjects\\nfa-to-dfa\\src\\main\\java\\mais\\data.json");

        JSONObject object = new JSONObject(jsonString);

        System.out.println(object);

        State A = new State("A",false ,true);
        State B = new State("A",true ,false );

        A.connect(B,"1");
        A.connect(A,"0");

        B.connect(B,"1");
        B.connect(A,"0");

    }

    public static String readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}


