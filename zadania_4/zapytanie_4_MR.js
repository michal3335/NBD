var mapFunction1=function(){
	emit(this.nationality,{"bmi":(10000*this.weight/(this.height*this.height)),"count":1});
	
};

var reduceFunction1=function(key,values){
	
	var bmi_max=-1.0;
	var value={"min_bmi":Infinity,"max_bmi":-Infinity,"bmi":0.0,"count":0};
	for(var i in values){
		value.count+=values[i].count;
		value.bmi+=values[i].bmi;
		if(values[i].bmi<value.min_bmi)	
		{
			value.min_bmi=values[i].bmi;
		}
		if(bmi_max>value.max_bmi)	
		{
			bmi_max=values[i].bmi;
		}
		
	}
value.max_bmi=bmi_max;
return value;

};
var finalizeFunction1=function(key,value){

	value.avg_bmi=(value.bmi/value.count);
	
	return value;
};

db.people.mapReduce(mapFunction1,reduceFunction1,{"out":"result4","finalize":finalizeFunction1});


printjson(db.result4.find({},{_id:1,"value.min_bmi":1,"value.max_bmi":1,"value.avg_bmi":1}).toArray());



