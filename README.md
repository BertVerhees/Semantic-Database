# semantic-database

work in progress.

The project will consist in at least three layers:

The Reference Model, this will be used to construct a reference model in OCL. It will be contained by an SPRING-gRPC API

The archetype-handling model, this will also be covered by a SPRING-gRPC API

After that, these will be packed in microservices and run isolated from the kernel-module.

The kernel-module will be written in Golang, and will act as spider in the web.

There will be an extra module, which will connect database, this will also be in gRPC API but probably not SPRING.

These are the plans.

For understanding the result, for now, I like to point you to the OpenEhr documentation, and see this project as generic broader project which is not bounded to a specific reference model, but has a reference model which can be designed and used for every purpose.

Have a nice day..
