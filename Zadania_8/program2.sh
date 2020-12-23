#!/bin/bash

curl -XPUT -H "Content-Type: application/json" -d '{"brand": "BMW", "model": "M4", "type": "car", "horsepower": "320", "color" : "blue"}' http://localhost:8098/buckets/s15262/keys/bmw

curl -i http://localhost:8098/buckets/s15262/keys/bmw

curl -XPUT -H "Content-Type: application/json" -d '{"brand": "BMW", "model": "M4", "type": "car", "horsepower": "500", "color" : "blue"}' http://localhost:8098/buckets/s15262/keys/bmw

curl -i http://localhost:8098/buckets/s15262/keys/bmw

curl  -XDELETE http://localhost:8098/buckets/s15262/keys/bmw

curl -i http://localhost:8098/buckets/s15262/keys/bmw