# [Issue 3] Coding 1
In this first iteration in the development of the app we are going to start coding the CUs related only to the management of the users.

We are going to code following the Clean Architecture model (controller, service, repository), although, for now, we will simplify it by eliminating the Service layer as they are CRUD operations that only require access to the database and therefore no more business logic is developed than the access to the database itself to respond to the requests received by the controller.

## 1. Web programming paradigm: REST.
We have implemented a controller that manages the functionalities on the User entity of the application, another for the UserAdmin entity and another for UserCustomer.

### Annotations used.
The annotations that we have used in these controllers are the following:
- **@RestController**
	Types carrying this annotation are treated as controllers where @RequestMapping methods assume the default semantics of @ResponseBody.
- **@RequiredArgsConstructor**
	It generates a constructor with 1 parameter for each field that requires special handling. All non-initialized final fields get a parameter, as well as any fields that are marked as @NonNull that aren't initialized where they are declared. For those fields marked with @NonNull, an explicit null check is also generated. The constructor will throw a NullPointerException if any of the parameters intended for the fields marked with @NonNull contain null. The order of the parameters match the order in which the fields appear in your class.
- **@RequestBody**
	This annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object. Spring automatically deserializes the JSON into a Java type, assuming an appropriate one is specified. By default, the type we annotate with the @RequestBody annotation must correspond to the JSON sent from our client-side controller.
- **@PathVariable**
	This annotation can be used to handle template variables in the request URI mapping, and set them as method parameters.
- **@GetMapping**
	Annotation to map HTTP GET requests to specific controller methods. It is a compound annotation that acts as a shortcut for @RequestMapping.
- **@PostMapping**
	Annotation to map POST HTTP requests to specific controller methods. It is a compound annotation that acts as a shortcut for @RequestMapping.
- **@PutMapping**
	Annotation to map HTTP PUT requests to specific controller methods. It is a compound annotation that acts as a shortcut for @RequestMapping.
- **@DeleteMapping**
	Annotation to map HTTP DELETE requests to specific controller methods. It is a composite annotation that acts as a shortcut for @RequestMapping.
- **@Entity**
	It allows you to work with data in the form of domain-specific properties and objects, such as customers and customer addresses, without having to worry about the underlying database tables and columns where this data is stored.
- **@Data**
	It is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together: In other words, @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans: getters for all fields, setters for all non-final fields, and appropriate toString, equals and hashCode implementations that involve the fields of the class, and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, in order to ensure the field is never null.
	@Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations on the class (except that no constructor will be generated if any explicitly written constructors already exist). However, the parameters of these annotations (such as callSuper, includeFieldNames and exclude) cannot be set with @Data. If you need to set non-default values for any of these parameters, just add those annotations explicitly; @Data is smart enough to defer to those annotations.
- **@AllArgsConstructor**
	It generates a constructor with 1 parameter for each field in your class. Fields marked with @NonNull result in null checks on those parameters.
- **@NoArgsConstructor**
	It will generate a constructor with no parameters. If this is not possible (because of final fields), a compiler error will result instead, unless @NoArgsConstructor(force = true) is used, then all final fields are initialized with 0 / false / null. For fields with constraints, such as @NonNull fields, no check is generated,so be aware that these constraints will generally not be fulfilled until those fields are properly initialized later. Certain java constructs, such as hibernate and the Service Provider Interface require a no-args constructor. This annotation is useful primarily in combination with either @Data or one of the other constructor generating annotations.
- **@Id**
	As in tables, entities also require an identifier (@Id), which must differentiate the entity from the rest. As a general rule, all entities must define an ID, otherwise we will cause the EntityManager to mark an error when instantiating it. The ID is important because it will be used by the EntityManager when persisting an object, and it is because of this that it can determine which record to do the select, update or delete on. JPA supports simple IDs with a single field or complex IDs made up of more than one field. To determine the ID of an entity is as simple as putting the @Id annotation on the property that would be the ID of the entity. The ID can be any data type supported by JPA, such as all primitive types and wrapper classes, enumerations, and Calendar.
- **@GeneratedValue**
	This annotation provides the specification of generation strategies for primary key values. The strategy attribute is used to specify the primary key generation strategy that the persistence provider should use to generate the annotated entity's primary key. It is an optional attribute. The values ​​of the strategy are defined in the javax.persistence.GeneratorType enumeration, which are as follows: AUTO (based on database support for the primary key generation framework, decides what type of generator to use), IDENTITY (in this case the database is responsible for determining and assigning the next primary key), SEQUENCE (a sequence specifies a database object that can be used as a source of primary key values; uses @SequenceGenerator), TABLE ( maintains a separate table with the primary key values; uses @TableGenerator). The default is AUTO.
- **@Column**
	This annotation will allow us to define very important aspects of the database columns such as name, length, constraints, etc. In case of not defining this annotation in the attributes, JPA will determine the name of the column automatically through the name of the attribute, so it is always advisable to establish this annotation in all the attributes of the class and avoid problems.
	The properties that we can define are: name (allows you to set the name of the column of the table with which the attribute must map), length (allows you to define the length of the column in characters, only applies to Strings, in other types of data will be omitted), insertable (indicates to JPA if that column should be taken into account in the inserts, if it is 'true', the value will be inserted, otherwise the value will be omitted and the value ' will be placed default' of the column or 'null'), updatable (similar to the previous case, only in this case the column is taken into account for Update operations), nullable (creates a constraint on the table, 'not null', to prevent null values ​​from being inserted), scale (used only for columns that must have decimals, as values ​​it receives the number of decimals), table, unique (will create a table constraint to make the value of that column unique).
- **@ManyToOne**
	Allows you to map one entity to another. As the only rule, the class needs to be an entity, that is, it is also annotated with @Entity. It has the following attributes: optional (indicates if the relationship is optional, that is, if the object can be null), cascade (this property indicates which cascading operations can be performed with the related entity, possible values ​​are ALL, PERSIST , MERGE, REMOVE, REFRESH, DETACH and are defined in the javax.persistence.CascadeType enumeration), fetch (this property is used to determine how the entity should be loaded, the values ​​are defined in the javax.persistence.FetchType enumeration and the possible values ​​are eager and lazy), targetEntity (this property receives a class which corresponds to the class of the relationship).
- **@JoinColumn**
	It is used to mark a property that requires a JOIN in order to access it. It has almost the same properties as @Column. With @JoinColumn we could define the exact name of the column, if it admits nulls, if it is updateable, insertable, indicate if we want it to generate the foreign key or not or even tell it to generate the Join.
	The properties are the following: name (indicates the name with which the column must be created within the table), referencedColumnName (used to indicate the column on which the Join of the other table will be performed), unique (creates a constraints in the table to prevent duplicate values), nullable (creates a constraint on the table to prevent null values), insertable (tells JPA if this value should be saved on the insert operation), updatable (tells JPA if the value must be updated during the update process), columnDefinition (this property is used to indicate the SQL statement that should be used when creating the column in the database; it helps us to define exactly how the column will be created without depending on the configuration of JPA), table (we indicate on which table the JOIN should be performed), foreignKey (indicates to JPA if it should create the Foreign Key, this property receives one of the following values ​​CONSTRAINT, NO_CONSTRA INTS, PROVIDER_DEFAULT, defined in the javax.persistence.ForeighKey enumeration.
- **@Getter** and **@Setter**
	You can annotate any field with @Getter and/or @Setter, to let lombok generate the default getter/setter automatically. A default getter simply returns the field, and is named getFoo if the field is called foo (or isFoo if the field's type is boolean). A default setter is named setFoo if the field is called foo, returns void, and takes 1 parameter of the same type as the field. It simply sets the field to this value.
	The generated getter/setter method will be public unless you explicitly specify an AccessLevel, as shown in the example below. Legal access levels are PUBLIC, PROTECTED, PACKAGE, and PRIVATE.
	You can also put a @Getter and/or @Setter annotation on a class. In that case, it's as if you annotate all the non-static fields in that class with the annotation.

### Object declaration to achieve layer decoupling through dependency injection.


### Testing with Postman


### DTO classes
