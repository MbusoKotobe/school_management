# school_management

## Repository Interfaces & Classes Naming Convention

### Naming the Interface
All interfaces created should follow the convention below.
An interface name should be preceded by an ```I``` then followed
by its ```Name``` then ```Repository```. 
```
e.g IStudentRepository.java
```
This is an interface for Student. 
The respective implementation
class for the interface above should be named.
```
e.g StudentRepositoryImpl.java
```
#### You are strictly advised to stick to the naming convention while working on the project, failure to do so will result in the code will being rejected upon reviewing.
---
## Collaboration Rules

### Commit Messages
All commits made in this project should follow the convention below.
A commit should have 3 parts
1. Type
2. Colon
3. Description of the task under the give task. ***Short and precised***

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
