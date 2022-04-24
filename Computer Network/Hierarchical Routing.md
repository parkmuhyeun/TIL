# Hierarchical Routing
#Compuber Network/Hierarchical Routing

---
## Routing Algorithms We Learend
- Link-state algorithm
    - Based on dijkstr's algorihtm
    - OSPF
        - Open Shortest Path First
- Distance-vector algorithm
    - RIP
        - Routing Information Protocol

## Making Routing Scalable
Scale: billions of destinations:
- can't store all destinations in routing tables
- routing table exchange would swamp links

Administrative autonomy:
- Internet: a network of networks
- each network admin may want to control routing in its own network

## Hierarchcial Routing: Internet Approach to Scalable Routing
- Aggregate routers into regions known as "autonomous systems" (a.k.a "domains")

Intra-AS (aka "intra-domain"): routing among within same AS("network")
- All routers in AS must run same intra-domain protocol
- Routers in different AS can run different intra-domain routing protocols
- Gateway router: at "edge" of its own AS, has link(s) to router(s) in other AS'es

Inter-AS (aka "inter-domain"): routing among AS'es
- Gateways perform inter-domain routing (as well as intra-domain routing)

## Interconnected ASes
forwarding table configured by intra- and inter-AS routing algorithms
- intra-AS routing determine entries for destinations within AS
- inter-AS & intra-AS determine entries for external destinations

## Relationship Between Networks
Running an ISP
- Human resource
- Physical connectivity and bandwidth
- Hardware
- Space and power
- Other things

=> In ohter words, Money!!