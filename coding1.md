# [Issue 3] Coding 1
In this first iteration in the development of the app we are going to start coding the CUs related only to the management of the users.

We are going to code following the Clean Architecture model (controller, service, repository), although, for now, we will simplify it by eliminating the Service layer as they are CRUD operations that only require access to the database and therefore no more business logic is developed than the access to the database itself to respond to the requests received by the controller.

## 1. Web programming paradigm: REST.
We have implemented a controller that manages the functionalities on the User entity of the application, another for the UserAdmin entity and another for UserCustomer.

### Annotations used.
The annotations that we have used in these controllers are the following:
- @RestController
- @RequiredArgsConstructor
- @RequestBody
- @PathVariable
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @Entity
- @Data
- @AllArgsConstructor
- @NoArgsConstructor
- @Id
- @GeneratedValue
- @Column
- @ManyToOne
- @JoinColumn
- @Getter
- @Setter

### Object declaration to achieve layer decoupling through dependency injection.


### Testing with Postman


### DTO classes
