def imageTag

pipeline {
    agent {
        label 'master'
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }
    stages {
        stage('Checkout branch if needed') {
            when { expression { return !params.BRANCH.equals('master') } }
            steps {
                sh "git checkout ${params.BRANCH}"
            }
        }
        stage('Download gradle dependencies') {
            steps {
                sh './gradlew clean compileJava --console=plain --info'
            }
        }
      // stage('Liquibase update test DB') {
        // run migration for Test DB
//         }
        stage('Tests') {
            steps {
                sh './gradlew test --console=plain'
            }
        }
//        stage('Style tests') {
//            steps {
//               // code analysis, linting
//            }
//        }
        stage('Java build') {
            steps {
                sh './gradlew bootJar --console=plain'
            }
        }
//        stage('Sonarqube') {
// code analaysis
//        }
        stage('Docker build and push') {
            steps {
                script {
                    imageTag = "${BRANCH}.${BUILD_NUMBER}"
                    // add expression to push to AWS ECR
                }
            }
        }
//        stage('Create artifact version metadata') {

//        }
//        stage('Deploy to dev environment') {
//            }
//        }
    }
//     post{
//        always {
//        }
//    }
}
