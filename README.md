This application is based on microservice architecture and restful api to store all link about wiki recent updates and you can view random wiki page 
that is recently updated.
And they will store your visited link into a database and you can go see which ones you visited.
I used technologies such as spring boot, spring data jpa, kafka, eureka. The whole applications is all about backend technologies. There is no view or frontend framework

QuickStart Guide

1. First run docker and kafka
2. create two databases on pgAdmin page(1."recent_changes" 2. "read_changes")(Please check docker-compose.yml for more detail)
3.      "recent_changes" is for getting live from wiki rest api and store links into this
4.      "read_changed" is for links you have read(you will have to request random articles which is recently updated.
5. run three microservices
6.      Eureka_Server - this is eureka server and it stores instances of other microservices
7.      Wiki_Recent_Changes - this one is getting live data from wiki live api and stores links to database(recent_changes)
8.      ReadRandomFromWikiChange - this one is getting random webpage that is was recently updated. She asked wiki_recent_changes through rest api and getting random links

Eureka Server
  
  http://localhost:9411
  
Wiki_Recent_Changes

  http://localhost:8080/api/count = to know how much links you have stored
  
ReadRandomFromWikiChange

 http://localhost:8081/random = you can visit random pages that were recently updated and it will store the links you visited.(This will ask random links from
 Wiki_Recent_Changes through REST API)
 
 http://localhost:8081/read = you can see the links you have visited and you can revisit again if you care.
