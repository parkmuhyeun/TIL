# Brute force
#알고리즘/Brute force

---
## 완전탐색
모든 경우의 수를 시도 해보는 방법
- Exhaustive search, Brute force

- 상대적으로 구현이 간단하고, 해가 존재한다면 항상 찾게 된다.
- 경우의 수에 따라 실행 시간이 비례하기 때문에 입력 값의 범위가 작은 경우에 용이하다.

## 순차 탐색(Sequential search)
완전 탐색 알고리즘

```Java
int sequentialSearch(int[] arr, int n, int x)
{
    for( int i =0; i < n; ++i){
        if (arr[i] == x)
        return i;
    }
    return -1
}
```

## 경우의 수
순열(Permutation)
- 선택 순서가 결과에 영향을 미치는 경우

조합(Combination)
- 선택 순서가 결과에 영향을 주지 않는 경우

### 순열 예제 - 가장 큰 두 자리 수 구하기

```java
import java.util.*;

public class Main {
    static int N =4;
    static int[] Nums = {1, 2, 3, 4};


    static int solve(int cnt, int used, int val) {
        if(cnt == 2)
            return val;
        
        int ret = 0;
        for(int i =0; i < N; ++i>){
            if( (used & 1 << i) != 0 ) continue;
            ret = Math.max(ret, solve(cnt + 1, used | 1 << i, val * 10 + Nums[i]));
        }
        return ret;
    }
    
    public static void main(String[] args) {
        System.out.println(solve(0,0,0));
    }
}
```

### 조합 예제 - 가장 큰 두 수의 합 구하기

```java
import java.util.*;

public class Main {
    static int N =4;
    static int[] Nums = {1, 2, 3, 4};


    static int solve(int pos, int cnt, int val) {
        if(cnt == 2)
            return val;
        if(pos == N)
            return -1;
       
        int ret = 0;
        ret = Math.max(ret, solve(pos + 1, cnt + 1, val + Nums[pos]));
        ret = Math.max(ret, solve(pos + 1, cnt, val));

        return ret;
    }
    
    public static void main(String[] args) {
        System.out.println(solve(0,0,0));
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        dfs(0, n,  new int[m]);
    }
    private static void dfs(int idx, int n, int[] data) {
        if (idx == data.length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                data[idx] = i;
                dfs(idx + 1, n, data);
                visited[i] = false;
            }
        }
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class P15651 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dfs(0, n,  new int[m]);
        System.out.println(sb);
    }
    private static void dfs(int idx, int n, int[] data) {
        if (idx == data.length){
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            data[idx] = i;
            dfs(idx + 1, n, data);
        }
    }
}
```

```java
import java.io.*;

public class P9663 {
    static int n;
    static int[] posX = new int[16];
    static int[] posY = new int[16];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            dfs(0, i);
        }
        System.out.println(ans);
    }

    private static void dfs(int y, int x) {
        if (y == n-1){
            ans++;
            return;
        }

        posY[y] = y;
        posX[y] = x;
        for (int i = 0; i < n; i++) {
            if (!check(y + 1, i)) {
                continue;
            }
            dfs(y + 1, i);
        }
    }

    private static boolean check(int y, int x) {
        for (int i = 0; i < y; i++) {
            //가로
            if (posY[i] == y)
                return false;
            //세로
            if (posX[i] == x)
                return false;
            //대각
            if (Math.abs(posY[i] - y) == Math.abs(posX[i] - x))
                return false;
        }
        return true;
    }

}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class P15650 {

    static int m, n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        dfs(0, new int[n]);
        System.out.print(sb);
    }

    static void dfs(int idx, int[] data) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                sb.append(data[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < m+1; i++) {
            if (idx == 0 || (idx >= 1 && data[idx - 1] < i)) {
                data[idx] = i;
                dfs(idx+1, data);
            }
        }
    }
}

//(2)
// import java.io.*;
// import java.util.StringTokenizer;

// public class Main {

//     static int m, n;
//     static StringBuilder sb = new StringBuilder();
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         m = Integer.parseInt(st.nextToken());
//         n = Integer.parseInt(st.nextToken());
//         dfs(0, 0, new int[n]);
//         System.out.print(sb);
//     }

//     static void dfs(int idx, int at, int[] data) {
//         if (idx == n) {
//             for (int i = 0; i < n; i++) {
//                 sb.append(data[i] + " ");
//             }
//             sb.append("\n");
//             return;
//         }

//         for (int i = at + 1; i < m+1; i++) {
//             data[idx] = i;
//             dfs(idx+1, i, data);
//         }
//     }
// }
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class 15652 {

    static int m, n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        dfs(0, 1, new int[n]);
        System.out.print(sb);
    }

    static void dfs(int idx, int at, int[] data) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                sb.append(data[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < m+1; i++) {
            data[idx] = i;
            dfs(idx+1, i,  data);
        }
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class P14888 {
    static int n;
    static int[] num;
    static int[] op = new int[4];
    static boolean[] check;
    static int max = -987654321, min = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n];
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
            addOp(sb, i, op[i]);
        }

        dfs(0, new char[n-1], sb);
        System.out.print(max + "\n" + min);
    }

    static void dfs(int idx, char[] data, StringBuilder sb) {
        if (idx == n - 1) {
            int sum = num[0];
            for (int i = 1; i < n; i++) {
                sum = calculate(sum, num[i], data[i-1]);
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < n-1; i++) {
            if (!check[i]) {
                check[i] = true;
                data[idx] = sb.charAt(i);
                dfs(idx+1, data, sb);
                check[i] = false;
            }
        }
    }

    private static int calculate(int num1, int num2, char op) {
        if (op == '+')
            return num1 + num2;
        else if(op == '-')
            return num1 - num2;
        else if(op == '*')
            return num1 * num2;
        else
            return num1 / num2;
    }

    private static void addOp(StringBuilder sb, int type, int cnt) {
        if (type == 0) {
            for (int j = 0; j < cnt; j++) {
                sb.append("+");
            }
        }else if(type == 1){
            for (int j = 0; j < cnt; j++) {
                sb.append("-");
            }
        }else if(type == 2){
            for (int j = 0; j < cnt; j++) {
                sb.append("*");
            }
        }else{
            for (int j = 0; j < cnt; j++) {
                sb.append("/");
            }
        }
    }

}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class P14889 {
    static int n;
    static int[][] board;
    static int ans = 987654321;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, -1, new int[n/2]);
        System.out.println(ans);
    }

    static void dfs(int idx, int at, int[] start) {
        if (idx == n / 2) {
            int score = 0;
            int[] link = new int[n/2];
            int cnt = 0;
            boolean[] num = new boolean[n];
            for (int i = 0; i < n/2; i++) {
                num[start[i]] = true;
            }
            for (int i = 0; i < n; i++) {
                if (!num[i])
                    link[cnt++] = i;
                if (cnt == n/2)
                    break;
            }

            //start 계산
            for (int i = 0; i < n/2 - 1; i++) {
                for (int j = i+1; j < n / 2; j++) {
                    score += board[start[i]][start[j]] + board[start[j]][start[i]];
                }
            }

            //link 계산
            for (int i = 0; i < n/2 - 1; i++) {
                for (int j = i+1; j < n / 2; j++) {
                    score -= board[link[i]][link[j]] + board[link[j]][link[i]];
                }
            }

            ans = Math.min(ans, Math.abs(score));

            return;
        }

        for (int i = at + 1; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                start[idx] = i;
                dfs(idx + 1, i, start);
                check[i] = false;
            }
        }
    }

}
```