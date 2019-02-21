//mongeez formatted javascript
//changeset system:v1_3
db.createCollection("cart");

db.cart.insert({
	"products": [
		{
            "id" :  new ObjectId(),
            "quantity" : NumberInt(1)
        },
        {
            "id" : new ObjectId(),
            "quantity" : NumberInt(1)
        },
        {
            "id" : new ObjectId(),
            "quantity" : NumberInt(1)
        }
	],
	"totalMount": NumberDecimal("0.0"),
	"quantity": NumberInt(1),
	"dateCart": new Date()
})