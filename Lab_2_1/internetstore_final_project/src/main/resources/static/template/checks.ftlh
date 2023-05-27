<html>
    <head>
        <title>Hello from Freemarker</title>
    </head>
    <body>
        <div id="content">
            <table class="datatable">
                <tr>
                    <th>product name</th> <th>price</th> <th>quantity</th> <th>Total price</th>
                </tr>
                <#list model["checks"] as check>
                    <tr>
                       <td>${check.product.name}</td>
                       <td>${check.product.price}</td>
                       <td>${check.quantity}</td>
                       <td>${check.checkSum}</td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>