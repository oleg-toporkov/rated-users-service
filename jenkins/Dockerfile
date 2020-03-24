FROM jenkins/jenkins:lts
LABEL maintainer = "toporkov.oleg@gmail.com"

# Create Jenkins Log Folder
USER root
RUN mkdir /var/log/jenkins
RUN chown -R jenkins:jenkins /var/log/jenkins

#Install additional tools
RUN apt-get update && apt-get install -y maven
USER jenkins

#Setup env
ENV JENKINS_REF="/usr/share/jenkins/ref"
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# copy scripts and ressource files
COPY ./home/*.* $JENKINS_REF/
COPY ./home/dsl $JENKINS_REF/dsl/
COPY ./home/jobs $JENKINS_REF/jobs/
COPY ./home/init.groovy.d $JENKINS_REF/init.groovy.d/

# install plugins
RUN /usr/local/bin/install-plugins.sh < $JENKINS_REF/plugins.txt