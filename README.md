# Aim of Project
- Model a set of Microservices

- Apply Service discovery , Configuration and secret management

- Deploy and scale your solution on a cluster

# In Brief

In this project we have bunch of microservices deployed on minikube. MySql as database to persist information. We have successfully used configuration and secret management. For service discovery requirement, we used kubernete ribbon. As per requirement we selected replication factor of 2. All source codes are written in java spring boot platform. There is a JWT authentication for client facing. And for inner service communication, we used API token.




### How to run it?

### Installation
Requires minikube and kubernetes installed.

See [How to install minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)


### Deploy services
```sh
$ ## Following is example how to deploy register-service
$ cd register-service ## change directory to desired service folder.
$ mvn clean install -DskipTests  ## create jar file:
$ eval $(minikube docker-env)
$ docker build -t nameOfDockerImage .
$ kubectl apply -f deployments/register-service.yaml
$ minikube dashboard ## check dash board to see the service deployed
```


### Testing Using PostMan
This requires PostMan installed on your machine.
For User sign up/register
MAKE a POST request with following data:

http://SOME-URL/signup
content-type: application/json

{
    "email":"test@gmail.com",
    "password":"test",
    "name":"Test",
    "prefferedPayment":"CC",
    "address":"UTOPIA",
    "roles":[1]  
}

Explanation:
Here SOME-URL is the url that your service is exposed to. You can view using 
```sh
$ kubectl get services
batch-app-mysql    ClusterIP   None            <none>        3306/TCP         26h
catalog-service    NodePort    10.99.252.197   <none>        8090:31092/TCP   62m
kubernetes         ClusterIP   10.96.0.1       <none>        443/TCP          26h
register-service   NodePort    10.99.63.155    <none>        8090:31090/TCP   19h

$ minikube service register-service ## this will give SOME-URL that you need to use in POST MAN to test
```
Here, in field "roles" we accept array of integer which represents
* 1: ADMIN
* 2: USER

We can even add more roles as our wish. After sending request, we will receive some response with data we send to and is persisted on database. Password is encrypted using BCryptPasswordEncoder.

After this do similar POST request to 

http://SOME-URL/signin
content-type: application/json

{
    "username":"test@gmail.com",
    "password":"test"
}

You will receive jwt token as response.

Now for every request you send for client facing send this jwt token in header as 
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MTIzQGdtYWlsLmNvbSIsImV4cCI6MTU3MzUwMTg0NiwiaWF0IjoxNTczNDgzODQ2fQ.FrM4FlL89gtTu4NIFj_6H4xFq2hwmmfCI3aNxu533dL9GqQpreuoUjANNkgGc32f-giYrJHdjqZtCp13j2Cucg

### View Catalog
Just use url for catalog and send request as 
GET request:
http://SOME-URL/products/getProducts

You will receive list of products available in database. Make sure there is products added on database. OR it will response as empty array [].

For adding product make POST request to:
http://104.154.246.139:8080/products/addproduct  (here 104.154.246.139:8080 is SOME-URL as previous)
content-type: application/json

{
    "productId":"3",
    "productName":"Product3",
    "vendor":"Vendor3",
    "category":"Category3"
}







Group Members
----
- Soliman, Mohamed Hany Salem Hamdy (986610)
- Suresh Prajapati (109524)


