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
