## Summary
1.  Framework -> SerenityBDD + Selenium
2.  Test Runner -> JUnit

* There are two feature files in the project. These feature files have totally *13* scenarios.
* All Login Cases covered.
* 4 End2End Checkout/Payment test cases covered.
* Checkout Feature -> swaglabs-bdd/src/test/resources/features/checkout/checkout.feature
* Login Feature -> swaglabs-bdd/src/test/resources/features/checkout/login.feature



## How to run tests ?

1. Clone https://github.com/berkaykirmizioglu/swaglabs-bdd
2. Go into project directoy (swaglabs-bdd)
3. Running all test from terminal, just type
````
mvn clean install verify
````

**Important Note:**
If you face with driver error, please update your Chrome driver according to your browser version.
Download driver from **https://chromedriver.chromium.org/downloads** and update Chrome driver at **swaglabs-bdd/src/test/resources/webdriver** 

*Headless Mode Option*
````
mvn clean install verify -Dheadless.mode=true
````


**Note:**
If you want to run with tags
````
mvn clean install verify -Dtags='login'
````
or

````
mvn clean install verify -Dtags='checkout'
````

## Running Parallel on the Scalable Grid - Zalenium
````
# Pull docker-selenium
docker pull elgalu/selenium

# Pull Zalenium
docker pull dosel/zalenium

# Run it!
docker run --rm -ti --name zalenium -p 4444:4444 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v /tmp/videos:/home/seluser/videos -e WAIT_FOR_AVAILABLE_NODES=false \
  --privileged dosel/zalenium start --desiredContainers 4
````
Run the command above and your Zalenium grid available at *http://localhost:4444/wd/hub*

Then just run the command below;
````
mvn clean verify -Dwebdriver.driver=remote -Dwebdriver.remote.url='http://localhost:4444/wd/hub'
````

## How to control test results ?

1. Go to '_target/site/serenity_' directory.
2. Open the **index.html** file


**Test Results Generated At:**
swaglabs-bdd/target/site/serenity/index.html

