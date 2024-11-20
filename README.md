# Hexagonal Architecture Demo

The demo project for PartnersPayment Craft Conference.

Service represent simple bar order service system 
and implemented using Hexagonal Architecture approach.

## What is Hexagonal Architecture?
Hexagonal Architecture isn’t a radically new concept; rather, it’s a shift in perspective on how we structure code, putting the domain model — our mental representation of the real world — at the centre. By focusing on the domain, Hexagonal Architecture facilitates collaboration with both technical and non-technical stakeholders, making it easier to align development with business needs. At its core, Hexagonal Architecture is a domain-centric approach. Its primary goal is to make the core domain of an application independent of technical details like APIs, databases, or user interfaces. This independence is achieved by organising the application around three main components:


**Domain**: The heart of the application, containing the core business logic and models. The domain is the only part of the code that truly understands the business and holds the rules that define it.

**Ports**: Interfaces that enable communication between the domain and the outside world. Ports define expected interactions, allowing the domain to remain isolated from specific technical details.

**Adapters**: Implementations of ports that connect the domain with external systems, such as databases, APIs, and user interfaces. Adapters handle the specifics of interacting with these systems, translating between external data formats and the domain’s own models.

This structure keeps the business logic isolated and independent of external systems. Adapters can be easily swapped out, making it easier to change or add new technologies without impacting the core domain.

## ArchUnit

Essential part of keeping agreements is to automate them :) 
Here you can also find an example of ArchUnit usage which automate verification of project structure, i.e. domain is isolated for adapters etc.