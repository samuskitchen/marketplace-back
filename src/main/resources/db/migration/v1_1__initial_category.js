//mongeez formatted javascript
//changeset system:v1_1
db.createCollection("category");

db.category.insert({
	"id_category": NumberInt(1),
	"name": "",
	"activate": false
});

db.category.createIndex({"id_category" : NumberInt(1)},{"name" : "id_category", "unique": true});