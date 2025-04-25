# Article service
In order to run this application locally, the following should be satisfied:
- GAIA-X service with news and articles or Mocking service (https://gitlab.com/gaia-x/data-infrastructure-federation-services/por/demo) 
should be accessible

## Configuration of external systems
Open the application.yml file and configure value for the services.articles.uri.internal setting representing URI for
GAIA-X service with news and articles. For instance:

~~~~
services.articles.uri.internal: http://gaia-x.identity.local:8081/demo/api
~~~~

Make sure that such external system is available from your host.


## Application run
With all these configurations, use the following command to run application:

~~~~
$ ./mvnw clean spring-boot:run
~~~~

The application should be started on localhost and use port, configured in application.yml file:

~~~~
server.port: 8084
~~~~
