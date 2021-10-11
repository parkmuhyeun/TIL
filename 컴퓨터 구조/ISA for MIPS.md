# ISA for MIPS
#컴퓨터구조/ISA for MIPS

---
## RISC  - Reduced Instruction Set Computer
RISC philosophoy
- fixed instruction lengths
- load-store instruction sets
- limited number of addressing modes
- limited number of operations

The effciency of Instruction sets are measured by how well compilers use them efficiently(not measured by how well programmers use them easily)

## The Four Design Principles
1. Simplicity favors regularity
2. smaller is faster
3. Make the common case fast
4. Good Design demands good compromises

## Two Key Principles of Machine Design
1. Instructions are represented as numbers and, they are indistinguishable from data
2. Programs are stored in alterable memory just like

## MIPS-32 ISA

3 Instruction Formats: all 32-bit wide

![](./img/IfM_1.PNG)

---
## MIPS Instruction Fields

||||
-|-|-|
|op|6-bits|opcode that specifies the operation|
rs|5-bits|register first source
rt|5-bits|register second source
rd|5-bits|register destination
shamt|5-bits|shift amount
funct|6-bits|function code
-> In total 32bits R-type Instruction

## MIPS Register File

![](./img/IfM_2.PNG)

Holds thirty-two 32-bit registers
- Two read ports
- One write port

Registers are
- Faster than main memory
- Easier for a compiler to use register file, compared to stack
- Can hold variables with improved code density

## MIPS Memory Access Instructions

lw $t0, 4($s3) #load word from memory

sw $t0, 8($s3) #store word to memory

The data is loaded into or stored from a register in the register file - a 5 bit address

The memory address - a 32 bit address - is formed by adding the contents of the base address register to the offset value
- A 16-bit offset field

### Load Instruction(I-type)

![](./img/IfM_3.PNG)

### Store Instruction(I-type)

![](./img/IfM_4.PNG)

---
## Byte addresses
Alignment restriction - the memory address of a word must be on natural word boundaries

![](./img/IfM_5.PNG)

### Big Endian
: 시작주소에 MSB

ex) MIPS, HP DA-RISC (RISC)

### Little Endian
: 시작주소에 LSB

ex) Intel, ARM (CISC)

- 기계입장에서 Little Endian이 친숙
- 인간이 읽기에는 Big Endian이 편함

![](./img/IfM_6.PNG)
---
## Loading and Storing "Bytes"
lb $t0, 1($s3) #load byte from memory

lw $50, 6($s3) #stroe byte to memory

What 8 bits get loaded and stored?
- load -  레지스터 가장 오른쪽에 8 bit load 나머지는 zero-extend
- store - 레지스터 가장 오른쪽은 memory에 4곳중 아무곳에 넣고 나머지는 건드리지 않음

## I format 에서 덧셈
addi $sp, $sp, 4   #$sp = $sp +4

immediate에 4 저장

slti $t0, $s2, 15 #$t0 = 1 if $s2 < 15

![](./img/IfM_7.PNG)

### The constant is kept inside the instruction itself
- 16 bits Immediate format limits values to the range 2^15-1 to -2^15
- Small number is Common Case

## How About Larger Constants?
### Use two instructions(lui + ori)

- a new "load upper immediate" instruction
    - lui $t0, 1010101010101010

- Then must get the lower order bits right, use
    - ori $t0, $t0, 1110111011101110

![](./img/IfM_8.PNG)

-> Increase IC but not common case