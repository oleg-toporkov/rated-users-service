pipelineJob('rated-users-service-deploy') {
    stages {
        stage('Checkout sources') {
            steps {
                git branch: 'master', url: 'git@github.com:oleg-toporkov/rated-users-service.git'
            }
        }
        stage('Build application') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build docker container') {
            steps {
//                sh 'docker build -t rated-users-service ./src/main/docker' TODO not able to build container inside of the container
            }
        }
        stage('Run container') {
            steps {
                sh 'mvn spring-boot:run'
//                sh 'docker run -d --name=rated-users-service -p 8081:8080 rated-users-service'
            }
        }
        stage('Push application container') {
            steps {
                sh 'echo "Container pushed to docker hub!"'
            }
        }
        stage('Schedule deploy to production') {
            steps {
                sh 'echo "Gonna trigger production deploy job"'
            }
        }
    }
}