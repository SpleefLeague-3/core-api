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
                sh "rm ./target/original*"
                sh "scp -i ~/.ssh/id_rsa ./target/*.jar"
            }
        }
    }

}