<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>History</h1>
<table border="1" cellpadding="3"><#list history as item>
        <tr>
            <td>${item.user.username} </td>
            <td>${item.operation.op1}</td>
            <td>${item.operation.operation}</td>
            <td>${item.operation.op2} </td>
        </tr>
    </#list></table>
</body>
</html>
