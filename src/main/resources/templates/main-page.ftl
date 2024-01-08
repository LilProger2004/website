<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Template</title>
</head>
<body>
<#list product as product>
    ${product.id},${product.product_name},${product.product_describe},${product.product_price}
</#list>
</body>
</html>