# Index Tree
#알고리즘/Index Tree

---

```java
//java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IndexTree {
    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S =1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[S * 2];
    }

    static void initBU() {
        // Leaf에 값 반영
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부노드 채움
        for (int i = S-1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        //연관이 없음 -> 결과에 영향이 없는 값 return
        if (queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 판단불가, 자식에게 위임, 자식에서 올라온 합을 return
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1 , right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }

    static void update(int left, int right, int node, int target, int diff) {
        //연관없음
        if (target < left || right < target) {
            return;
        }
        //연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    static long queryBu(int queryLeft, int queryRight) {
        //Leaf 에서 left, right 설정
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;
        long sum = 0;
        while (left <= right) {
            //좌측 노드가 홀수이면 현재 노드 값 사용하고 한칸 옆으로
            if (left % 2 == 1) {
                sum += tree[left++];
            }
            // 우측 노드가 짝수이면 현재 노드 값 사용하고 한칸 옆으로
            if (right % 2 == 1) {
                sum += tree[right--];
            }
            // 좌측, 우측 모두 부모로 이동
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void updateBU(int target, long value) {
        //Leaf에서 target을 찾음
        int node = S + target -1;
        //value 반영
        tree[node] = value;
        //Root에 도달할 때 까지
        node /= 2;
        while (node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2243 {
    static int N;
    static int[] trees;
    static int S = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (S < 1000000) {
            S *= 2;
        }
        trees = new int[2 * S];

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                //출력(몇번쨰꺼) B
                int b = Integer.parseInt(st.nextToken());
                int idx = query(1, S, 1, b);
                System.out.println(idx);
                update(1, S, 1, idx, -1);
            } else {
                //수정(+, -) B C
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(1, S, 1, b, c);
            }
        }
    }

    static int query(int left, int right, int node, int target) {
        if (left == right)
            return left;

        int mid = (left + right) / 2;
        if (trees[node * 2] >= target) {
            return query(left, mid, node * 2, target);
        } else {
            return query(mid + 1, right, node * 2 + 1, target - trees[node * 2]);
        }
    }

    static void update(int left, int right, int node, int target, int diff) {
        // 연관없음
        if (target < left || right < target) {
            return;
        }
        // 연관있음
        else {
            trees[node] += diff;
            if (left != right) {
                int mid = (left + right ) / 2;
                update(left, mid, 2 * node, target, diff);
                update(mid + 1 , right, 2 * node + 1, target, diff);
            }
        }
    }
}
```