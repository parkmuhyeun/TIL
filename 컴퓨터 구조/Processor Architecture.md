# Processor Architecture
#컴퓨터구조/Processor Architecture

---
## MIPS Processor Architecture and Pipeline Implementation
CPU performance factors
- instruction count
    - Determined by ISA and compiler
- CPI, Cycle time
    - Determined by CPU architecture

Two Mips implementations
- A simplified version
- A more realistic pipelined version

Simple subset, shows most aspects
- Arithmetic/logical: add, sub, and, or, slt
- Memory reference: lw, sw
- Control transfer: beq, j

### Logic Design Basics
Inforemation encoded in binary
- Low voltage = 0, High voltage = 1
- One wire per on bit
- Multi-bit data can be encoded on multiwire logics

Combinational element
- Operate on data
- Output is a function of input data

State(sequential) elements
- Store information
- Output is a function of input data and state

### Simple Instruction Execution Step
By using PC(program counter, instruction address)
- Access Instruction Memory(IM) and fetch instrcution

By using register numbers
- Access register file with register number(not address)

Depending on instruction class
- Use ALU to calcaulate
    - Arithmetic result
    - Memory address for load/store
    - Branch target address
- Access Data Memory(DM) for load/store
- (PC <- PC+4) or (PC <- branch target address)

### Abstract Implementation View
Two types of functional units:
- elements that operate on data values (combinational logic)
- elements that contain state (sequential logic)

![](./img/PA_1.PNG)

Single cycle operation
- All 5 modules here execute in a Long Single cycle

- Split memory model - one memory for instructions and one memory for data(IM vs DM, Harvard Architecture)

### Clocking Methodologies
Clocking methodology defines when signals can be read and when they can be written

![](./img/PA_2.PNG)

State element design choices
- level sensitive latch
- edge-triggered flip-flops

### The processor: Datapath & Control

All instructions (except j) use the ALU after reading the registers
- arithmetic use the ALU to do the required arithmetic operation
- memory reference use ALU to compute memory addresses
- control use the ALU to compute branch conditions and target address calculation