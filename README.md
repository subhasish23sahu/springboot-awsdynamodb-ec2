# Getting Started

This sample project demonstrates how to use AWS DynammoDB service with spring-boot framework as application .

#Author : Subhasish Sahu


# Requirements
1 - Java OpenJDK 1.8 to up
2 - Spring boot version 2x
3 - spring cloud framework

# dependencies with spring cloud AWS

pom.xml - add the following dependencies
````
    <!--JARs for AWS Dynamo DB-->
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk</artifactId>
            <version>1.11.506</version>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk-dynamodb</artifactId>
            <version>1.11.34</version>
        </dependency>
        <dependency>
            <groupId>com.github.derjust</groupId>
            <artifactId>spring-data-dynamodb</artifactId>
            <version>5.1.0</version>
        </dependency>
    <!--JARs for AWS Dynamo DB-->
````

Resources folder : 
````
resources
    application.properties
````

# deploy the jar file in EC2 AWS server

The EC2 instance must attache the roles with permissions Secret Manager see above

The server must install java 8 JDK ( Amazon Linux OS)


````
sudo yum install java-1.8.0-openjdk
````

We will put the jar file in /home/ec2-user/springboot_awsdynamodb-ec2.jar using WinSCP

````
cd /home/ec2-user
java -jar springboot_awsdynamodb-ec2.jar


````
