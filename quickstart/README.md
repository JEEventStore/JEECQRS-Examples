JEECQRS-Quickstart-Sample
=========================

A simple example for CQRS+ES in Java for the Java EE platform.

Uses:
* JCommonDomain for the event sourcing and sagas (long running processes)
* JEECQRS for the CQRS infrastructure services (EventBus, CommandBus, saga support) (asynchronous command bus, local host-only event bus, JPA persistence for the saga tracker)
* JEEventStore as underlying event store for aggregates and sagas (with JPA as persistence technology and Gson for serialization)


Instructions
============

* Download and unzip [Wildfly](http://wildfly.org/downloads/) (tested with Wildfly 15.0.0.Final)
* run ```/path/to/wildfly/bin/standalone.sh```
* Run (```mvn install wildfly:deploy```)
* Open [http://127.0.0.1:8080/jeecqrs-quickstart-sample/](http://127.0.0.1:8080/jeecqrs-quickstart-sample/)
