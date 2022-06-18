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