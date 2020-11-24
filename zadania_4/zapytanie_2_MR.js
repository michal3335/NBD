var mapFunction2=function(){
	for (var i in this.credit){
		emit(this.credit[i].currency,this.credit[i].balance);
	}

};

var reduceFunction2=function(id,values){

	return Array.sum(values);
};

db.people.mapReduce(mapFunction2,reduceFunction2,{"out":"result2"});

printjson(db.result2.find().toArray());

