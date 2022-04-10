pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                sh "echo ${env.POM_ARTIFACTID}"
                sh "echo ${POM_ARTIFACTID}"
                sh "scp -i ~/.ssh/id_rsa ./target/${env.POM_ARTIFACTID}.jar"
            }
        }
    }

}