# 

## Model
www.msaez.io/#/courses/cna-full/753b22b0-f3d8-11ef-82c0-d1cecf27046d/biz-phone-loss-and-found

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- phone
- lostservice
- gps
- dashboard


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- phone
```
 http :8088/lostPhones id="id"userId="userId"imei="IMEI"lostStatus="lostStatus"imeiStatus="IMEIStatus"lockStatus="lockStatus"phoneId="phoneId"
 http :8088/phones id="id"imei="IMEI"userId="userId"
```
- lostservice
```
 http :8088/phoneChanges id="id"userId="userId"lostPhoneId="lostPhoneId"status="status"
```
- gps
```
 http :8088/destinations id="id"time="time"x="x"y="y"phoneId="phoneId"
```
- dashboard
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
