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
                sh "mkdir -p /mnt/jenkins/${env.BRANCH_NAME}"
                sh "rm ./target/original*"
                sh "scp -i ~/.ssh/id_rsa ./target/*.jar /mnt/jenkins/${env.BRANCH_NAME}/"
            }
        }
    }

}
