# Data Flow Topology and Network Range
#데이터 통신/Data Flow Topology and Network Range

---
## Data Flow
Simplex

![](./img/DFTNR_1.png)

Half-duplex

![](./img/DFTNR_2.png)

Full-duplex

![](./img/DFTNR_3.png)

## Physical Topology
선 구성 방식

### Fully Connected mesh topology
각자 device마다 링크가 있음

![](./img/DFTNR_4.png)

장점
- 각자의 전용선이 있기 때문에 다른선에 연관 X
- Robustness
- Privacy and Security

단점
- 케이블 수가 많아서 비쌈

### Star topology
- 허브를 통해 각자 연결
- Used in local-are networks(LANs)

![](./img/DFTNR_5.png)

장점
- mesh 보단 덜 복잡
- robustness

단점
- hub 다운되면...

### Bus topology

![](./img/DFTNR_6.png)

장점
- 쉬운설치

단점
- Difficult reconnection and Fault isolation
- A fault in the bus cable stops all transmission

### Ring topology

![](./img/DFTNR_6.png)

장점
- 쉬운 설치

단점
- A break in the rig can disable the entire network

## Network Range
- PAN (Personal Area Network)
- LAN (Local Area Network)
- MAN (Metropolitan Area Network)
- WAN (Wide Area Network)

![](./img/DFTNR_8.png)