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