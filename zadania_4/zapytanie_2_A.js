printjson(db.people.aggregate([{$unwind:"$credit"},{$group:{_id:"$credit.currency",srodki:{$sum:{$toDouble: "$credit.balance"}}}}]).toArray())

