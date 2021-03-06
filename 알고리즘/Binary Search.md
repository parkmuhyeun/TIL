# Binary Search
#알고리즘/Binary Search

---

이진 탐색을 알아 보기 전 가장 기본 탐색 방법인 순차 탐색에 대해 알아보자

## 순차 탐색(Sequential Search)
리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차레대로 확인하는 방법

```python
def sequential_search(n, target, array):
    for i in range(n):
        if array[i] == target:
            return i + 1
```

## 이진탐색(Binary Search)
이진 탐색은 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다. 탐색 범위를 절반씩 좁혀가며 데이터를 탐색한다. 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는 방식 (시간 복잡도 - O(logN))

```python
# 재귀 함수 방식
def binary_search(array, target, start, end):
  if start > end:
    return None
  mid = (start + end) // 2
  # 찾은 경우 중간점 인덱스 반환
  if array[mid] == target:
    return mid
  # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
  elif array[mid] > target:
    return binary_search(array, target, start, mid - 1)
  # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
  else:
    return binary_search(array, target, mid + 1, end)

# n(원소의 개수)와 target(찾고자 하는 숫자)
n, target = map(int, input().split())
# 전체 원소 입력
array = list(map(int, input().split()))

# 이진 탐색 수행 결과 출력
result = binary_search(array, target, 0, n - 1)
if result == None:
  print("원소가 존재하지 않습니다.")
else:
  print(result + 1)
```

```python
# 반복문 방식
def binary_search(array, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    # 찾은 경우 중간점 인덱스 반환
    if array[mid] == target:
      return mid
    # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
    elif array[mid] > target:
      end = mid - 1
    # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
    else:
      start = mid + 1
  return None

# n(원소의 개수)와 target(찾고자 하는 숫자)
n, target = map(int, input().split())
# 전체 원소 입력
array = list(map(int, input().split()))

# 이진 탐색 수행 결과 출력
result = binary_search(array, target, 0, n - 1)
if result == None:
  print("원소가 존재하지 않습니다.")
else:
  print(result + 1)
```

## 빠르게 입력 받기
가끔 입력 데이터의 개수가 많은 문제에 input()함수를 사용하면 동작 속도가 느리서 시간 초과로 오답 판정을 받을 수 있다. 이처럼 입력 데이터가 많은 문제는 sys 라이브러리의 readline() 함수를 이용하면 시간 초과를 피할 수 있다.

```python
import sys

# 하나의 문자열 데이터 입력
input_data = sys.stdin.readline().rstrip() # Hello World

# 출력
print(input_data) # Hello World

```

## 관련 문제

```python
n = int(input())
narr = list(map(int, input().split()))
narr.sort()
m = int(input())
marr = list(map(int, input().split()))

def binary_search(arr, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    if arr[mid] == target:
      return "yes"
    elif arr[mid] > target:
      end = mid -1
    else:
      start = mid +1
  return "no"


for i in range(len(marr)):
  print(binary_search(narr, marr[i], 0, len(narr)-1), end=' ')
```

```python
def binary_search(arr, target, start, end):
  while start <= end:
    sum = 0
    mid = (start + end) // 2
    for i in range(len(arr)):
      if arr[i] > mid:
        sum += arr[i] - mid
    if sum == target:
      return mid
    elif sum > target:
      start = mid + 1
    else:
      end = mid - 1

n, m = map(int, input().split())
arr = list(map(int, input().split()))

max = max(arr)

h = binary_search(arr, m, 0, max)

print(h)
```

```python
import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

n, x = map(int, input().split())
arr = list(map(int, input().split()))

left = bisect_left(arr, x)
right = bisect_right(arr, x)

if left-right == 0:
  print("-1")
else:
  print(right-left)
```

```python
import sys
input = sys.stdin.readline

def binary_search(start, end):
  if start > end:
    return None
  mid = (start + end) // 2
  if arr[mid] == mid:
    return mid
  elif arr[mid] < mid:
    return binary_search(mid+1, end)
  else:
    return binary_search(start, mid-1)

n = int(input())
arr = list(map(int, input().split()))
res = binary_search(0, n-1)
if res == None:
  print("-1")
else:
  print(res)
```

```python
n, c = map(int, input().split())
arr = []
for _ in range(n):
  arr.append(int(input()))
arr.sort()

start = 1
end = arr[-1] - arr[0]
res = 0

while start <= end:
  mid = (start + end) // 2
  value = arr[0]
  count = 1
  for i in range(1, n):
    if arr[i] >= value + mid:
      value = arr[i]
      count += 1
  if count >= c:
    start = mid + 1
    res = mid
  else:
    end = mid - 1

print(res)
```

```python
from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

n, x = map(int, input().split())
nums = list(map(int, input().split()))

res = bisect_right(nums, x) - bisect_left(nums, x)
if res == 0:
  print(-1)
else:
  print(res)

#bisect 안쓰고
# def count_by_value(array, x):
#   n = len(array)
#   a = first(array, x, 0, n-1)
  
#   if a == None:
#     return 0
    
#   b = last(array, x, 0, n-1)
  
#   return b - a + 1

# def first(array, target, start, end):
#   if start > end:
#     return None

#   mid = (start + end) // 2
#   if (mid == 0 or target > array[mid - 1]) and array[mid] == target:
#     return mid
#   elif array[mid] >= target:
#     return first(array, target, start, mid - 1)
#   else:
#     return first(array, target, mid + 1 , end)

# def last(array, target, start, end):
#   if start > end:
#     return None

#   mid = (start + end) // 2
#   if (mid == n-1 or target < array[mid + 1]) and array[mid] == target:
#     return mid
#   elif array[mid] > target:
#     return last(array, target, start, mid - 1)
#   else:
#     return last(array, target, mid + 1 , end)

# import sys
# input = sys.stdin.readline

# n, x = map(int, input().split())
# nums = list(map(int, input().split()))

# res = count_by_value(nums, x)
# if res == 0:
#   print(-1)
# else:
#   print(res)
```

```python
#review
import sys
input = sys.stdin.readline

def binary_search(array, start, end):
  if start > end:
    return None
  mid = (start + end) // 2
  if array[mid] == mid:
    return mid
  elif mid < array[mid]:
    return binary_search(array, start, mid -1)
  else:
    return binary_search(array, mid + 1, end)

n = int(input())
array = list(map(int, input().split()))

res = binary_search(array, 0, n-1)
if res == None:
  print(-1)
else:
  print(res)
```

```python
#review
n, c = map(int, input().split())
pos = []
for _ in range(n):
  pos.append(int(input()))
pos.sort()

start = 1
end = pos[n-1] - pos[0]
result = 0

while start <= end:
  mid = (start + end) // 2
  value = pos[0]
  cnt = 1
  for i in range(1, n):
    if pos[i] >= value + mid:
      cnt += 1
      value = pos[i]
  if cnt >= c:
    start = mid + 1
    result = mid
  else:
    end = mid - 1
print(result)
```

```python
from bisect import bisect_left, bisect_right

def solution(words, queries):
    answer = []
    array = [[] for _ in range(10001)]
    reverse_array = [[] for _ in range(10001)]
    for word in words:
        array[len(word)].append(word)
        reverse_array[len(word)].append(word[::-1])
        
    for i in range(10001):
        array[i].sort()
        reverse_array[i].sort()

    for q in queries:
        if q[0] != '?':
            res = bisect_right(array[len(q)], q.replace('?', 'z')) - bisect_right(array[len(q)], q.replace('?', 'a'))
        else:
            res = bisect_right(reverse_array[len(q)], q[::-1].replace('?', 'z')) - bisect_right(reverse_array[len(q)], q[::-1].replace('?', 'a'))
        answer.append(res)

    return answer
```

```python
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

if n == 1:
  print(trees[0] - m)
else:
  trees.sort()
  start = 1
  end = trees[n-1]
  res = 0
  while start <= end:
    mid = (start + end) // 2
    sum = 0
    
    for tree in trees:
      if tree > mid:
        sum += tree - mid
    if sum == m:
      res = mid
      break
    if sum > m:
      res = mid
      start = mid + 1
    else:
      end = mid - 1
  print(res)
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 0;
        int sum = arr[0];
        int res = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                res = Math.min(res, high - low + 1);
                sum -= arr[low++];
            } else if (sum < S) {
                sum += arr[++high];
            }

            if (high == N)
                break;

        }

        if (res == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(res);
    }
}
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2003 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String br1 = br.readLine();
        String[] split1 = br1.split(" ");
        N = Integer.parseInt(split1[0]);
        M = Integer.parseInt(split1[1]);
        arr = new int[N+1];

        String br2 = br.readLine();
        String[] split2 = br2.split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split2[i]);
        }


        int low = 0;
        int high = 0;
        int res = 0;
        int sum = arr[low];

        while (true) {
            if (sum > M) {
                sum -= arr[low++];
            } else if (sum == M) {
                res += 1;
                sum -= arr[low++];
            }
            else {
                sum += arr[++high];
            }

            if (high == N)
                break;
        }

        System.out.println(res);

    }
}
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2143 {

    static int T, N, M;
    static int[] a;
    static int[] b;
    static int[] subA;
    static int[] subB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        subA = new int[(N * (N+1) / 2)];
        subB = new int[(M * (M+1) / 2)];

        getCnt(0, a, subA);
        getCnt(0, b, subB);

        sortSubB();
        Arrays.sort(subA);

        int pointA = 0;
        int pointB = 0;
        int sum = subA[pointA] + subB[pointB];
        long res = 0;
        while (true) {
            //sum == T랑 같을시
            if (sum == T) {
                long mulA = 1;
                long mulB = 1;
                for (int i = pointA+1; i < subA.length; i++) {
                    if (subA[i] == subA[i - 1]) {
                        pointA++;
                        mulA += 1;
                    }else{
                        break;
                    }
                }

                for (int i = pointB+1; i < subB.length; i++) {
                    if (subB[i] == subB[i - 1]) {
                        pointB++;
                        mulB += 1;
                    }else{
                        break;
                    }
                }
                res += mulA * mulB;
                pointA++;
                pointB++;
                if (pointA == subA.length || pointB == subB.length) {
                    break;
                }
                sum = subA[pointA] + subB[pointB];
            } else if (sum < T) {
                sum -= subA[pointA++];
                if (pointA == subA.length) {
                    break;
                }
                sum += subA[pointA];
            } else {
                sum -= subB[pointB++];
                if (pointB == subB.length) {
                    break;
                }
                sum += subB[pointB];
            }

        }

        System.out.println(res);

    }

    private static void sortSubB() {
        Integer temp[] = new Integer[subB.length];
        for (int i = 0; i < subB.length; i++) {
            temp[i] = subB[i];
        }
        Arrays.sort(temp, Collections.reverseOrder());
        for (int i = 0; i < subB.length; i++) {
            subB[i] = temp[i];
        }
    }

    private static void getCnt(int cnt, int[] ori, int[] sub) {
        for (int i = 0; i < ori.length; i++) {
            int sum = 0;
            for (int j = i; j < ori.length; j++) {
                sum += ori[j];
                sub[cnt++] = sum;
            }
        }
    }
}
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Long[] trees = new Long[N];

        st = new StringTokenizer(br.readLine());
        long start = 1;
        long end = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            end = Math.max(end, trees[i]);
        }

        long mid;
        long res = 0;

        while (true) {
            mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum = getSum(trees, mid, sum, i);
            }

            if (sum == M) {
                res = mid;
                break;
            } else if (sum > M) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (start > end) {
                break;
            }
        }

        System.out.println(res);
    }

    private static long getSum(Long[] trees, long mid, long sum, int i) {
        if (trees[i] > mid)
            sum += trees[i] - mid;
        return sum;
    }
}
```