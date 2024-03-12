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
<p>Your product(s) information :</p>
<#list products as product>
   <p>${product.id} , ${product.product_name} , ${product.product_describe} , ${product.product_price}</p>
</#list>
</body>
</html>