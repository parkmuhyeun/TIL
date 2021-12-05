# Cache and Memory Systems(review)
#etc/Cache and Memory Systems(review)

---

```
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
```
