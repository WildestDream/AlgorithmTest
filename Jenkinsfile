pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean build'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}