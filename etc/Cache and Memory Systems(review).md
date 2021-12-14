# Cache and Memory Systems(review)
#etc/Cache and Memory Systems(review)

---

```
Cache & Memory System

PART A
Introduction to Memory System

Basic Structure of a Memory Hierarchy
Memory Hierarchy Technologies
-SRAM
-DRAM
DRAM Memory Latency & Bandwidth
Disk Sectors and Access
Magnetic Disk Characteristic
Flash Storage (SSD, Solid-State Drive)
Flash Types
Flash Memory Characteristics 
SSD Architecture
Wear Leveling in SSD
Erase-before-write in SSD
Out-place-update in SSD
Garbage Collection in SSD
Address Mapping in SSD
FTL (Flash Translation Layer)
FTL implementation
SLC, MLC and TLC in SSD
Major Components of a Computer
The “Memory Wall”
The Memory Hierarchy Goalasd
Memory Hierarchy & Localityqwe
Principle of Locality
- Temporal locality
- Spatial locality
Taking Advantage of Locality
Two Major Memory Performance Metrics
-Latency
-Bandwidth
Memory Hierarchy Technologies
The Memory Hierarchy: Terminology
- Block
- Hit rate
	- Hit Time
- Miss Rate
- Miss Penalty

PART B
Cache <-> Main memory 

How is the Hierarchy Managed?
Cache Basics
Caching: A Simple Example
Direct Mapped Cache 
Example: Intrinsity FastMATH
Taking Advantage of Spatial Locality (multiword block)
Miss Rate vs Block Size vs Cache Size
Evaluation: Block Size Considerations
Cache Field Sizes (Hardware Overhead)
Handling Cache Hits
- write through
- write back
Write back vs. write through
Sources of Cache Misses (3 Cs)

---
13-1
1. 휘발성 메모리와 비휘발성 메모리를 사례를 들어 설명하시오.
휘발성: DRAM - 주기적으로 refresh 필요, SRAM - 전원꺼질때까지 내용 유지
비휘발성: SSD, HDD Disk, CDROM
 
2. 디스크 접근시 필요한 요구 시간을 설명하시오. (실제 접근 시간을 계산할 수 있어야 함.)
overhead:
Queuing delay
+ Seek: move the heads
+ Rotational latency
+ Data trnasfer
+ necessary controller time
 
3. 플래시 메모리의 종류와 특성을 설명하시오. 
NOR flash
high speed memory	
Random read/write access
Read/Write level: Byte
USed for instruction memory in embedded systems or firmware storage

NAND flash
high densitiy memory, cheaper per GB
Random read/write access
Read/Write level: Page vs Erase level: Block
Used for data storage(USB memory, media storage)
 
4. SSD 저장장치의 내부 구조를 HDD와 비교하여 설명하시오.
hdd sector & track
vs
ssd page & block(chip > Die > Plane > Block > Page)
 
5. Wear Leveling이 왜 필요한가? 기본적인 동작 방식을 설명하시오. 
한쪽이 일방적으로 wear out 되서 다 써버리면 다른쪽도 못쓰기 때문에 고르게 wear out 되게 한다
 
6. SSD의 특징으로 Erase-before-Write가 있다. 어떠한 문제가 발생하며 어떻게 해결하는가?
write는 page단위 , erase는 block 단위라 한 페이지지울려면 한블록안에있는 전체 페이지 다 지워야됨 -> 비효율적

Out-place-update
지울려고 하는 page를 invalid로 만들고 새로운 free page에 write

7. Garbage Collection을 왜 해야 하는가? 기본적인 동작 방식은 어떻게 되는가?
한 블록에서 안쓰는 페이지를 제거하기위해
위에 out-place-update 방식으로 계속 채우다가 free page가 없으면 그 블록에서 쓸수있는 페이지만 다른블록으로 옮기고 원래블록을 erase

---
13-2
1. 기억장치 계층 구조에 대해 설명하시오. 왜 이를 사용하여야 하는가? 
On-chip Components
Control		          -> L1 cache   -> Second Level Cache(SRAM) L2 cache -> Main Memory(DRAM) -> Secondary Memory(Disk)
Datapath(register)

적은가격으로 큰 용량 빠른속도의 메모리를 사용하기위해

2. Locality의 종류와 사례를 제시하시오.
Temporal locality: Items accessed recently are likely to be accessed again soon
e.g, instrucions in a loop, induction variables

Spatial locality: Items near those accessed recently are likely to be accessed soon
e.g, sequential instruction access, array data

3. Hit rate, Hit time, Miss rate, Miss penalty는 각각 무엇인가?
Hit rate: the fraction of memory accesses found in a level of the memory hierarchy

Hit time: Time to access data for that level, which consists of "Time to determine hit/miss + Time to access the block"

Miss rate: the the fraction of memory accesses not found in a level of the memory hierarchy ⇒ “1 - (Hit Rate)”

Miss penalty: time to replace a block in that level with the corresponding block from a lower level, which consists of Time to access the block in the lower level + Time to transmit that block to the level that experienced the miss + Time to insert the block in that level + Time to pass the block to the requestor
 

4. Inclusive / Exclusive cache의 각각의 장단점은 무엇인가?
Inclusive Cache: Most Intel Processor, AMD before K7
Pros: reduces average cache access time
Cons: reduces cache space utilization

Exclusvie Cache: AMD K7 or later
Pros: increase space uitlization
Cons: increase average cache access time(cache miss overhead)
```
