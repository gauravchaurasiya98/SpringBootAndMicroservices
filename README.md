## Spring Cloud API Gateway
Make sure you are using the right URLs?
***
**Discovery**
> You must need to add this property in order to use **Discovery** url :
> spring.cloud.gateway.discovery.locator.enabled=true

* http://127.0.0.1:8765/CURRENCY-CONVERSION/currency-conversion/from/usd/to/inr/quantity/10
* http://127.0.0.1:8765/CURRENCY-CONVERSION/currency-conversion/feign/from/usd/to/inr/quantity/10
***
**LowerCase**
> You must need to add this property in order to use **LowerCase** url :
> spring.cloud.gateway.discovery.locator.lower-case-service-id=true

* http://127.0.0.1:8765/currency-conversion/currency-conversion/from/usd/to/inr/quantity/10
* http://127.0.0.1:8765/currency-conversion/currency-conversion/feign/from/usd/to/inr/quantity/10
***
**Discovery Locator Disabled and Custom Routes Configured**

* http://127.0.0.1:8765/get
* http://127.0.0.1:8765/currency-exchange/from/usd/to/inr
* http://127.0.0.1:8765/currency-conversion/from/usd/to/inr/quantity/10
* http://127.0.0.1:8765/currency-conversion/feign/from/usd/to/inr/quantity/10
* http://127.0.0.1:8765/currency-conversion-x/feign/from/usd/to/inr/quantity/10
***
