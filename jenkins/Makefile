.PHONY: build run start stop clean



build:
	docker build -t ebay-jenkins .

run:
	docker run -d --name=ebay-jenkins -p 8080:8080 -p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock ebay-jenkins

start:
	docker start ebay-jenkins

stop:
	docker stop ebay-jenkins

clean:
	docker rm -v ebay-jenkins

default: run