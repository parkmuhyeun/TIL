# Processor Architecture(review)
#etc/Processor Architecture(review)

---
컴퓨터구조 Processor Architecture(review)
```
9-1
1. 순차 회로의 조합 회로의 차이점은 무엇인가?
combinational element
단순히계산

sequential elements
저장되있는값과 주어진 값을통해 output이나옴

2. ALU가 계산용도로 사용되는 서로 다른 3가지를 설명하시오.
(simple subset의 대표 명령어들은 각각 어떻게 ALU를 필요로 하는가?)
Arithmetic/logical: add, sub, and, or, slt
Memory reference: lw, sw
Control transfer: beq, j
 
3. 하바드 아키텍쳐를 사용하는 이유는 무엇인가?
일단은 메모리 split -> 더빠름

4. 클록을 사용하는 방법론에 대해 서술하시오. 
active high, active low

level sensitive latch
active high, high low

edge-triggered flip-flops
falling(negative) edge, rising (positive) edge

data in a state element is valid relative to the clock

---

9-2
1. Fetch 단계에서는 별도의 제어신호가 필요없는 이유가 무엇인가?
pc is updated every clock cycle
 
2. Decode 단계의 2가지 작업은 무엇인가?
first fetch opcode, function field to control unit
second reading two values from the register file

3. 강의 자료 16페이지에 있는 회로도를 각 wire를 이해하면서 똑같이 그려 보시오. 

4. branch 명령과 j 명령어를 상호 비교하여 PC값이  갱신되는 과정을 그림을 그리며 설명하시오. 

---

10-1
1. 통합된 CPU datapath 상에서 MUX의 역할은 무엇인가? 각 MUX별로 이야기 하시오.
ALUSrc
r add 할지 load할지

MemtoReg
r add연산할지 load할지
 
PCSrc
pc+4 할지 pc+4 + branch offset할지

2. datapath 상에서 duplication된 모듈들은 어떤 것들이 있는가? 그렇게 하는 이유는 무엇인가?
add
alu에서 다처리하면 alu가 할일이 너무많으니깐
 
3. MIPS ISA의 3가지 명령어 포맷별 공통점과 차이점을 관찰하시오. 
op field alway bits 31-26

r-type에서 rs read  rt read
i-type에서 rs read, write rt
st read rt and write to rs(mem)

offset for beq, ld , st alway in bits 15-0

---

10-2
1. Control Unit의 각 출력 신호가 제어하는 기능은 무엇인가?
ALUOp
Branch(PCSrc)
Memread
MemtoReg
MemtoWrite
RegWrite
ALUSrc
RegDst
 
2. SW 명령어에 대하여 활성화되는 Datapath와 control 신호를 제시하시오. 
MemWrite
RF Read Data1, Sign Extend, ReadData2

3. Single Cycle/Pipelined CPU 구현에 있어서 각각의 clock cycle time은 어떻게 결정되는가?
Single Cycle
5 Stage 중에
Longest intruction이 Insturction Critical Path

4. Single Cycle CPU 구현의 단점은 무엇인가? (= Pipeline CPU를 사용하는 이유는?)
clock cycle이 비효율적(빠른명령어는 낭비하는 시간이많음)

---

11-1
1. Pipeline CPU의 Speedup은 어떻게 되는가? 
start fetching and executing the next instruction before the current one has completed

이상적인건 파이프라인 단계수만큼 빨라짐
(clock cycle이 n배 빨라지면 1/n만큼 시간줌)
 
2. Pipeline CPU의 throughput와 latency에 대하여 설명하시오.
 
throughput 단위시간당 일처리량 - 증가됨
latency 한 명령어가 실행하고 완료할때 까지 실행시간- 안 줄어들음

3. Pipeline CPU를 구현함에 있어서 balance가 중요한 이유는 무엇인가?

너무 많으면 waste가 많고 적으면 안돌아가는 명령어가생김

4. Pipeline CPU의 CCT는 어떻게 결정되는가?

clock cycle만큼 줄어든다

---
11-2
1. MIPS ISA를 파이프라인으로 구현하기 쉬운 이유는 무엇인가?
RICS features

2. 파이프라인 CPU에서 state register의 역할은 무엇인가?
sequential module 사이 중간다리역활
 
3. 파이프라인 구현에 있어서 역방향 데이터 흐름을 발생시키는 사례를 제시하시오.
load

4. 3번의 역방향 데이터 흐름이 발생 시키는 문제점은 무엇인가?
data hazard
control hazard
 
5. 다양한 형태의 서로 다른 파이프라인 형태의 특징과 장단점을 분석하시오 
uses the clock cycle efficiently - the clock cycle is timed to accommodate not the slowest instruction but the slowest instruction step
allow faster clock rates
need only one memory, one ALU/adder..
however it requires additional internal state registers, muxes, and more complicated FSM control

---
12-1
1. 파이프라인을 사용하면 왜 performance가 증가하는가?
동시에 작동하기때문에 첫명령어와 다음명령어 사이의 간격이 줄어듬 -> cycle time이 줄어듬

2. 파이프라인 hazard의 종류는?
structural hazards
data hazards
control hazards
 
2-1 . 정의와 사례를 제시하시오. 
structural hazards - 다른 명령어로 동시에 같은하드웨어 자원을 사용 
ex)
memory
harvard architecture로 인해 instruction memory, data memory 나눠서 사용

register 
앞, 뒤로 반으로 나눠서 쓴다

data hazards - data가 준비되기전에 사용
add, load
RAW hazard(Read after Write)

control hazards - condition이 측정되기전에 프로그램 control flow가 결정
bne or beq 

3. forwarding이란 무엇인가?
fix data hazards by forwarding results as soon as they are available to where they are needed
 
3-1. 어디에서 어디로 forwarding할 수 있는가? 사례를 제시하시오. 
ALU -> ALU
DM -> ALU

---
12-2
1. to-ALU 포워딩의 2가지 세부 방식은 무엇인가? 
EX Forwarding: ALU to ALU ( R to R result forwarding)
MEM forwarding: DM to ALU ( load use hazard)
 
2. 위 1번의 2가지 방식이 충돌될 경우 어떻게 처리되어야 하는가?
가장 최근에꺼를 update
 
3. Load-Use 해저드의 경우 추가적으로 1 cycle stall이 발생하는 이유는 무엇인가?
forwarding해도 피할수없음, 1 stall 후에 다시 작동
 
4. stall 연산의 구현절차 2step을 설명하시오.
1. prevent the instructions in the IF and ID stages from progressing down the pipeline - done by preventing the pc register and the IF/ID pipeline register from changing

2 Insert a "bubble" between lw instruction ( ex stage) and the load-use instruction ( next inst. in the id stage)
 
5. to-MEM 포워딩은 언제 발생하는가?
LW-SW
loads immediately followed by stores
```