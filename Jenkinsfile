pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/aitnacer-nabil/Happoy.git'
            }
        }

        stage('Clean and Test Category-Service') {
            steps {
                dir('Category-Service') {
                    sh 'mvn clean'
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo 'Test succeeded!'
        }

        failure {
            echo 'Test failed!'
        }
    }
}