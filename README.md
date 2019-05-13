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

![image](https://raw.githubusercontent.com/Ajizan/liferay-sightengine/master/Img/1.png)



