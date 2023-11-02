## Useful commands
```
General Docker commands
----------------
docker build -t java-crud-gh-actions .
docker run java-crud-gh-actions
docker inspect 21b8 | grep IPAddress
----------------

Enable in the GCP console:
----------------
Google Container Registry API
Cloud Resource Manager API
Cloud Build API
----------------

Install the gcloud CLI
----------------
curl -O https://dl.google.com/dl/cloudsdk/channels/rapid/downloads/google-cloud-cli-452.0.0-linux-x86_64.tar.gz
tar -xf google-cloud-cli-452.0.0-linux-x86_64.tar.gz
export CLOUDSDK_CORE_DISABLE_PROMPTS=1
./google-cloud-sdk/install.sh
In another terminal:
export PATH=$PATH:~/temp/google-cloud-sdk/bin/
gcloud init
----------------

Commands to be used before pushing the image to Google Container Registry
----------------
gcloud auth login
or
gcloud auth activate-service-account github-actions@gh-actions-403902.iam.gserviceaccount.com --key-file=/home/bruno/.docker/gh-actions-403902-3190da419204.json

gcloud auth configure-docker
or
gcloud auth configure-docker --quiet

gcloud auth list
gcloud config set project gh-actions-403902

key=~/.docker/gh-actions-403902-3190da419204.json
cat "$key" | docker login -u _json_key --password-stdin https://gcr.io
----------------

Generate tag and push it to Google Container Registry
----------------
docker tag java-crud-gh-actions gcr.io/gh-actions-403902/java-crud-gh-actions
docker push gcr.io/gh-actions-403902/java-crud-gh-actions
----------------
```

## Useful links
[Instalar a CLI gcloud](https://cloud.google.com/sdk/docs/install?hl=pt_BR&_ga=2.244569217.-529178150.1698869578&_gac=1.255928825.1698869578.CjwKCAjw7oeqBhBwEiwALyHLM13TnO52jAxqtiybAwPU5qdFvRb-VpZGkKlAaGbHozT1MZHrw2VKexoCqj8QAvD_BwE)  
[Guia de início rápido do Container Registry](https://cloud.google.com/container-registry/docs/quickstart?hl=pt-BR)  
[Authentication methods](https://cloud.google.com/container-registry/docs/advanced-authentication)  
[Access control with IAM](https://cloud.google.com/container-registry/docs/access-control#permissions)  
[gcloud auth configure-docker](https://cloud.google.com/sdk/gcloud/reference/auth/configure-docker)  
[Push the Docker image to the Google Container Register](https://www.harubears.com/en/push-the-docker-image-to-the-google-container-register/)  
[Run Docker on GCP Compute Instance VMs to deploy dockerized applications](https://www.pascallandau.com/blog/gcp-compute-instance-vm-docker/)   
[Build a Docker Image and Publish It to GCP GCR & Artifact Registry using Github Actions](https://www.youtube.com/watch?v=6dLHcnlPi_U)  
[Spring Boot CRUD Example with H2 Database](https://www.javaguides.net/2020/04/spring-boot-h2-jpa-hibernate-restful-crud-api-tutorial.html)   
[google-java-format Plugin for Intellij](https://plugins.jetbrains.com/plugin/8527-google-java-format)  
[google-java-format config for Intellij](https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config)  
[Spring Boot With H2 Database](https://www.baeldung.com/spring-boot-h2-database)  
[Quick Guide on Loading Initial Data with Spring Boot](https://www.baeldung.com/spring-boot-data-sql-and-schema-sql)  
