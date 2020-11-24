printjson(db.people.aggregate([{$group:{_id:"$nationality",
minBMI:{$min:{$multiply:[{$divide:["$weight",{$multiply:["$height","$height"]}]},10000]}},maxBMI:{$max:{$multiply:[{$divide:["$weight",{$multiply:["$height","$height"]}]},10000]}},avgBMI:{$avg:{$multiply:[{$divide:["$weight",{$multiply:["$height","$height"]}]},10000]}}}}]).toArray())
