

docker-compose -f src/main/docker/postgresql.yml up -d

http://localhost:8080/api/swagger-ui/

docker container run --name jenkins-blueocean --detach ^
--network skynet -u root ^
--volume jenkins-data:/var/jenkins_home ^
--volume /var/run/docker.sock:/var/run/docker.sock ^
--publish 8080:8080 --publish 50000:50000 jenkinsci/blueocean



docker container run --name jenkins-blueocean --detach --network skynet -u root --volume jenkins-data:/var/jenkins_home --volume /var/run/docker.sock:/var/run/docker.sock --publish 8080:8080 --publish 50000:50000 jenkinsci/blueocean


https://medium.com/qaninja/rodando-o-jenkins-em-um-container-docker-4772986eb801