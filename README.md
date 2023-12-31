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
Cloud Run API
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

Deploy on Google Cloud Run
----------------
gcloud run deploy java-crud-gh-actions --image gcr.io/gh-actions-403902/java-crud-gh-actions --platform managed

Link to access deployed service
https://java-crud-gh-actions-ktptbevp5q-ue.a.run.app/products
----------------

Some other commands used to configure GCP or extract info from it
----------------
gcloud iam workload-identity-pools describe "gh-actions-pool" \
  --project="gh-actions-403902" \
  --location="global" \
  --format="value(name)"

gcloud iam service-accounts add-iam-policy-binding "github-actions@gh-actions-403902.iam.gserviceaccount.com" \
  --project="gh-actions-403902" \
  --role="roles/iam.workloadIdentityUser" \
  --member="principalSet://iam.googleapis.com/projects/562977656557/locations/global/workloadIdentityPools/gh-actions-pool/attribute.repository/brunosantanati/java-crud-gh-actions"
----------------
```

## Useful links
[Instalar a CLI gcloud](https://cloud.google.com/sdk/docs/install?hl=pt_BR&_ga=2.244569217.-529178150.1698869578&_gac=1.255928825.1698869578.CjwKCAjw7oeqBhBwEiwALyHLM13TnO52jAxqtiybAwPU5qdFvRb-VpZGkKlAaGbHozT1MZHrw2VKexoCqj8QAvD_BwE)  
[Guia de início rápido do Container Registry](https://cloud.google.com/container-registry/docs/quickstart?hl=pt-BR)  
[Authentication methods](https://cloud.google.com/container-registry/docs/advanced-authentication)  
[Access control with IAM](https://cloud.google.com/container-registry/docs/access-control#permissions)  
[gcloud auth configure-docker](https://cloud.google.com/sdk/gcloud/reference/auth/configure-docker)  
[Configure access for Cloud Build Service Account](https://cloud.google.com/build/docs/securing-builds/configure-access-for-cloud-build-service-account?_gl=1*f2dbr9*_ga*NTI5MTc4MTUwLjE2OTg4Njk1Nzg.*_ga_WH2QY8WWF5*MTY5ODk0MTMzOC41LjEuMTY5ODk0MTQ0Ni4wLjAuMA..&_ga=2.184885037.-529178150.1698869578&_gac=1.62000478.1698941413.CjwKCAjwkY2qBhBDEiwAoQXK5X4NwI9oVkwLqUgFfUNi-w0mStRl-sE8LbmI0P--qWTVy1cc_Ho3ShoCWNUQAvD_BwE)  
[Push the Docker image to the Google Container Register](https://www.harubears.com/en/push-the-docker-image-to-the-google-container-register/)  
[Run Docker on GCP Compute Instance VMs to deploy dockerized applications](https://www.pascallandau.com/blog/gcp-compute-instance-vm-docker/)   
[Build a Docker Image and Publish It to GCP GCR & Artifact Registry using Github Actions](https://www.youtube.com/watch?v=6dLHcnlPi_U) -> [GitHub Repo](https://github.com/antonputra/lesson-087)   
[How to deploy any docker image on google cloud run](https://www.youtube.com/watch?v=fhje9idm8V4)  
[How to use Github Actions with Google's Workload Identity Federation](https://www.youtube.com/watch?v=ZgVhU5qvK1M)  
[Access Google Cloud from GitHub Action Sans Keys - Workload Identity Federation](https://www.youtube.com/watch?v=zRF5uTWXV8Y)   
[Setting up Workload Identity Federation](https://github.com/google-github-actions/auth#setup)  
[deploy-cloudrun GitHub Action](https://github.com/google-github-actions/deploy-cloudrun)   
[Spring Boot CRUD Example with H2 Database](https://www.javaguides.net/2020/04/spring-boot-h2-jpa-hibernate-restful-crud-api-tutorial.html)   
[google-java-format Plugin for Intellij](https://plugins.jetbrains.com/plugin/8527-google-java-format)  
[google-java-format config for Intellij](https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config)  
[Spring Boot With H2 Database](https://www.baeldung.com/spring-boot-h2-database)  
[Quick Guide on Loading Initial Data with Spring Boot](https://www.baeldung.com/spring-boot-data-sql-and-schema-sql)   
[Creating a JavaScript action](https://docs.github.com/en/actions/creating-actions/creating-a-javascript-action)  
[Storing workflow data as artifacts](https://docs.github.com/en/actions/using-workflows/storing-workflow-data-as-artifacts)  
[Testing REST API integrations using WireMock](https://testcontainers.com/guides/testing-rest-api-integrations-using-wiremock/)   
[Prevent a Bad Merge in GitHub Actions](https://calmcode.io/github-actions/prevent-merge.html)  
[GitHub Actions Page](https://github.com/features/actions)  
[GitHub Actions documentation](https://docs.github.com/en/actions)  
[Understanding GitHub Actions](https://docs.github.com/en/actions/learn-github-actions/understanding-github-actions)   
[Contexts](https://docs.github.com/en/actions/learn-github-actions/contexts)  
[Secrets and Environment Variables in your GitHub Action](https://dev.to/this-is-learning/secrets-and-environment-variables-in-your-github-action-1pfn)   
[Software Delivery Guide](https://martinfowler.com/delivery.html)  
[Continuous Integration](https://martinfowler.com/articles/continuousIntegration.html)  
[ContinuousDelivery](https://martinfowler.com/bliki/ContinuousDelivery.html)  
[Quickstart for GitHub Actions](https://docs.github.com/en/actions/quickstart)  
[Google Kubernetes Engine vs Cloud Run: Which should you use?](https://cloud.google.com/blog/products/containers-kubernetes/when-to-use-google-kubernetes-engine-vs-cloud-run-for-containers)  
