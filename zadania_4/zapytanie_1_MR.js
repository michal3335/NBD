var mapFunction1=function(){
	emit(this.sex,{"weight":parseInt(this.weight),"height":parseInt(this.height),"count":1});
	
};

var reduceFunction1=function(key,values){
	var value={"weight":0.0,"height":0.0,"count":0};
	for(var i=0;i<values.length;i++){
		value.count+=values[i].count;
		value.weight+=values[i].weight;
		value.height+=values[i].height;
	}

return value;

};


var finalizeFunction1=function(key,value){

	value.avg_weight=(value.weight/value.count);
	value.avg_height=(value.height/value.count);
	return value;
};


db.people.mapReduce(mapFunction1,reduceFunction1,{"out":"result1","finalize":finalizeFunction1});

printjson(db.result1.find({},{_id:1,"value.avg_weight":1,"value.avg_height":1}).toArray());


