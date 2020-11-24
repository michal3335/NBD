var mapFunction2=function(){
	for (var i in this.credit){
		emit(this.credit[i].currency,{"balance":this.credit[i].balance,"count":1});
	}

};

var reduceFunction2=function(key,values){

	var value={"suma":0.0,"srednia":0.0,"count":0.0};

	
	for(var i=0;i<values.length;i++){
		value.count+=values[i].count;
		value.suma+=values[i].balance;
	}
value.srednia=value.suma/value.count;
return value;
};


db.people.mapReduce(mapFunction2,reduceFunction2,{"out":"result5", "query":{$and:[{"sex":"Female"},{"nationality":"Poland"}]}});

printjson(db.result5.find({},{}).toArray());


