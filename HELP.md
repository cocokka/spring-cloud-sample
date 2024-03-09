# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [MyBatis Generator](https://mybatis.org/generator/)
* [Mapper](https://github.com/abel533/mapper)


### Versions
* Spring Boot: 3.2.3
  * [doc](https://spring.io/projects/spring-boot)
* Spring cloud: 2023.0.0
  * [doc](https://spring.io/projects/spring-cloud)
* Spring Cloud Alibaba: 2022.0.0.0
  * [版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)
* Maven: 3.9.+
* Jdk: 17+
* MySQL: 8.+

### Issues

* Lombok: 1.18.30
  * tip: when i use 1.18.26, i got some error, so i use 1.18.30.
  ```none
  java: java.lang.NoSuchFieldError: Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid'
  ```
* [Springdoc](https://github.com/springdoc/springdoc-openapi)
  
  use springdoc-openapi-starter-webmvc-ui instead of springdoc-openapi-starter-webmvc-api, because when try to visit /swagger-ui/index.html,
  the latter one will throw 404 error.

* [consul]
  - call api via service name
  
      consul needs to enable loadbalancer, otherwise it will throw UnknownHostException if call APIs with registered service name.
      add @LoadBalanced annotation to restTemplate bean.
      ```txt
        "org.springframework.web.client.ResourceAccessException: I/O error on GET request for \"http://payment-service/payment/1\"
        java.net.UnknownHostException: payment-service
      ```
  - configuration refresh

    `@RefreshScope` is used to refresh configurations in runtime.
    should use `@Value` in parameter instead of field, because field would not be refreshed.
    ```java
      
      @Value("${myInfo.name}")
      private String applicationName;
  
      @RequestMapping("/getInfo")
      public String getInfo(@Value("${myInfo.name}") String name) {
         return applicationName + "---" + name;
      }
    ```
* [loadbalancer](https://docs.spring.io/spring-cloud-commons/reference/index.html)
  * Switching between the load-balancing algorithms, default is ```org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer```
* [openfeign](https://spring.io/projects/spring-cloud-openfeign#learn)
  * write an interface, and use ```@FeignClient``` to call it.
  * add ```@EnableFeignClients``` in application class to enable feign client.