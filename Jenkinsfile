pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Deploy') {
            input {
                message "继续执行压测?"
            }
            steps {
                bat 'mvn clean install'
            }
        }
    }
}