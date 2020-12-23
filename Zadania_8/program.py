import riak

client = riak.RiakClient(port=8098)
bucket_car = client.bucket('car')

car = bucket_car.new('bmw', data = {'brand': 'bmw', 'fuel': 'diesel', 'horsepower': '300','created': time.time()})
car.store()

object = bucket_car.get('bmw')
print(object.data)

object.data["fuel"] = 'petrol'
object.store()

object = bucket_car.get('bmw')
print(object.data)

object.delete()

object = bucket_car.get('bmw')