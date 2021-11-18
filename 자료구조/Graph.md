# Graph
#자료구조/Graph

---
## 그래프란?
- 연결되어 있는 객체 간의 관계를 표현하는 자료구조
- 그래프의 예: 지하철 노선도, 친구 관계, 컴퓨터 네트워크 등

## 그래프 데이터 타입
- 그래프 G의 두 가지 구성 요소
    - V(G): G에 포함된 vertex(정점)들의 집합
    - E(G): G에 포함된 edge(간선, 에지)들의 집합
    - G = (V, E)
- 무방향성 그래프(undirected graph)
    - Vertex의 쌍을 나타내는 edge가 방향성이 없음
    - (u, v), (v, u): 동일한 edge를 표현
- 방향성 그래프(Directed graph)
    - 각 edge에 방향성이 존재하는 그래프
    - <u, v>: u > v 인 edge를 표현
        - u = tail, v = head
    
### 그래프에서 사용되는 용어들
- 완전 그래프(Complete graph)
    - Edge의 수가 최대인 그래프
    - n개의 vertex -> 최대 edge 수 = n(n-1)/2
- 인접(adjacent), 부속(incident)
    - (u, v)가 undirected graph에서 edge일 경우
        - u와 v는 인접
        - Edge(u,v)는 vertex u와 v에 부속된다.
    - <u, v>가 directed graph에서 edge일 경우
        - u는 v에 인접한다.(u is adjacent to v)
        - v는 u로부터 인접한다.(v is adjacent from u)
- 부분 그래프(Subgrah)
    - V(G') ⊆ V(G) and E(G') ⊆ E(G) 일 겨우, G'는 G의 부분 그래프
- 경로의 길이 = 경로 상에 있는 edge의 수
- 단순 경로(simple path)
    - 처음과 마지막을 제외한 vertex가 다른 경로
- 사이클(cycle): 처음과 마지막이 동일한 단순 경로
- 연결(connected)
    - Vertex u와 v사이에 경로가 존재할 경우, u와 v는 연결
- 연결요소(connected component)
    - Maximal connected subgraph
- 트리 = Connected acyclic graph
- Vertex v의 차수(degree)
    - v에 부속된 edge의 수
    - 방향성 그래프
        - in-degree = v가 head가 되는 edge의 수
        - out-degree = v가 tail이 되는 edge의 수
- Digraph = Directed Graph

## 그래프 표현법

### 인접 행렬(Adjacency Matrix)
- A[n][n]
    - (u, v) ∈ E(G), A[u][v] = 1
    - Otherwise, A[u][v] = 0
- 무방향성 그래프: A[][]는 대칭 행렬
- 방향성 그래프: A[][]는 비대칭 행렬

![](./img/Gra_1.PNG)
- 대칭 행렬: A[n(n-1)/2]로 구현 가능

### 인접 리스트(Adjacency List)
그래프 의 vertex마다 하나의 연결 리스트가 존재

![](./img/Gra_2.PNG)

### 그래프 표현 방법들의 분석
- G에 존재하는 edge 수? 혹은 G가 연결되었는지 검사
    - 인접 행렬: n(n-1)/2 개의 항을 조사 -> O(n^2)
    - 인접 리스트: O(n+e)
        - Good if e << n^2/2 (sparese graphs)
- Digraph에서 vertex의 in-degree를 조사
    - 인접 행렬:O(n)
    - 인접 리스트: O(n+e)