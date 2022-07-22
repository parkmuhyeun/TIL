# Number Theory
#알고리즘/Number Theory

---


```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3955 {
    static int T, K, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            //1. 해검증
            EGResult result = extendedGcd(K, C);
            if (result.r != 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                //2. 초기해 구하기
                long x0 = result.s;
                long y0 = result.t;

                //3. 일반해 구하기
                //4. k의 범위
                //5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
                long kFromY = (long) Math.ceil((double) y0 / (double) K) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) C) - 1;
                long k = Math.min(kFromX, kFromY);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) K);
                if (kLimitFromY <= k) {
                    System.out.println(y0 - K * k);
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }

        }
    }

    static EGResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        this.s = s;
        this.t = t;
        this.r = r;
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1837 {
    static String P;
    static int K;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        isNotPrime = new boolean[K];

        //소수구하기
        for (int i = 2; i < K; i++) {
            for (int j = i * 2; j < K; j += i) {
                isNotPrime[j] = true;
            }
        }

        boolean flag = true;
        int res = 0;
        //그 소수들로 나눠지는지 확인(String연산)
        for (int i = 2; i < K; i++) {
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            if (!isNotPrime[i]) {
                for (int j = 0; j < P.length(); j++) {
                    int temp = prev;
                    sb.append((prev + (P.charAt(j) - '0')) / i);
                    prev += (prev + (P.charAt(j) - '0')) % i;
                    prev -= temp;
                    prev *= 10;
                }

                if (prev == 0) {
                    flag = false;
                    if (sb.toString().length() > 7)
                        res = i;
                    else
                        res = Math.min(Integer.parseInt(sb.toString()), i);
                }
            }

            if(!flag)
                break;
        }

        if (flag) {
            System.out.println("GOOD");
        } else {

            System.out.println("BAD " + res);
        }
    }
}
```