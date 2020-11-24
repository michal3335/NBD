var mapFunction3=function(){
	emit(this.job,1);	
};



var reduceFunction3=function(key,values){


return Array.sum(values);

};




db.people.mapReduce(mapFunction3,reduceFunction3,{"out":"result3"});




printjson(db.result3.find({},{_id:1}).toArray());
