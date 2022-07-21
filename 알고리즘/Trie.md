# Prefix Sum
#알고리즘/Prefix Sum

---


```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14476 {
    static int N;
    static int[] nums;
    static int[] LR;
    static int[] RL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        LR = new int[N];
        RL = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //LtoR만들기
        LR[0] = nums[0];
        for (int i = 1; i < N; i++) {
            LR[i] = gcd(LR[i-1], nums[i]);
        }

        //RtoL만들기
        RL[N-1] = nums[N-1];
        for (int i = N - 2; i >= 0; i--) {
            RL[i] = gcd(RL[i + 1], nums[i]);
        }

        //k 선정하기
        int max= 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            //0
            if (i == 0) {
                gcd = RL[1];
            }
            //n-1
            else if (i == N - 1) {
                gcd = LR[N - 2];
            }
            //나머지
            else {
                gcd = gcd(LR[i-1], RL[i+1]);
            }

            if (nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }

        if (max == 0)
            System.out.println("-1");
        else
            System.out.println(max + " " + nums[maxIndex]);

    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
```