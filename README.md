# Marketplace-back

It's the CondorLabs Technical Test

## Pre Installation
To have installed Java 8 in the testing machine here I add the installation links

## Windows

#### * Install JDK 8
Please download the one that does not use demos and samples

https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

#### * Create environment variables
Please follow the steps

https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=389:configurar-java-en-windows-variables-de-entorno-javahome-y-path-cu00610b&catid=68&Itemid=188


##Linux/MAC

#### * Install JDK 8
Please download the one that does not use demos and samples

https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

#### * Create environment variables
Please follow the steps

##### - Mac
https://hecthormedina.wordpress.com/2013/10/27/como-configurar-la-variable-de-entorno-java_home-en-mac-os-x-y-no-morir-en-el-intento/

##### - Linux
https://angelsw.wordpress.com/2011/03/29/variable-de-entorno-e-java-en-linux/

## Installation, Execute Project and Test in Intellij IDEA 

You can use the Intellij IDE that performs the auto import of the dependencies of the project and that facilitates the execution of the project by right clicking the MarketplaceApplication.java class and then running.

You can also use the IDE to run the tests in the src / test / java route and each class you can give right click and then run



## Installation Command Line

The project uses gradle to automate the construction of the project, please download the dependencies and then execute the following commands

Windows

```bash
gradlew clean build
``` 
Linux/MAC

```bash
./gradlew clean build
``` 

## Execute Tests of the Project Command Line

Windows

```bash
gradlew test
``` 
Linux/MAC

```bash
./gradlew test
``` 


## Execute Project Command Line

Windows

```bash
java -jar build\libs\marketplace-0.0.1-SNAPSHOT.jar
``` 

Linux/MAC

```bash
java -jar ./build/libs/marketplace-0.0.1-SNAPSHOT.jar
``` 

## Mongeez
The project uses Mongeez for the generation of the tables and insert of configuration to be able to connect it to the local database change in the appication.properties DataSource settings, but before that a database must be created

## Paths

##### Get all Products
##### GET
```bash
/api/marketplace/findall/product-score
```

##### Get Product by Name or Category
##### GET
```bash
/api/marketplace/findall/product/category?name=xbox&category=3
```

##### Add Card
##### POST
```bash
/api/marketplace/add/cart
```

##### Example Json Body
```javascript
[
	{
        "id" : "5c6e41220f822ceb22432232",
        "quantity" : 5
    },
    
    {
        "id" : "5c6e41220f822ceb22432234",
        "quantity" : 2
    },
    
    {
        "id" : "5c6e41220f822ceb22432236",
        "quantity" : 3
    }
 ]
 ```

##### Get Detail Card
##### GET
```bash
/api/marketplace/detail/cart?idCart=5c...
```

##### Remove Product in Card
##### POST
```bash
/api/marketplace/remove/product-cart?idCart=5c...&idProduct=5c...
```

## Healt
The health was added to be able to verify the status of the api

##### Check the status of the api
##### GET
```bash
/api/marketplace/actuator/health
```

## PostMan

It shares the path of the api by postman to generate ease at the time of testing

https://www.getpostman.com/collections/c1c620d3a15f97db6536

