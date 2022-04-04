# Routing Algorithms
##Computer Network/Routing Algorithms

---
##  Interplay Between Routing and Forwarding

![](./img/ra_1.PNG)

## Routing Protocols
Routing protocol goal: determine "good" paths from sending hosts to receiving host, through network of routers
- path: sequence of routers packets traverse from given initial source host to final destination host
- "good": least "cost", "fastest", "least congested"

## Routing Algorithms

- Link-state algorithm
    - Based on dijkstra's algorithm
    ![](./img/ra_2.PNG)
- Distance-vector algorithm
    - Based on bellman-ford equation
     ![](./img/ra_3.PNG)

## Dijkstra's algorithm: oscillations possible
- When link costs depend on traffic volume, route oscillations possible

![](./img/ra_4.PNG)