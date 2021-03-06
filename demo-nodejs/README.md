# demo-nodejs
This module is used to get one's feet wet with K8s.
It contains the steps to build and run the demo-nodejs app. 
It will look at how to test, expose, scale, update and rollback.

These commands were run using Ubuntu running on VirtualBox. Note: sudo will be used to execute commands with elevated privileges.

## Steps for pre-built environment
Open a new terminal and cd to demo-nodejs/
### 1) Verify Minikube is 'Running'
Check the minikube status (Minikube: Running; kubectl: Currently Configured):
```
sudo minikube status
```

If the minikube status is 'Stopped', run the following:
```
sudo minikube start --vm-driver=virtualbox
```

### 2) Check image exists
Check demo-nodejs:v1 image exists:
```
docker images demo-nodejs:v1
```

### 3) Creating a deployment
Initially there will be no deployments:
```
sudo kubectl get deployments
```

Create a new deployment (starting with 2 replicas):
```
sudo kubectl create -f kubernetes/deployment.yml
```

Verify deployment:
```
sudo kubectl get deployments
```

Verify pods:
```
sudo kubectl get pods
```

### 4) Checking the App
Open a new terminal and enter the following to start the proxy:
```
sudo kubectl proxy
```

Open a Web browser and enter the following (replace POD_NAME_GOES_HERE with the pod name):
```
http://localhost:8001/api/v1/proxy/namespaces/default/pods/POD_NAME_GOES_HERE/
```

View logs:
```
sudo kubectl logs -f POD_NAME_GOES_HERE
```

### 5) Exposing the App
Create a service:
```
sudo kubectl create -f kubernetes/service.yml
```

View service:
```
sudo kubectl get services
```

Test service:
```
sudo minikube service demo-nodejs
```

### 6) Scaling the App
Check the current instances:
```
sudo kubectl get deployments
sudo kubectl get pods
```

Scale the application to have 3 replicas:
```
sudo kubectl scale deployments/demo-nodejs-deployment --replicas=3
```

Verify results:
```
sudo kubectl get deployments
sudo kubectl get pods -o wide
```

Scale the application back down to 2:
```
sudo kubectl scale deployments/demo-nodejs-deployment --replicas=2
```

### 7) Update code and roll in the update
Make a change - add a new line with your favourite quote in server.js:
```
gedit server.js
```

Create a new image and tag with v2:
```
docker build -t demo-nodejs:v2 .
```

Update the deployment.yml file and set image to demo-nodejs:v2
```
# use any text editor to update the file
gedit kubernetes/deployment.yml
```

Roll in the new updates to the current deployment:
```
sudo kubectl replace -f kubernetes/deployment.yml
```

Verify results:
```
sudo kubectl rollout status deployments/demo-nodejs-deployment

sudo minikube service demo-nodejs
```

### 8) Rollback the changes
Revert back to the previous deployment:
```
sudo kubectl rollout undo deployments/demo-nodejs-deployment
```

Verify results:
```
sudo kubectl rollout status deployments/demo-nodejs-deployment

sudo minikube service demo-nodejs
```

### 9) Dashboard
Close your web browser and execute the below command:
```
sudo minikube dashboard
```

### 10) Clean up resources
If you decide to remove the deployment and services, then run:
```
sudo kubectl delete service demo-nodejs

sudo kubectl delete deployment demo-nodejs-deployment
```

Stop Minikube:
```
sudo minikube stop
```

## Steps for clean environment
TODO