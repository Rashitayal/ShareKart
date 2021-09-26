DROP TABLE `share_kart`.`category`;
INSERT INTO category (category_id, category_name) VALUES (1,'food');
INSERT INTO category (category_id, category_name) VALUES (2,'fashion');
INSERT INTO category (category_id, category_name) VALUES (3,'flowers');
INSERT INTO category (category_id, category_name) VALUES (4,'gadgets');
INSERT INTO category (category_id, category_name) VALUES (5,'accessories');


DROP TABLE `share_kart`.`sub_category`;
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (1,1,'cakes');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (2,1,'icecreams');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (3,1,'shakes');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (4,1,'sweets');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (5,2,'western');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (6,2,'ethnic');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (7,3,'orchids');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (8,3,'roses');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (9,3,'tulips');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (10,4,'mobiles');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (11,4,'laptops');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (12,4,'home appliances');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (13,5,'jewellery');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (14,5,'sunglasses');
INSERT INTO sub_category (sub_cat_id,category_id,sub_cat_name) VALUES (15,5,'hair accessories');


DROP TABLE `share_kart`.`product`;
INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('1', 'male', 'Chocolate Cake', 'Manyavar Green Cotton Kurta', 'https://5.imimg.com/data5/HY/TV/MY-17286568/mens-kurta-500x500.jpg', 'kurta', '2500', 6);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('2', 'male', 'Chocolate Cake', 'Van Heusen Blue Blazer', 'https://5.imimg.com/data5/HY/TV/MY-17286568/mens-kurta-500x500.jpg', 'blazer', '4999', 5);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('3', 'male', 'Chocolate Cake', 'Flying Machine Shirt', 'https://cdn.shopify.com/s/files/1/0310/3765/3128/products/S20RBCMS048-INDIGO-4_500x500.jpg?v=1587384473', 'shirt', '1999', 5);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('4', 'male', 'Chocolate Cake', 'Manyavar Dhotin Kurta Set', 'https://5.imimg.com/data5/SA/MQ/MY-45275458/mens-dhoti-kurta-500x500.jpg', 'kurta', '6999', 6);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('5', 'male', 'Chocolate Cake', 'Levis Half Sleeve Sweater', 'https://cdn10.montecarlo.in/images/ProductImages/medium/1-aMa-053028-NOn.JPG', 'tshirt', '2299', 5);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('6', 'male', 'Chocolate Cake', 'Louis Philippe Suit', 'https://4.imimg.com/data4/RB/DX/MY-25044844/men-s-suit-500x500.jpg', 'blazer', '9999', 5);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('7', 'female', 'Chocolate Cake', 'W for Women Saree', 'https://www.looksgud.in/upload/item-image/487/agbb/agbb-little-lady-sarees-womens-clothing-saree-for-women-latest_500x500_0.jpg', 'saree', '2999', 6);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('8', 'female', 'Chocolate Cake', 'Fab Alley Blue Polkadot Dress', 'https://4.imimg.com/data4/TV/TR/ANDROID-23098544/product-500x500.jpeg', 'dress', '2999', 5);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('9', 'female', 'Chocolate Cake', 'Aurelia Salwa Kurta Dupatta Set', 'https://m.media-amazon.com/images/I/41-E8qi2B2L.jpg', 'kurta', '1999', 6);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('10', 'female', 'Chocolate Cake', 'Biba Kurti', 'https://static.fibre2fashion.com/MemberResources/LeadResources/1/2019/4/Buyer/19162591/Images/19162591_0_ladies-salwar-suit.jpg', 'kurta', '1499', 6);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('11', 'female', 'Chocolate Cake', 'Fab India Kurti', 'https://m.media-amazon.com/images/I/81nM1k00MBL._UX569_.jpg', 'kurta', '899', 6);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('12', 'female', 'Chocolate Cake', 'Zara Black Dress', 'https://www.looksgud.in/upload/item-image/1072/mzif/mzif-boldgal-women-s-western-bodycon-midi-formal-office-dress-black_500x500_0.jpg', 'dress', '4999', 5);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('13', null, 'Chocolate Cake', 'Strawberry Cake 1 Kg', 'https://i1.fnp.com/images/pr/l/v20200707221035/designer-floral-chocolate-cake-1-kg_1.jpg', 'strawberry cake', '799', 1);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('14', null, 'Chocolate Cake', 'Snickers Kitkat Milkshake', 'https://media.istockphoto.com/photos/isolated-chocolate-milkshake-picture-id1164000394?k=20&m=1164000394&s=612x612&w=0&h=nqK6l4mjTRVYXWOLj3jSQAsm3tHRKCawijj9GnyCsac=', 'kitkat shake', '299', 3);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('15', null, 'Chocolate Cake', 'Chamcham 1Kg', 'https://t3.ftcdn.net/jpg/01/71/15/88/360_F_171158857_a2KMfaveiYPSRPocbpZSKmx4Yiacb3I1.jpg', 'chamcham', '600', 4);

INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('16', null, 'Chocolate Cake', 'Blackcurrent Kesar Pista Scoop', 'https://ak.picdn.net/shutterstock/videos/10985924/thumb/1.jpg', 'kesar pista icecream', '200', 2);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('17', null, 'Chocolate Cake', 'Chocolate Mousse Cake 1Kg', 'https://img.freepik.com/free-photo/chocolate-cakes-isolated-white-background_74190-1836.jpg?size=626&ext=jpg', 'chocolate cake', '999', 1);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('18', null, 'Chocolate Cake', 'Chocolate Milkshake', 'https://t3.ftcdn.net/jpg/04/15/99/26/360_F_415992666_VLdWWhUlNHrilVsZD7otZBKzEknzTm4o.jpg', 'chocolate shake', '149', 3);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('19', null, 'Chocolate Cake', '20 Red Rose Bouquet', 'https://img5.goodfon.com/wallpaper/nbig/a/30/rozy-buket-belyi-fon-1.jpg', 'red rose', '499', 8);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('20', null, 'Chocolate Cake', 'Colorful Tulip Bouquet with Vase', 'https://media.istockphoto.com/photos/colorful-tulips-in-a-glass-vase-isolated-on-white-background-picture-id628790862?
b=1&k=20&m=628790862&s=170667a&w=0&h=PbOIvoyvfK7UlNOGPXv5YBz3Jbv3kgB80zruhLDC3LU=', 'tulip', '1499', 9);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('21', null, 'Chocolate Cake', '10 White Tulips', 'https://image.freepik.com/free-photo/beautiful-tulips-bouquet-white-background_24972-77.jpg', 'white tulip', '999', 9);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('22', null, 'Chocolate Cake', 'Pink Rose Bouquet', 'https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bGlnaHQlMjBwaW5rJTIwcm9zZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80', 'pink rose', '399', 8);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('23', null, 'Chocolate Cake', '5 Purple Orchid Bunch', 'https://npr.brightspotcdn.com/dims4/default/3cdb4c1/2147483647/strip/true/crop/1254x658+0+89/resize/1200x630!/quality/90/?url=http%3A%2F%2Fnpr-brightspot.s3.amazonaws.com%2Flegacy%2Fsites%2Fvpr%2Ffiles%2F202001%2Forchid-istock-wjarek.jpg', 'purple orchid', '545', 7);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('24', null, 'Chocolate Cake', 'White Orchid Bouquet with Vase', 'https://i1.fnp.com/images/pr/l/v20161115162428/exotic-bouquet-standard_1.jpg', 'white orchid', '1949', 7);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('25', null, 'Chocolate Cake', 'Samsung S21', 'https://www.businessinsider.in/thumb.cms?msid=80039794&width=1200&height=900', 'samsung s21', '69999', 10);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('26', null, 'Chocolate Cake', 'Iphone SE', 'https://images.firstpost.com/fpimages/1200x800/fixed/jpg/2020/04/Apple-iPhone-SE-720.jpg', 'iphone se', '39999', 10);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('27', null, 'Chocolate Cake', 'Dell XPS 9305', 'https://i.dell.com/is/image/DellContent//content/dam/global-site-design/product_images/dell_client_products/notebooks/xps_notebooks/xps_17_9700/media-gallery/xs9700nt_cnb_00055lf110_bk_hero_cropped.jpg?fmt=pjpg&amp;pscan=auto&amp;scl=1&amp;hei=402&amp;wid=402&amp;qlt=85,0&amp;resMode=sharp2&amp;op_usm=
1.75,0.3,2,0&amp;size=402,402', 'dell', '1,17,262', 11);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('28', null, 'Chocolate Cake', 'LG Washing Machine', 'https://st4.depositphotos.com/10614052/i/600/depositphotos_252516756-stock-photo-modern-washing-machine-and-laundry.jpg', 'iphone se', '24999', 12);



INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('29', null, 'Chocolate Cake', 'Wonderchef Juicer', 'https://cdn.shopify.com/s/files/1/0104/9211/7092/products/6_ee65974a-6a14-4a7c-9d07-a26a428f4f5f_400x.jpg?v=1584611822', 'iphone se', '1299', 12);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('30', null, 'Chocolate Cake', 'Gold Bangle', 'https://i.pinimg.com/originals/dd/5d/17/dd5d1788d12006ebf43e295d299b03b8.jpg', 'iphone se', '19949', 13);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('31', null, 'Chocolate Cake', 'Vincent Chase Glasses', 'https://cdn.pixabay.com/photo/2016/10/11/12/36/sunglasses-1731454_960_720.jpg', 'iphone se', '2499', 14);



INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('32', null, 'Chocolate Cake', 'Tommy Hilfiger Wallet', 'https://media.istockphoto.com/photos/leather-wallet-on-a-white-background-picture-id599908252?b=1&k=20&m=599908252&s=170667a&w=0&h=mTC8estfF1-9UMho5sjdx7OvRb6QVlRtZ4djIGRagAQ=', 'iphone se', '2199', 13);



INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('33', null, 'Chocolate Cake', 'Gold Pendant', 'https://i.pinimg.com/originals/58/0a/f3/580af3d8da75982c94e92abe61d0a7b3.jpg', 'iphone se', '29999', 13);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('34', null, 'Chocolate Cake', 'Beard Hair Care Kit', 'https://m.media-amazon.com/images/I/619E+T7FqiL._SY355_.jpg', 'iphone se', '699', 15);


INSERT INTO share_kart.product (product_id, classification, description, display_name, img_url, name, price, sub_category_id) VALUES('35', null, 'Chocolate Cake', 'Ustara Gift Kit', 'https://m.media-amazon.com/images/I/61H1ks1+yPL._SY450_.jpg', 'iphone se', '1199', 15);

UPDATE `share_kart`.`product` SET `img_url` = 'https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX1457884.jpg ' WHERE (`img_url` = 'https://img.freepik.com/free-photo/chocolate-cakes-isolated-white-background_74190-1836.jpg?size=626&ext=jpg');
