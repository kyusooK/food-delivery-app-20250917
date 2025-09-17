# 

## Model
www.msaez.io/#/123912988/storming/c2926e325f4ef080dba46fb66b93ef85

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

- OrderManagement
- MenuManagement


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- OrderManagement
```
 http :8088/orders orderId="orderId"customerId="customerId"restaurantId="restaurantId"deliveryRiderId="deliveryRiderId"paymentId="paymentId"totalPrice="totalPrice"orderCreatedAt="orderCreatedAt"orderUpdatedAt="orderUpdatedAt"orderCancelledAt="orderCancelledAt"cancelReason="cancelReason"cookingStartedAt="cookingStartedAt"cookingCompletedAt="cookingCompletedAt"deliveryAssignedAt="deliveryAssignedAt"deliveryAcceptedAt="deliveryAcceptedAt"deliveryRejectedAt="deliveryRejectedAt"foodPickedUpAt="foodPickedUpAt"foodDeliveredAt="foodDeliveredAt"deliveryConfirmedAt="deliveryConfirmedAt"customerAddress="customerAddress"restaurantAddress="restaurantAddress"deliveryAddress="deliveryAddress"deliveryTrackingLocation="deliveryTrackingLocation"reviewAvailable="reviewAvailable"
```
- MenuManagement
```
 http :8088/menus menuId="menuId"isSoldOut="isSoldOut"isOrderable="isOrderable"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/menuSoldOutHistories historyId="historyId"changedBy="changedBy"previousSoldOutStatus="previousSoldOutStatus"newSoldOutStatus="newSoldOutStatus"changedAt="changedAt"
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
