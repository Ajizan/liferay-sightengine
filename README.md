# liiferay-sightengine
Liferay SightEngine plugin. API service provided by https://sightengine.com/

## Abstract 
> Liferay-sightengine is a liferay tool that allows connection to the api of SightEngine image moderation, image moderation is used to filter images to ultimately accept only the most appropriate images as needed

## Tech/framework used

* This connector has been developed in liferay 7.1.2 CE and works with Sight Engine version 1.0

## How To Use

> The main function exists in the SightEngineServiceImpl.java class with three types of parameters, either you call the function using a file or a byte array or a Stram input.

The function returns True if the image is considered appropriate otherwise it returns False

## Configuration 
> * To begin, you have to change the configuration of the project.

* Mandatory

> First of all it is necessary to connect to Sight Engine to have the identifier and the secret key, after modifying these two fields.

![image](https://raw.githubusercontent.com/Ajizan/liferay-sightengine/master/Img/Credentials.png)

* Optional

> For this connector we worked with the three models (Nudity, Wad, Offensive) to add new models, just modify the configuration file while changing the cardinality according to the number of models used (Of course it is necessary that the models be supported by SightEngine)

![image](https://raw.githubusercontent.com/Ajizan/liferay-sightengine/master/Img/Models.png)

> Finally we put a threshold for each class, if you add new models it will be necessary to add the threshold for this model

![image](https://raw.githubusercontent.com/Ajizan/liferay-sightengine/master/Img/Thresholds.png)



