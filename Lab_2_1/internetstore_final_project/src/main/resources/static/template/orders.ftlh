<html>
    <head>
        <title>Hello from Freemarker</title>
    </head>
    <body>
        <div id="content">
            <table class="datatable">
                <tr>
                    <th>client name</th> <th>product</th> <th>quantity</th> <th>Date</th>
                </tr>
                <#list model["orders"] as orders>
                    <tr>
                       <td>${orders.client.name}</td>
                        <td>${orders.check.product.name}</td>
                        <td>${orders.check.quantity}</td>
                        <td>${orders.orderDateTime}</td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>