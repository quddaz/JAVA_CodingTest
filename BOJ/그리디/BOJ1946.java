import java.io.*;
import java.util.*;

public class Main {

    static class Applicant {
        int docRank;
        int interviewRank;

        Applicant(int docRank, int interviewRank) {
            this.docRank = docRank;
            this.interviewRank = interviewRank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Applicant> applicants = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                applicants.add(new Applicant(doc, interview));
            }

            applicants.sort(Comparator.comparingInt(a -> a.docRank));

            int count = 1; 
            int bestInterview = applicants.get(0).interviewRank;

            for (int i = 1; i < N; i++) {
                Applicant cur = applicants.get(i);
                if (cur.interviewRank < bestInterview) {
                    count++;
                    bestInterview = cur.interviewRank;
                }
            }

            System.out.println(count);
        }
    }
}
