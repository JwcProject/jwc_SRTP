# jwc_SRTP

### Steps for setup:

1. checkout to the local machine
2. modify the `username` and `password` to your mysql specification
3. modify the `project structure` or build artifact if needed
4. configure the tomcat run/debug configuration

### Attentino:

You **must** keep your database clean before running the server.

----

### Maven CLIs:

+ `mvn clean` to clean the project
+ `mvn war:war` to generate the war
+ `mvn cargo:deploy` to deploy the war to tomcat's wabapp dir

### Attention:

+ `$CATALINA_HOME` **must** fit your own.
+ The version of tomcat **must** fit your own(`tomcat7x` for 7 and `tomcat8x` for 8).
