JEECQRS Example for OpenEJB
===========================

A simple example for CQRS+ES in Java for the Java EE platform meant to be run on the OpenEJB standalone container.

Uses:
* JCommonDomain for the event sourcing and sagas (long running processes)
* JEECQRS for the CQRS infrastructure services (EventBus, CommandBus, saga support) (asynchronous command bus, local host-only event bus, JPA persistence for the saga tracker)
* JEEventStore as underlying event store for aggregates and sagas (with JPA as persistence technology and Gson for serialization)

Instructions
============

* Download and unzip [Apache OpenEJB standalone](http://tomee.apache.org/downloads.html)
* run ```/path/to/openejb/bin/openejb start```
* Build this project and dependencies (```mvn install````)
* deploy to OpenEJB: ```/path/to/openejb/bin/openejb deploy ear/target/*.ear```
* Test out the REST API
