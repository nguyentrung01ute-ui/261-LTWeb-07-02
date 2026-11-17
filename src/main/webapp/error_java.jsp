<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Java Error</title>
        <link rel="stylesheet" href="styles/error.css"/>
    </head>
    <body>
        <h1>Java error</h1>
        <p>Sorry, Java has thrown an exception.</p>
        <p>To continue, click the Back Button</p>

        <h2>Details</h2>
        <p>Type: ${pageContext.exception["class"]}</p>
        <p>Message: ${pageContext.exception.message}</p>
        <button type="button" class="btn-error" onclick="history.back()">Back</button>
        <footer>
            <p> Nếu bạn cần hỗ trợ, vui lòng liên hệ: <b>${initParam.custServEmail}</b></p>
        </footer>
    </body>

</html>