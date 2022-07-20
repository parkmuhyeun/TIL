# Sorting
#알고리즘/Sorting

---
정렬이란 데이터를 특정한 기준에 따라서 순서대로 나열하는 것

## 선택 정렬(Selection Sort)
데이터가 무작위로 여러 개 있을 때, 이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두번째 데이터와 바꾸는 과정을 반복 (시간 복잡도 - O(N^2))

```python
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i # 가장 작은 원소의 인덱스
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i] # Swap

print(array) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## 삽입 정렬(Insertion Sort)
'데이터를 하나씩 확인하며, 각 데이터를 적절한 위치에 삽입', 특히 삽입 정렬은 필요할 때만 위치를 바꾸므로 '데이터가 거의 정렬 되어 있을 때' 훨신 효율적이다. (시간 복잡도 - O(N^2), 최선의 경우(거의 정렬 되어있을 때) - O(N))

```python
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
    for j in range(i, 0, -1):   # 인덱스 i부터 1까지 감소하며 반복
        if array[j] < array[j-1]:
            array[j], array[j-1] = array[j-1], array[j]
        else:
            break

print(array) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## 퀵 정렬(Quick Sort)
'기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 변경', 리스트에서 첫 번째 데이터를 기준(pivot)으로 정한 후 왼쪽에서부터 피벗보다 큰 데이터를 찾고, 오른쪽에서부터 피벗보다 작은 데이터를 찾는다. 그 다음 큰 데이터와 작은 데이터의 위치를 서로 교환한다. 값이 서로 엇갈린 경우에는 '작은 데이터를 찾던 데이터 부분'과 '피벗'의 위치를 서로 변경한다. 이러한 과정을 반복하면 피벗에 대하여 정렬이 수행된다. (평균 시간 복잡도 - O(NlogN), 최악의 경우(이미 데이터가 정렬되어 있는 경우) - O(N^2))

```python
# 일반적인 퀵 정렬

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end: # 원소가 1개인 경우 종료
        return
    pivot = start # 피벗은 첫 번째 원소
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 피벗보다 작은 데이터를 찾을 때까지 반복
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if right < left: # 엇갈렷다면 작은 데이터와 피벗을 교체
            array[pivot], array[right] = array[right], array[pivot]
        else: # 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            array[left], array[right] = array[right], array[left]
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
    quick_sort(array, start, right-1)
    quick_sort(array, right+1, end)


quick_sort(array, 0, len(array)-1)
print(array) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

```python
# 파이썬의 장점을 살린 퀵 정렬

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        return array
    
    pivot = array[0] # 피벗은 첫 번째 원소
    tail = array[1:] # 피벗을 제외한 리스트
    
    left_side = [x for x in tail if x <= pivot] # 분할된 왼쪽 부분
    right_side = [x for x in tail if x > pivot] # 분할된 오른쪽 부분
    
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트를 반환
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(array)) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## 계수 정렬(Count Sort)
계수 정렬 알고리즘은 특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠른 정렬 알고리즘. 데이터의 개수가 N, 데이터 중 최댓값이 K일 때, 계수 정렬은 최악의 경우에도 수행 시간 O(N+K)를 보장한다. 계수 정렬을 이용할 때는 모든 범위를 담을 수 있는 크기의 리스트를 선언 해야 하기 때문에 가장 작은 데이터와 가장 큰 데이터의 차이가 너무 크다면 사용할 수 없다. 동작 방식은, 먼저 가장 큰 데이터와 가장 작은 데이터의 범위가 모두 담길 수 있도록 하나의 리스트를 생성한다. 그다음 데이터를 하나씩 확인하며 데이터의 값과 동일한 인덱스의 데이터를 1씩 증가시키면 계수정렬이 완료 된다.

```python
# 모든 원소의 값이 0보다 크거나 같다고 가정
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]

# 모든 범위를 포함하는 리스트 선언(모든 값은 0으로 초기화)
count = [0] * (max(array)+1)

for i in range(len(array)):
    count[array[i]] += 1 # 각 데이터에 해당하는 인덱스의 값 증가

for i in range(len(count)):
  for j in range(count[i]):
    print(i, end=' ');
```

## 파이썬의 정렬 라이브러리
파이썬은 기본 정렬 라이브러리인 sorted() 함수를 제공한다. sorted()는 퀵 정렬과 동작 방식이 비슷한 병합 정렬을 기반으로 만들어졌는데, 병합 정렬은 일반적으로 퀵 정렬보다 느리지만 최악의 경우에도 시간 복잡도 O(NlogN)을 보장한다는 특징이 있다.

```python
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

result =sorted(array)
print(result) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## 관련 문제

```python
n = int(input())

array = []
for i in range(n):
  m = int(input())
  array.append(m)

array.sort(reverse = True)

for i in array:
  print(i, end = ' ')
```

```python
n = int(input())

array = []
for i in range(n):
  name, score = input().split()
  array.append((name, int(score)))

array.sort(key=lambda array:array[1])

for student in array:
  print(student[0], end = ' ')
```

```python
n, k = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse=True)

for i in range(k):
  if a[i] < b[i]:
    a[i], b[i] = b[i], a[i]
  else:
    break

print(sum(a))
```

```python
n = int(input())
grade = []

for _ in range(n):
  name, k, e, m = input().split()
  grade.append((name, int(k), int(e), int(m)))

grade.sort(key = lambda x: (-x[1], x[2], -x[3], x[0]))

for i in range(n):
  print(grade[i][0])
```

```python
import sys
input = sys.stdin.readline

n = int(input())
pos = list(map(int, input().split()))
pos.sort()
print(pos[(n - 1) // 2])
```

```python
def solution(N, stages):
    clear = [0] * (N+1)
    reach = [0] * (N+1)
    num = [0] * (N+2)
    
    for i in range(len(stages)):
        stage = stages[i]
        num[stage] += 1
    
    for _ in range(num[1]):
        reach[1] += 1
    
    for i in range(2, N+1):
        cnt = num[i]
        if cnt == 0:
            continue
        for j in range(1, i):
            clear[j] += cnt
            reach[j] += cnt
        reach[i] += cnt
    
    for i in range(1, N+1):
        clear[i] += num[N+1]
        reach[i] += num[N+1]
    
    answer = []
    for i in range(1, N+1):
        if reach[i] == 0:
            answer.append((0, i))
        else:
            answer.append(((reach[i]-clear[i])/reach[i], i))
    answer.sort(key = lambda x: (-x[0], x[1]))
    res = []
    for i in range(N):
        res.append(answer[i][1])
    return res
```

```python
import heapq

n = int(input())
h = []
for _ in range(n):
  num = int(input())
  heapq.heappush(h, num)

res = 0
while len(h) != 1:
  x = heapq.heappop(h)
  y = heapq.heappop(h)
  res += x+y
  heapq.heappush(h, x+y)
print(res)
```

```python
#review
n = int(input())
student = []
for i in range(n):
  row = list(input().split())
  stu = []
  stu.append(row[0])
  for j in range(1, 4):
    stu.append(int(row[j]))
  student.append(stu)

student.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for s in student:
  print(s[0])
```

```python
#review
import sys
input = sys.stdin.readline

n = int(input())
homes = list(map(int, input().split()))
homes.sort()
if n % 2 == 0:
  print(homes[(n//2) -1])
else:
  print(homes[n//2])

# import sys
# input = sys.stdin.readline

# n = int(input())
# homes = list(map(int, input().split()))
# homes.sort()
# print(homes[(n-1) // 2])
```

```python
def solution(N, stages):
    cnt = [0] * (N+2)
    success = [0] * (N+1)
    reach = [0] * (N+1)
    fail = []
    res = []
    
    for x in stages:
        cnt[x] += 1
    
    for i in range(1, N+2):
        mul = cnt[i]
        for j in range(1, i):
            reach[j] += mul
            success[j] += mul
        if i != N+1:
            reach[i] += mul
        
    for i in range(1, N+1):
        if reach[i] == 0:
            fail.append((0, i))
        else:
            fail.append(((reach[i] - success[i]) / reach[i], i))
    fail.sort(key=lambda x: (-x[0], x[1]))
    for i in range(N):
        res.append(fail[i][1])
    return res
```

```python
import heapq
n = int(input())
res = 0
cards = []

for i in range(n):
  heapq.heappush(cards, int(input()))

while True:
  if len(cards) == 1:
    break
  first = heapq.heappop(cards)
  second = heapq.heappop(cards)
  new = first + second
  res += new
  heapq.heappush(cards, new)
print(res)
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1072 {
    static double X, Y;
    static double Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Math.floor((Y * 100) / X);

        int min = 1;
        int max = (int) X;
        int res = Integer.MAX_VALUE;

        if (Z >= 99) {
            System.out.println("-1");
        } else {
            while (true) {
                int mid = (min + max) / 2;
                double rate = Math.floor(((Y + (double)mid)) * 100 / ((X + (double) mid)));

                if (rate > Z) {
                    res = Math.min(res, mid);
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }

                if (min > max) {
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P1713 {

    static int N, M;
    static int[] exist = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String br1 = br.readLine();
        N = Integer.parseInt(br1);
        String br2 = br.readLine();
        M = Integer.parseInt(br2);
        int[] nums = new int[M];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        ArrayList<Item> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            if (exist[nums[i]-1] != 0) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).studentNum == nums[i]) {
                        list.get(j).recommendation += 1;
                        break;
                    }
                }
            }else{
                if (list.size() == N) {
                    exist[list.get(N-1).studentNum-1] = 0;
                    list.remove(N-1);
                }
                list.add(new Item(nums[i], i, 1));
                exist[nums[i]-1] = 1;
            }
            Collections.sort(list);
        }

        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.studentNum, o2.studentNum);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).studentNum);
            if (i != N-1)
                System.out.print(" ");
        }

    }

}

class Item implements Comparable<Item> {
    int studentNum;
    int order;
    int recommendation;

    public Item(int studentNum, int order, int recommendation) {
        this.studentNum = studentNum;
        this.order = order;
        this.recommendation = recommendation;
    }

    @Override
    public int compareTo(Item o) {
        if (recommendation > o.recommendation) {
            return -1;
        } else if (recommendation == o.recommendation) {
            return o.order - order;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Item{" + "studentNum=" + studentNum + ", order=" + order + ", recommendation=" + recommendation + '}';
    }
}
```

```java
//java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1927 {

    static int N;
    static int[] heap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int height = 0;
        int tempN = N;
        while (tempN != 0) {
            tempN /= 2;
            height += 1;
        }
        int all = 1;
        while (height != 0) {
            all *= 2;
            height--;
        }
        heap = new int[all];

        int last = 1;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            int parent;
            int pos;

            if (value != 0) {
                pos = last;
                parent = last / 2;

                while (pos != 1) {
                    if (heap[parent] > value) {
                        heap[pos] = heap[parent];
                        pos = parent;
                        parent /= 2;
                    } else {
                        break;
                    }
                }

                heap[pos] = value;
                last++;
            } else {
                if (heap[1] == 0)
                    System.out.println("0");
                else {
                    System.out.println(heap[1]);

                    int lastVal = heap[last-1];
                    heap[last-1] = 0;

                    if(heap[1] == 0)
                        continue;
                    pos = 1;
                    parent = pos * 2;
                    while (pos < all) {
                        if (heap[parent] == 0)
                            break;
                        int child = heap[parent];
                        if (heap[parent+1] != 0 && (heap[parent] > heap[parent+1]))
                            child = heap[++parent];
                        if (child < lastVal) {
                            heap[pos] = child;
                            pos = parent;
                            parent *= 2;
                        } else {
                            break;
                        }

                    }

                    heap[pos] = lastVal;
                    last--;
                }
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202 {
    static int N, K;
    static Jewelry[] jewelries;
    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(Comparator.comparingInt(Jewelry::getValue).reversed());

        int jIndex = 0;
        long result = 0;
        for (int i = 0; i < K; i++) {
            while (jIndex < N && jewelries[jIndex].weight <= bags[i]) {
                pq.add(jewelries[jIndex++]);
            }

            if (!pq.isEmpty())
                result += pq.poll().value;
        }

        System.out.println(result);
    }
}

class Jewelry {
    int weight;
    int value;

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
```