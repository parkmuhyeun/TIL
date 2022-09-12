# Grammer for Test(Java)
##알고리즘/Grammer for Test(Java)

---

## ArrayList
깊은 복사
- ArrayList를 깊은복사하고 싶다면, 복사되는배열.addAll(복사할배열)
```java
ArrayList<Integer> arr=new ArrayList<Integer>();
ArrayList<Integer> copy_arr=new ArrayList<Integer>();
copy_arr.addAll(arr);
```

Sort
- ArrayList를 정렬하고 싶을때, 리스트명.sort()
```java
ArrayList<Integer> ArrList=new ArrayList<Integer>();
ArrList.sort(null);
```

Size
- ArrayList의 크기는 리스트명.size()
```java
ArrayList<Integer> arr=new ArrayList<Integer>();
arr.size();
```

## List
set => List 변경
- 생성자에 값을 넣어주면, set -> List로 변경 가능
```java
Set<String> set = new HashSet<String>();
List<String> menuList = new ArrayList<>(set);
```

Sort
- List를 정렬하고자 할 때, Collection.sort(리스트명)
```java
List<Stirng> list = new ArrayList<>();
Collections.sort(menuList);
```

Add
- List에 값을 넣을 때, 리스트명.add(넣을 값)
```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(1);
```

remove
- List의 값을 삭제할 때, 리스트명.remove(삭제할 값 index)
```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.remove(list.size()-1) // 마지막값 삭제
```

Size
- List의 크기는 리스트명.size() 메소드를 사용
```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.size();
```

## Array
Sort
- Array를 정렬하고자 할 때, Array.sort(배열명)
```java
int [] Arr = new int[5];
Arrays.sort(Arr);
```

length
- Array의 길이는 배열명.length
```java
int [] Arr = new int[5];
Arr.length;
```

String to Char Array
- String을 char 배열로 변환할 때, toCharArray()
```java
char[][] arr=new char[5][5];

// String 입력을 char형 Array로 변환
for(int i=0;i<5;i++){
	arr[i]=br.readLine().toCharArray();
}

// String to char Array
String str="12345";
arr[0]=str.toCharArray();
        
System.out.println(arr[0]);

[출력]
12345
```

배열 특정 범위 자르기
- 배열에서 특정 범위를 자르고, 다른 배열에 저장할 때 Arrays.copyOfRange(배열명, 시작점, 끝점)
- 이 때, 범위는 시작점 이상 끝점 미만의 범위
```java
int[] array={1,2,3,4,5};
int[] temp=Arrays.copyOfRange(array,1,3);
System.out.println(temp);

[출력]
[2,3]
```

## Set
값 넣기(add)
- Set에 값을 넣을 때는, set명.add(넣을 값)
```java
Set<String> set = new HashSet<String>();
set.add("hello");
```

값 삭제(remove)
- Set에서 값을 삭제할 때는, set명.remove(삭제할 값)
```java
Set<String> set = new HashSet<String>();
set.remove("hello");
```

Iterator
- set의 값을 조회할 때, set명.iterator() 를 사용해 반복자를 생성한다.
- 반복자.hasNext() 메소드로 다음 값이 존재하는지 확인한다.
- 반복자.next() 메소드로 참조값을 가져온다.
```java
Set<String> set= new HashSet<String>();

set.add("1");
set.add("2");
set.add("3");

Iterator<String> ite = set.iterator();
while(ite.hasNext()){
	String a= ite.next();
	System.out.println(a);
}

[결과]
1
2
3
```

Size
- set의 크기는 set명.size()
```java
Set<String> set= new HashSet<String>();
set.size();
```

## Map
값 넣기(put)
- Map에 {key:value} 값을 설정할 때, map.put(key, value)
```java
Map<String,Integer> map=new HashMap<>();
map.put("word1",1);
```

값 가져오기(get)
- Map의 {key:value} 쌍의 valuie 값을 가져올 때, map명.get(key값)
```java
Map<String,Integer> map=new HashMap<>();
map.get("word1")
```

Key 값 존재 확인(containsKey)
- Map에 해당하는 key 값이 존재하는지 확인할 때, map명.containsKey(key값)
- Key값이 존재하면 true, 존재하지 않으면 false
```java
Map<String,Integer> map=new HashMap<>();
map.containsKey("word1");
```

Iterator
- map의 값을 조회할 때, map명.keySet().iterator()를 사용해 반복자를 생성
- 반복자.hasnext() 메소드로 다음 값이 존재하는지 확인
- 반복자.next() 메소드로 참조값 가져옴
```java
Map<String,Integer> map=new HashMap<>();
Iterator<String> it= map.keySet().iterator();

while(it.hasNext()){
	String key=it.next();
	int value=map.get(key);
}
```

Size
- Map의 크기는 map명.size()
```java
Map<String,Integer> map=new HashMap<>();
map.size();
```

## String
소문자, 대문자
- String 문자열의 문자 값을 대문자에서 소문자로 변경할 때, toLowerCase()
```java
String s="ABC";
s=s.toLowerCase();
//"abc";
```
- String 문자열의 문자 값을 소문자에서 대문자로 변경할 때, toUpperCase()
```java
String s="abc";
s=s.toUpperCase();
//"ABC";
```

String to Array
- String 문자열을 Array로 만들 때, 스트링명.split()
```java
String s = "12345";
String[] arr = s.split("");
//[1,2,3,4,5]
```

문자열 자르기(substring)
- String 문자열 일부를 추출할 때, 스트링명.substring()
- 스트링명.substring(idx): idx를 포함한 위치부터 문자열 끝까지 추출
- 스트링명.substring(시작값, 끝 값): 시작값 부터 끝 값-1까지 추출
```java
String s="1234567";
s.substring(3); // "4567"
s.substring(2,5) // "345"
```

문자열 뒤집기(Reverse)
- String 문자열을 뒤집기 할 때, StringBuilder(문자열).reverse().toString()
```java
String s = "Reverse";
String str = new StringBuilder(s).reverse().toString();
System.out.println(str);

[출력]
esreveR
```

length
- String의 길이는 문자열명.length()
```java
String s = "123";
s.length();
```

String값 변경하기
- Java에서 String은 immutable, 한번 할당되면 변경이 불가능
- 따라서, substring 메소드를 활용해 새로운 문자열을 생성
```java
String name="starfucks";
String newname=name.substring(0,4)+'b'+name.substring(5);

System.out.pirntln(newname); // starbucks
```

## StringBuilder
- StringBuilder 클래스로 문자열에 문자를 추가하거나, 삭제할 수 있다.

추가(append)
- 추가할 때는, 빌더명.append(넣을 문자)
```java
StringBuilder sb=new StringBuilder();

sb.append('a');
sb.append('b');
sb.append('c');

System.out.println(sb);

[출력]
abc
```

삭제(deleteCharAt)
- 삭제할 때는, 빌더명.deleteCharAt(삭제할 문자 인덱스)
```java
StringBuilder sb=new StringBuilder();

sb.append('a');
sb.append('b');
sb.append('c');

System.out.println(sb);

sb.deleteCharAt(1);

System.out.println(sb);

[출력]
abc
ac
```

StringBuilder 값 변경
- StringBuilder 객체 특정 값을 변경할 때, 빌더명.setCharAt(인덱스, 문자)
```java
StringBuilder name = new StringBuilder("starfucks");
name.setCharAt(4, 'b');

System.out.println(name); // starbucks
```

## 입/출력

## BufferReader
- BufferReader 클래스는 Enter를 경계로 입력값을 인식
- readLine()은 개행문자를 포함해 String 형식으로 입력을 받아온다.
	- 따라서, int형으로 입력할려면 Integer.parseInt()로 형변환이 필요
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    System.out.print(input);
}

[입력]
200

[출력]
200
```

## StringTokenizer
- StringTokenizer 클래스는 지정한 형식에 따라 문자열을 쪼개주는 클래스
- new StringTokenizer(문자열, 기준) 형식으로 StringTokenizer 객체를 생성
```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int front = Integer.parseInt(st.nextToken());
    int back = Integer.parseInt(st.nextToken());

    System.out.print(front+ " "+back);
}

[입력]
123 456

[출력]
123 456
```

예1)
```java
public static void main(String args[])throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());

    int N= Integer.parseInt(st.nextToken());
    int M= Integer.parseInt(st.nextToken());
	
    int [][]arr= new int[N][M];
    for(int i=0;i<N;i++){
        String str=br.readLine();
        for(int j=0;j<M;j++){
            arr[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
        }
    }

    System.out.print(N+" "+M);
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            System.out.print(arr[i][j]);
        }
        System.out.println();
    }
}

[입력]
3 3
111
222
333

[출력]
3 3
111
222
333
```

예2)
```java
public static void main(String args[])throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int N=Integer.parseInt(br.readLine());

    for(int i=0;i<N;i++){
		int M=Integer.parseInt(br.readLine());
        System.out.println(M);
    }
}

[입력]
5
1
2
3
4
5

[출력]
1
2
3
4
5
```

## Queue
생성
```java
import java.util.Queue;
Queue<Integer> queue=new LinkedList<>();
Queue<String> queue= new LinkedList<>();
```

삽입(add)
- Queue에 원소를 추가할 때는, 큐명.add(원소)
```java
Queue<Integer> queue=new LinkedList<>();
queue.add(1);
queue.add(2);
```

꺼내기(poll)
- queue의 가장 앞의 원소를 꺼내고 삭제할 떄는, 큐명.poll()
```java
Queue<Integer> queue=new LinkedList<>();
queue.add(1);
int first=queue.poll();
```

첫번째 값 참조(peek)
- queue에서 첫번째 값을 참조하고 싶다면, 큐명.peek()
```java
Queue<Integer> queue=new LinkedList<>();
queue.add(1);
int first= queue.peek();
```

pair
```java
    static class Node{
        int y;
        int x;
        int dist;
        Node(int y,int x,int dist){
            this.y=y;
            this.x=x;
            this.dist=dist;
        }
    }

    public static void main(String[] args){
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(1,2,3));
        Node node= queue.poll();
        System.out.println(node.x);
    }
```

## PriorityQueue

생성
- 생성자에 Collections를 사용해 오름차순, 내림차순 설정가능(default: 오름차순)
```java
import java.util.PriorityQueue;

//오름차순
PriorityQueue<Integer> pq=PriorityQueue<Integer>();
PriorityQueue<String> pq=PriorityQueue<String>();

//내림차순
PriorityQeueu<Integer> pq=PriorityQueue<Integer>(Collections.reverseOrder());
```

삽입(add)
- PriorityQueue에 원소를 삽입할 때, pq명.add(원소)
```java
PriorityQueue<Integer> pq=PriorityQueue<Integer>();
pq.add(1); 
pq.add(2);
```

제거(remove)
- PriorityQueue의 가장 앞의 원소를 제거할 때, pq명.remove()
```java
PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
pq.add(2);pq.add(12);pq.add(13);

System.out.println(pq);
pq.remove();
System.out.println(pq);

[출력]
[13, 2, 12]
[12, 2]
```

minHeap & maxHeap
- PriorityQueue의 minHeap, maxHeap 에 접근할 때, pq명.peek()
```java
PriorityQueue<Integer> pq=PriorityQueue<Integer>();
pq.add(1); 
pq.add(2);
pq.add(13); 

System.out.println(pq.peek()); // 1
```

```java
PriorityQueue<Integer> pq=PriorityQueue<Integer>(Collections.reverseOrder());
pq.add(1); 
pq.add(2);
pq.add(13); 

System.out.println(pq.peek()); // 13
```

pair
- compare 메소드를 만들고, 생성자에 포함시키면 된다.
```java
import java.io.IOException;
import java.util.PriorityQueue;
public class PQ {

    static class Node{
        int y;
        int x;

        Node(int y,int x){
            this.y=y;
            this.x=x;
        }

        public int compareTo(Node p) {
            if(this.y < p.x) {
                return -1; // 오름차순
            }
            else if(this.y == p.y) {
                if(this.x < p.x) {
                    return -1;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException{

        PriorityQueue<Node> pq1=new PriorityQueue<>(Node::compareTo);
        pq1.add(new Node(1,2));
        pq1.add(new Node(1,1));
        pq1.add(new Node(2,3));
        pq1.add(new Node(2,1));

        while(!pq1.isEmpty()){
            Node node=pq1.peek();
            System.out.println(node.y+" "+node.x);
            pq1.remove();
        }
    }
}

[출력]
1 1
1 2
2 1
2 3
```

## 인접리스트 구현
```java
public static void main(String[] args){
    int[][] arr = {{1, 3}, {1, 5}, {3, 2}};
    ArrayList<ArrayList<Integer>> list=new ArrayList<>();

    // 인접리스트 초기화
    for(int i=0; i <= 5;i++){
        list.add(new ArrayList<>());
    }
	
    // 양방향 인접리스트
    for(int i=0;i< arr.length;i++){
        int start=arr[i][0],end=arr[i][1];
        list.get(start).add(end);
        list.get(end).add(start);
    }
    System.out.println(list);
}
```

pair
```java
static class Pair implements Comparable<Pair> {
    int first, second;
    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
    public int compareTo(Pair p) {
        if(this.first > p.first) {  //내림차순
            return -1;
        }
        else if(this.first == p.first) {
            if(this.second < p.second) {    // 오름차순
                return -1;
            }
        }
        return 1;
    }
}
```

## 출력

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write("hi");
bw.flush();
bw.close();
```

## 순열 (Permutation)

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  
  public static void main(String[] args) {
    List<int[]> permutations = new ArrayList<>();
    int[] arr = {1, 2, 3, 4, 5};
    boolean[] visited = new boolean[10];
    
    perm(permutations, arr, new int[2], visited, 0);
    for (int[] permutation : permutations)
      System.out.println(Arrays.toString(permutation));
  }

  static void perm(List<int[]> permutations, int[] arr, int[] data, boolean[] visited, int depth){
    if (depth == data.length) {
      int[] clone = data.clone();
      permutations.add(clone);
      return;
    }

    for (int i =0; i< arr.length; i++){
      if (visited[i] != true) {
        visited[i] = true;
        data[depth] = arr[i];
        perm(permutations, arr, data, visited, depth + 1);       
        visited[i] = false;  
      }
    }
  }
  
}
```

## 조합(Combination)

```java
static void combination(List<int[]> combinations, int data[], int start, int end, int idx) {
    if (idx == data.length) {
        int[] clone = data.clone();
        combinations.add(clone);
    } else if (start <= end){
        data[idx] = start;
        combination(combinations, data, start + 1, end, idx + 1);
        combination(combinations, data, start + 1, end, idx);
    }
}
```

## Comparable, Comparator

```Java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(2, 2, 3);
        Item item3 = new Item(3, 1, 2);

        ArrayList<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        };

        Collections.sort(list, comp);
        System.out.println(list);

        Collections.sort(list, Comparator.comparingInt(Item::getB).thenComparing(Item::getC));
//        Collections.sort(list, Comparator.comparingInt(DAY02.Item::getB).reversed());
        System.out.println(list);
    }
}

class Item implements Comparable<Item> {
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public int compareTo(Item o) {
        // 음수 -> 원래순서
        //0
        // 양수 -> SWAP
        if (a < o.a) {
            return -1;
        } else if (a == o.a) {
            return b - o.b;
        }else{
            return 1;
        }

//        return b - o.b;

//        return Integer.compare(b, o.b);


    }
}
```

## 인덱스트리(IndexTree)

```java
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

## 빠른 출력 - BufferdWriter, StringBuilder
빠른 출력을 위해 BufferdWriter 혹은 Stringbuilder 사용가능, BufferdWriter의 경우 버퍼를 잡아 놓았끼 때문에 반드시 flush(), close()를 반드시 호출해 줘야함. 그리고 자동개행기능이 없기 때문에 개행이 필요할 경우 \n을 따로 처리

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bw.write(A+B + "\n");
        }
        bw.flush();
        bw.close();
    }
}
```

```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(A + B + "\n");
        }
        System.out.print(sb);
    }
}
```

## 배열 회전(왼쪽으로 90도)

```java
import java.io.*;

public class rotate {

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[2][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n-1-j][i];
            }
        }

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[0].length; j++) {
                System.out.print(rotate[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

```java
import java.util.*;

class L68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                res.add(numbers[i] + numbers[j]);
            }   
        }
        
        int[] answer = new int[res.size()];
        int cnt = 0;
        for (int num : res) {
            answer[cnt++] = num;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}
```

```java
class L77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int cnt = 0;
            for(int j = 1; j <= i; j++){
                if (i % j == 0)
                    cnt++;
            }
            if (cnt % 2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}
```

```java
class L70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++){
            answer += a[i] * b[i];
        }
        return answer;
    }
}
```

```java
class L87389 {
    public int solution(int n) {
        for(int i = 2; i < n; i++){
            if (n % i == 1)
                return i;
        }
        return 0;
    }
}
```