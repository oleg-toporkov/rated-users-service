job('rated-users-service-build') {
    scm {
        git {
            remote {
                github('oleg-toporkov/rated-users-service', 'https')
            }
            branch('master')
        }
    }
    steps {
        shell('mvn site')
        shell('cp target/*.war ./')
        shell('docker build -t rated-users-service ./src/main/docker')
    }
    publishers {
        archiveArtifacts '*.war'
    }
}