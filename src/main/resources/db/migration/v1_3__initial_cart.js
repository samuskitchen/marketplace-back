//mongeez formatted javascript
//changeset system:v1_3
db.createCollection("cart");

db.cart.insert({
	"products": [
		{
            "id" : ObjectId("5c6c9687c461d5784fecd3c2"),
            "quantity" : NumberInt(1)
        },
        {
            "id" : ObjectId("5c6c99355e00ce085aa22257"),
            "quantity" : NumberInt(1)
        },
        {
            "id" : ObjectId("5c6c9b575e00ce085aa22258"),
            "quantity" : NumberInt(1)
        }
	],
	"totalMount": NumberDecimal("0.0"),
	"quantity": NumberInt(1),
	"dateCart": new Date()
})