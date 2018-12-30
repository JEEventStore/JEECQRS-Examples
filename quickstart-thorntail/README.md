JEECQRS Thorntail Example
=========================

A simple example for CQRS+ES in Java for the Java EE platform, bundled with Thorntail (formerly Wildfly Swarm).

Uses:
* JCommonDomain for the event sourcing and sagas (long running processes)
* JEECQRS for the CQRS infrastructure services (EventBus, CommandBus, saga support) (asynchronous command bus, local host-only event bus, JPA persistence for the saga tracker)
* JEEventStore as underlying event store for aggregates and sagas (with JPA as persistence technology and Gson for serialization)

Note that we need to define the library's EJBs in the ejb-jar

Instructions
============

* Run (```mvn thorntail:run```)
* Try the REST API, for example:

```
curl -X POST \
  http://127.0.0.1:8080/orders \
  -H 'Content-Type: application/json' \
  -d '{
    "customerName": "John Doe",
    "orders": [{
        "productId": 107,
        "amount": 11
    }]
  }'
```
