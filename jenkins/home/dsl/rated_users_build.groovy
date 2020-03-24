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
        maven('clean package')
        shell('cp target/*.war ./')
//        shell('docker build -t rated-users-service ./src/main/docker') TODO not able to build container inside of the container
    }
    publishers {
        archiveArtifacts '*.war'
    }
}