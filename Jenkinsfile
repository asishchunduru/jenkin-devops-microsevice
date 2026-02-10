pipeline {
	agent { docker { image 'maven:3.9.12'} }
	stages {
		stage('Build') {
			steps{
				sh  'maven --version'
				echo "Build"
			}
		}
		stage('Test') {
			steps{
				echo "Test"
			}
		}
		stage('Intergration Test') {
			steps{
				echo "Intergration Test"
			}

		
		}
	} 
	post {
		always{
			echo "i am good always"
		}
		success{
			echo "i work for success"
		}
		failure{
			echo "keep trying"
		}
	}
}
	