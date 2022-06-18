# School Management

## Question 10:
## Flaws found in the UML Diagram

1. Access Modifiers -> Attributes in a domain class should be marked as private and should not be accessible from outside the class.

2. UML Depicts a relationship between Employeee and EmployeeAddress. Student and StudentAddress also depict the same thing. But, the attributes of all four classes do not allow such a relationship to be created. These tables not having their relationship implemented causes a disjointed relationship. 

3. Address should have been a complete Entity and not a value object. The reason for this is that, Address would now contain an Id which can then be used as a foreign key in the EmployeeAddress and StudentAddress Entities.
This would allow StudentAddress and EmployeeAddress to behave like a bridging entity as it should with a composite key from two Entities. This will change the nature of the relationship between Employee and EmployeeAddress; Student and StudentAddress to a OneToMany relationship.

4. Employee and Student are redundant as they could have been combined to form one entity since they have the same attributes.
---
## Design and Implementation Flaws

1. Due to the use of ValueObjects, by design, value objects should be mutable. Since they are mutable or should be mutable, there is a conflict between our chosen design pattern which is the Builder Pattern. It strickly enforces immutability. This is a design flaw.

2. The requirements document could be improved further as it lacks information in terms of which services should be exposed and which should not, specifically referring to the read, save, delete, readAll services.

3. Due to the flaw mentioned -> ***Flaws found in the UML Diagram (#3)***. During a save procedure of a StudentAddress or EmployeeAddress, it is possible to save an EmployeeAddress or StudentAddress with an stuffId or studentId that does not exist in the Employee or Student table. 
---

## Repository Interfaces & Classes Naming Convention

### Naming the Interface
All interfaces created should follow the convention below.
An interface name should be preceded by an ```I``` then followed
by its ```Name``` then ```Parent Package Name e.g Repository```. 
```
e.g IStudentRepository.java
```
This is an interface for Student. 
The respective implementation
class for the interface above should be named.
```
e.g StudentRepositoryImpl.java
```

---
## Packaging
The Resful API project is made up of 5 packages by default which abide to the DDD Project Architecture.
- controller
- domain
- factory
- repository
- service

Within the controller, domain, factory & repository packages, do not add any sub-packages, all source files should be listed inside the package. They should not be within any sub-package.

For the remaining package(s) which are service, each domain should have a specific package created within the respective package. Within the sub-package of the specific domain, Interfaces of that domain should be defined there. Implementations of the specific Interfaces should be created within a sub-package named 
> impl

#### See example below of the package structure for studentService
```
|-- service
|  |-- IService.java
|  |-- studentService
|     |-- IStudentService.java
|     |-- impl
|        |-- StudentServiceImpl.java
|
|
|
```
#### You are strictly advised to stick to the naming and packaging convention while working on the project, failure to do so will result in the code being rejected upon reviewing.
---
## Collaboration Rules

### Commit Messages
All commits made in this project should follow the convention below.
A commit should have 3 parts
1. Type
2. Colon
3. Description of the task under the give task. ***Short and precise***

#### See examples below
---
> A commit for a newly added entity
`TASK: Added and implemented domain entity car.`

> A commit for a bug fix.
`BUG FIX: Fixed null pointer reference for car objects caused by an uninitialized object in vehicle.`
**[NOTE]** You can omit the cause if you want to But it is strongly recommended you put the cause of the Bug so 
that in later stages, if one of the team member(s) go through the same error the commit message might be of 
some help to them to track down their cause.

> A commit for a refactoring
`REFACTORING: Extracted ValidateStudentNumber() method from AddStudent()`

> A commit for a new feature
`FEATURE: Added session tracking for logged-in users`
---


