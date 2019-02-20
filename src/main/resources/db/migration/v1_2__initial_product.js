//mongeez formatted javascript
//changeset system:v1_2
db.createCollection("product");

db.product.insert({
	"category": NumberInt(1),
	"name": "",
	"currency" : 'USD',
	"price" : NumberDecimal("0"),
	"quantity" : NumberInt(1),
	"score": NumberDecimal("5.0"),
	"description": "",
	"image": "",
	"detail": {
		"serial_number": "1",
		"dimensions": "",
		"weight": "0.0"
	}
});

db.product.createIndex({"category" : NumberInt(1)},{"name" : "category_product"});