# Grammer for Test(Python)
##알고리즘/Grammer for Test(Python)

---

```python
a = 0.3 + 0.6 # 0.899999999

print(round(a, 2)) # 0.9

a = 7
b = 3

# 나누기
print(a / b)    # 2.3333333333333335

# 나머지
print(a % b)     # 1

# 몫
print(a // b)   # 2

# 빈 리스트 선언 방법 1)
a = list()
# 빈 리스트 선언 방법 2)
a = []

# 크기가 N이고, 모든 값이 0인 1차원 리스트 초기화
n = 10
a = [0] *n
print(a)

# 리스트 컴프리헨션
# 0부터 19까지의 수 중에서 홀수만 포함하는 리스트
array = [i for i in range(20) if i % 2 == 1]
print(array)

# 1부터 9까지의 수 의 제곱 값을 포함하는 리스트
array = [i * i for i in range(1, 10)]
print(array)

# N X M 크기의 2차원 리스트 초기화
n = 3
m = 4
array = [[0] * m for _ in range(n)]
print(array)

# 리스트 관련 기타 메서드
# sort() - 시간복잡도 O(NlogN)
a.sort() # 오름차순 정렬
# sort(reverse = True) 내림차순 정렬

# reverse() 리스트의 원소의 순서를 모두 뒤집어 놓는다
a.reverse()

# count() 리스트에서 특정한 값을 가지는 데이터의 개수
a.count(3) # 값이 3인 데이터 개수

# 특정한 값의 원소 제거
a = [1, 2, 3, 4, 5, 5, 5]
remove_set = {3,5}

# remove_set에 포함되지 않은 값만을 저장
result = [i for i in a if i not in remove_set]
print(result)

# 파이썬의 문자열은 내부적으로 리스트와 같이 처리
a = "ABCDEF"
print(a[2 : 4]) # CD

# 리스트 [], 튜플 (), 사전자료형 {}
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

if '사과' in data:
    print("'사과'를 키로 가지는 데이터가 존재")

data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

# 키 데이터만 담은 리스트
key_list = data.keys()

# 값 데이터만 담은 리스트
value_list = data.values()

print(key_list)
print(value_list)

# 각 키에 따른 값을 하나씩 출력
for key in key_list:
    print(data[key])

# 집합 자료형 
# 중복 허용 x
# 순서x
# 집합 자료형 초기화 방법 1
data = set([1, 1, 2, 3, 4, 4, 5])
print(data) #{1, 2, 3 ,4 ,5}

# 집합 자료형 초기화 방법 2
data = {1, 1, 2, 3, 4, 4, 5}
print(data) #{1, 2, 3 ,4 ,5}

# 집합 자료형의 연산
a = set([1, 2, 3, 4, 5])
b = set([3, 4, 5, 6, 7])

print(a | b) # 합집합 {1, 2, 3, 4, 5, 6, 7}
print(a & b ) # 교집합 {3, 4, 5}
print(a - b) # 차집합 {1, 2}

# 집합 자료형 관련 함수
data = set([1, 2, 3])

# 새로운 원소 추가
data.add(4)

# 새로운 원소 여러 개 추가
data.update([5,6])

# 특정한 값을 갖는 원소 삭제
data.remove(3)  

# 함수
# def 함수명(매개변수):
#     실행할 소스코드
#     return 반환 값
def add(a, b):
    return a + b

#  함수 안에서 함수 밖의 변수 데이터를 변경(global 사용)
a = 0

def func():
    global a
    a += 1

for i in range(10):
    func()

print(a)    # 10

# 람다 표현식
def add(a, b):
    return a + b

# 일반적인 add() 메서드 사용
print(add(3, 7))

# 람다 표현식으로 구현한 add() 메서드
print((lambda a, b: a + b)(3, 7))

# 입출력
# list(map(int, input()).split()) # 공백으로 여러개 입력

n = int(input())    # 5

data = list(map(int, input().split()))  # 65 90 75 34 99

data.sort(reverse=True)
print(data)     ([99, 90, 75, 65, 34])

# 공백을 기준으로 구분하여 적은 수의 데이터 입력
n, m, k = map(int, input().split()) # 3, 5, 7
print(n, m, k)  # 3, 5, 7

# 입력의 개수가 많은 경우에 input() 함수를 그대로 사용하지 않음
# sys.stdin.readline() 함수 이용
import sys

# 문자열 입력받기
data = sys.stdin.readline().rstrip()
print(data)

# 내장 함수

# sum() iterable 객체가 입력으로 주어졌을 때, 모든 원소의 합을 반환
result = sum([1, 2, 3, 4, 5])
print(result)   # 15

# min() 파라미터가 2개 이상 들어왔을 때 가장 작은 값을 반환
result = min(7, 3, 5, 2)
print(result) # 2

# max() 파라미터가 2개 이상 들어왔을 때 가장 큰 값을 반환
result = max(7, 3, 5, 2)
print(result) # 7

# eval() 수학 수식이 문자열 형식으로 들어오면 해당 수식을 계산한 결과를 반환
result = eval("(3 + 5) * 7")
print(result)   # 56

# sorted() iterable 객체가 들어왔을 때, 정렬된 결과를 반환
result = sorted([9, 1, 8, 5, 4]) # 오름차순으로 정렬 1 4 5 8 9
result = sorted([9, 1, 8, 5, 4], reverse = True) # 내림차순으로 정렬 9 8 5 4 1

# 튜플 두번째 수를 기준으로 내림차순 정렬
result = sorted([('홍길동', 35), ('이순신', 75), ('아무개', 50)], key = lambda x: x[1], reverse = True)
print(result)

# itertools 

# permutations (순서 고려)
from itertools import permutations

data = ['A', 'B', 'C']

result = list(permutations(data, 3)) #모든 순열 구하기
print(result)

# combinations (순서 고려x)
from itertools import combinations

data = ['A', 'B', 'C']

result = list(combinations(data, 2)) #2개를 뽑는 모든 조합 구하기
print(result)

# product - permutations와 같이 iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열, 다만 원소를 중복하여 뽑음

from itertools import product

data = ['A', 'B', 'C']

result = list(product(data, repeat=2)) #2개를 뽑는 모든 순열(중복 허용)
print(result)

# combinations_with_replacement - combinations와 같이 iterable 객체에서 r개의 데이터를 뽑아 순서를 고려하지 않고 나열, 다만 원소를 중복하여 뽑음

from itertools import combinations_with_replacement, product

data = ['A', 'B', 'C']

result = list(combinations_with_replacement(data, 2)) #2개를 뽑는 모든 조합(중복 허용)
print(result)

# heapq - 파이썬의 힙은 최소 힙으로 구성되어 있으므로 원소를 힙에 전부 넣었다가 빼는 것만으로도 시간복잡도 O(NlogN)에 오름차순 정렬이 완료된다.

import heapq

def heapsort(iterable):
    h = []
    result = []

    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, value)

    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for _ in range(len(h)):
        result.append(heapq.heappop(h))
    return result

result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(result) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

# 파이썬에서는 최대 힙을 제공x. 최대힙을 구현할때는 원소의 부호를 임시로 변경하는 방식 사용

import heapq

def heapsort(iterable):
    h = []
    result = []

    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h, -value)

    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for _ in range(len(h)):
        result.append(-heapq.heappop(h))
    return result

result = heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
print(result) # [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]


# bisect - 이진 탐색을 쉽게 구현할 수 있도록 bisect 라이브러리 제공. '정렬된 배열'에서 특정한 원소를 찾아야 할 대 매우 효과적이다.
# bisect_left(a, x): 정렬된 순서를 유지하면서 리스트a에 데이터 x를 삽입할 가장 왼쪽 인덱스를 찾는 메서드 (시간 복잡도(log N))
# bisect_right(a, x): 정렬된 순서를 유지하면서 리스트a에 데이터 x를 삽입할 가장 오른쪽 인덱스를 찾는 메서드 (시간 복잡도(log N))

from bisect import bisect, bisect_left, bisect_right

a = [1, 2, 4, 4, 8]
x = 4
print(bisect_left(a, x)) # 2
print(bisect_right(a, x)) # 4

# '정렬된 리스트'에서 '값이 특정 범위에 속하는 원소의 개수'를 구하고자 할 때, 효과적으로 사용

from bisect import bisect_left, bisect_right

def count_by_range(a, left_value, right_value):
    right_index = bisect_right(a, right_value)
    left_index = bisect_left(a, left_value)
    return right_index-left_index

a = [1, 2, 3, 3, 3, 3, 4, 4, 8 ,9]

# 값이 4인 데이터 개수 출력
print(count_by_range(a, 4, 4))  # 2

# 값이 -1 ~ 3 범위에 있는 데이터 개수 출력
print(count_by_range(a, -1, 3)) # 6

# collections

# deque를 큐 자료구조로 이용할 때,
from collections import deque

data = deque([2, 3, 4])
data.appendleft(1)
data.append(5)

print(data)
print(list(data)) # 리스트 자료형으로 변환

# Counter - 등장 횟수 세능 기능 제공

from typing import Counter

counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])

print(counter['blue']) # 'blue'가 등장한 횟수 출력
print(counter['red']) # 'red'가 등장한 횟수 출력
print(dict(counter)) # 사전 자료형으로 변환 -> {'red': 2, 'blue': 3, 'green': 1}

# math - 팩토리얼, 제곱근, 최대공약수(GCD) 등 수학 계산

import math

print(math.factorial(5)) # 5!(120)

print(math.sqrt(7)) # 7의 제곱근 출력(2.6457513110645907)

print(math.gcd(21, 14)) # 21, 14의 최대 공약수 출력(7)

print(math.pi) # 파이(pi) 출력(3.141592653589793)
print(math.e) # 자연상수 e 출력(2.718281828459045)
```