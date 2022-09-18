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