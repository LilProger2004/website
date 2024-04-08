<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/style2.css">
    <title>UserPage</title>
</head>
<body>
<h1>${userData.user_name}</h1>
<p>Your login : ${userData.user_login}</p>
<p>Your email : ${userData.user_email}</p>
<p>${userData.mobile_number}</p>
<p>Your product(s) information :</p>
<#list products as product>
    <div class="product-item">
        <div class="product-image"></div>
        <div class="product-name">${product.product_name}</div>
        <div class="product-price">${product.product_price}</div>
        <a href="#" class="product-link">Подробнее</a>
    </div>
</#list>
</body>
</html>