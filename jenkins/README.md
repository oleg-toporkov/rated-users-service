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
1. Install all needed plugins.
2. Start automatically seedjob.
3. Make versions for docker containers with Jenkins.
4. Add slaves to Jenkins.
5. Create separate volume for Jenkins data.
6. Store credentials secure ;)
7. Java version?
8. Create separate repository for jenkins stuff.
9. Migrate to pipelines from freestyle jobs