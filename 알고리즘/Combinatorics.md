# Combinatorics
#알고리즘/Combinatorics

---

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1256 {
    static int N, M, K;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    static int max_val = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int all = N+M;
        dp = new int[all + 1][all + 1];

        //파스칼 초기화
        for (int i = 1; i < all + 1; i++) {
            dp[i][i] = 1;
            dp[i][1] = i;
        }

        for (int i = 3; i < all + 1; i++) {
            for (int j = 2; j < all + 1; j++) {
                dp[i - 1][j] = Math.min(dp[i - 1][j], max_val);
                dp[i - 1][j - 1] = Math.min(dp[i - 1][j-1], max_val);
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        //전체 개수(N+M C M) 안에 없으면 -1
        if (dp[all][M] < K) {
            System.out.println("-1");
            return;
        } else {
            //있으면 분할해서 들어감
            while (true) {
                //K개 <= N+M-1 C M이면 위로 k 그대로 들고감
                if (K <= dp[all - 1][M]) {
                    sb.append("a");
                    all--;
                } else {
                    //아니면 아래로 k - (N+M-1 C M)
                    sb.append("z");
                    K -= dp[all - 1][M];
                    all--;
                    M--;
                }

                if (all == 0 || M == 0 || N == 0) {
                    if (M == 0) {
                        for (int i = 0; i < all; i++) {
                            sb.append("a");
                        }
                    } else if (N == 0) {
                        for (int i = 0; i < all; i++) {
                            sb.append("z");
                        }
                    }
                    
                    break;
                }
            }

        }

        System.out.println(sb.toString());
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1722 {
    static int N;
    static int M;
    static long K;
    static int[] nums = new int[20];
    static long[] fact = new long[21];
    static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        //순열을 구하기
        if (M == 1) {
            K = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j])
                        continue;

                    if (K <= fact[N - i - 1]) {
                        sb.append(j);
                        sb.append(" ");
                        visited[j] = true;
                        break;
                    } else {
                        K -= fact[N - i - 1];
                    }
                }
            }

            System.out.println(sb.toString());
        } else {
            //이 순열이 몇 번 쨰인지
            long result = 0;

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < nums[i]; j++) {
                    if (!visited[j])
                        result += fact[N-i-1];
                }
                visited[nums[i]] = true;
            }

            System.out.println(result + 1);
        }
    }
}
```