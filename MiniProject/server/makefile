make-jar:
	mvn clean install -DskipTests
	@echo "DOne!"
    

dockerize:
	mvn com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/$$GOOGLE_CLOUD_PROJECT/jwt-auth:v1
	gcloud container clusters get-credentials standard-cluster-1 --zone us-central1-a
	kubectl run jwt-auth --image=gcr.io/$$GOOGLE_CLOUD_PROJECT/jwt-auth:v1 --port=8080
	kubectl expose deployment jwt-auth --type=LoadBalancer 

scale:
	kubectl scale deployment jwt-auth --replicas=3 

connect-db:
	kubectl exec -it some-mysql -- mysql -uroot -pexample-password 

make-all: make-jar dockerize
   