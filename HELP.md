### security
for this project keycloak has been used
for setup detail: https://www.youtube.com/watch?v=rbKzR6QWKLI
```docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:23.0.6 start-dev
```

## get authorization token
go to - postman - Authorization tab
remove expired tokens to avoid mismatch information clicking on Manage Tokens
Token Type will be empty or Access token

Header Prefix Bearer
Add authorization data to Request Headers
Auto-refresh token disabled
Share Token No

Configure New Token
Token Name: token
Grant Type: Client Credentials
Access Token URL: http://localhost:8181/realms/spring-boot-microservices-realm/protocol/openid-connect/token
Client ID: spring-cloud-client
Client Secret: get it on keycloack
Scope: openid offline_access
Client Authentication: Send as Basic Auth header
Click on Generate Access Token button