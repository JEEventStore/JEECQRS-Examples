JEECQRS-Quickstart-Sample
=========================

A simple example for CQRS+ES in Java for the Java EE platform.

Uses:
* JCommonDomain for the event sourcing and sagas (long running processes)
* JEECQRS for the CQRS infrastructure services (EventBus, CommandBus, saga support) (asynchronous command bus, local host-only event bus, JPA persistence for the saga tracker)
* JEEventStore as underlying event store for aggregates and sagas (with JPA as persistence technology and Gson for serialization)

