spring boot - back end
reactjs - front end
use embedded database from springboot - h2


http://localhost:8080/api/criterias   GET all
api/criterias              POST request body
api/criterias/{id}         GET one
                            PUT one
                            delete




test for backend - Crud repo
curl http://localhost:8080/api/criterias

curl -X POST http://localhost:8080/api/criterias -d "{\"domain\": \"xx\", \"cloudProvider\": \"xx\", \"services\": \"xx\", \"existingComponent\": \"xx\"}" -H "Content-Type:application/json"

curl -X PUT http://localhost:8080/api/criterias/{id} -d "{\"domain\": \"xx\", \"cloudProvider\": \"xx\", \"services\": \"xx\", \"existingComponent\": \"xx\"}" -H "Content-Type:application/json"

curl -X DELETE http://localhost:8080/api/criterias/{id}


test for frondend - reactjs

1)
insert pom.xml
<plugin>
	<groupId>com.github.eirslett</groupId>
	<artifactId>frontend-maven-plugin</artifactId>
</plugin>

**do NOT install npm in this project
this plugin will install node.js and its package tool into target folders.
run from Maven plug in 

2)
react-frontend 
to create bundle.js file 
$ npm run watch  
#create bundle.js 

3)
run spring-boot
localhost:8080



connect to h2 from browser
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Pasword: <leave this empty>




reference: https://spring.io/guides/tutorials/react-and-spring-data-rest/ 