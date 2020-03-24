#Instruction
In order to build docker image and start it you can use `make`.
There are 5 main goals in `Makefile`:
* build - will build docker image _(as we not having versions so far, please make sure you've cleaned previous build)_
* run - run docker container with Jenkins
* start - start stopped Jenkins docker container
* stop - stop Jenkins docker container
* clean - remove docker container with Jenkins

(!) Default username/password is *admin/admin*.
New job dsl files can be added to `./home/dsl` folder.

###TODO:
1. Make versions for docker containers with Jenkins.
2. Add slaves to Jenkins.
3. Create separate volume for Jenkins data.
4. Store credentials secure ;)
5. Java version?
6. Create separate repository for jenkins stuff.
7. Migrate to pipelines from freestyle jobs
8. Not able to build application container inside of dockerized Jenkins.