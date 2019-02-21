//mongeez formatted javascript
//changeset system:v1_1
db.createCollection("category");

db.category.insert({
    "id_category" : NumberInt(1),
    "name" : "Libros",
    "activate" : true
});

db.category.insert({
    "id_category" : NumberInt(2),
    "name" : "Hogar y Cocina",
    "activate" : true
});

db.category.insert({
    "id_category" : NumberInt(3),
    "name" : "Videojuegos",
    "activate" : true
});

db.category.insert({
    "id_category" : NumberInt(4),
    "name" : "Televisiones",
    "activate" : true
});

db.category.createIndex({"id_category" : NumberInt(1)},{"name" : "id_category", "unique": true});