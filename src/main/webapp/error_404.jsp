<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>404 - Page Not Found</title>
        <link rel="stylesheet" href="styles/error.css"/>
    </head>
    <body>
        <h1>404 Error</h1>
        <p>The servlet was not able to find file you requested</p>
        <p>To continue, click the Back Button</p>
        <button type="button" class="btn-error" onclick="history.back()">Back</button>

        <a href="${pageContext.request.contextPath}/index.jsp" class="btn-error"></a>
        <footer>
            <p> Nếu bạn cần hỗ trợ, vui lòng liên hệ: <b>${initParam.custServEmail}</b></p>
        </footer>
    </body>
</html>