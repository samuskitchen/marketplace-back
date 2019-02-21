//mongeez formatted javascript
//changeset system:v1_2
db.createCollection("product");

db.product.insert({
	"category": NumberInt(1),
	"name": "El hobbit y el señor de los anillos",
	"currency" : 'COP',
	"price" : NumberDecimal("84071"),
	"quantity" : NumberInt(5),
	"score": NumberDecimal("4.0"),
	"description": "El hobbit y el señor de los anillos (el hobbit / la comunidad del anillo / las dos torres / el mercado de masas Libro de bolsillo",
	"image": "http://www.communitas.pe/22830-thickbox/pack-tolkien.jpg",
	"detail": {
		"Libro de bolsillo masivo": "1728 páginas",
		"Editor": "Del Rey (25 de septiembre de 2012)",
		"Idioma": "ingles",
		"Dimensiones del producto": "4.3 x 4.2 x 7 pulgadas.",
		"Peso de envío": "2 libras",
		"ISBN-10": "0345538374",
		"ISBN-13": "978-0345538376"
	}
});

db.product.insert({
    "category" : NumberInt(3),
    "name" : "Xbox One S",
    "currency" : "COP",
    "price" : NumberDecimal("900000"),
    "quantity" : NumberInt(10),
    "score" : NumberDecimal("5.0"),
    "description" : "Join the ranks with Battlefield V on Xbox One S. Pre-order the Xbox One S Battlefield V Bundle and enter mankind's greatest conflict as Battlefield goes back to its roots: world war 2. Join the ranks with a full-game download of Battlefield V Deluxe Edition containing paratrooper apparel for you company of soldiers, special assignments, and weekly airlifts. Whether you're rallying your troops, watching 4K movies, or streaming gameplay, there's never been a better time to game with Xbox One. (Game requires Xbox live Gold, sold separately). Genre shooter, Multiplayer online 2 to 64 players.",
    "image" : "https://compass-ssl.xbox.com/assets/f5/96/f5967de6-59db-4af0-80cf-461c03052eff.png?n=Results-Page_Page-Hero-0_X1S_1083x612.png",
    "detail" : {
        "Numero seria" : "B07GQGKZXK",
        "Dimensiones" : "43.7 x 29 x 11.4 pulgadas",
        "Peso" : "10.53 Libras"
    }
});

db.product.insert({
    "category" : NumberInt(4),
    "name" : "TV 47\" LED LG 47LM7600 FHD 3D",
    "currency" : "COP",
    "price" : NumberDecimal("2899900"),
    "quantity" : NumberInt(5),
    "score" : NumberDecimal("4.7"),
    "description" : "LG Cinema 3D Smart TV 47\" Incluye 4 lentes 3D, Magic Remote y Wi-Fi incorporado ",
    "image" : "https://media.aws.alkosto.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/8/8/8801031051359.jpg",
    "detail" : {
        "Marca" : "LG",
        "Pulgadas" : "47",
        "Velocidad de respuesta" : "240 Hz",
        "Entradas de video" : "HDMI, USB",
        "Dimensiones (Ancho x Alto x Fondo)" : "133 X 81 x 14,1 cms (Ancho / Alto / Fondo)",
        "Medida en diagonal" : "119.4cms"
    }
});

db.product.insert({
    "category" : NumberInt(2),
    "name" : "Mesa De Comedor En Madera Y Hierro Marca Matisses 2170001",
    "currency" : "COP",
    "price" : NumberDecimal("2870000"),
    "quantity" : NumberInt(5),
    "score" : NumberDecimal("3.7"),
    "description" : "Mesa de comedor en madera y hierro. \n Mesa de comedor con patas en madera, estructura y top en hierro. Su diseño mezcla materiales propios del estilo vintage.",
    "image" : "https://http2.mlstatic.com/mesa-de-madera-maciza-con-patas-metalicas-D_NQ_NP_996515-MLA25265093935_012017-F.jpg",
    "detail" : {
        "Color" : "Abano y Negro",
        "Materiales" : "Madera y Hierro",
        "Dimensiones" : "237 cm de largo 100 cm de ancho y 79 cm de alto"
    }
});


db.product.createIndex({"category" : NumberInt(1)},{"name" : "category_product"});