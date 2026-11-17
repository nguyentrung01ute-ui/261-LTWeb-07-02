<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/includes/header.html" %>

        <h1>Thanks for joining our email list and survey</h1>

        <p>Here is the information that you entered:</p>

        <label>Email:</label>
        <span>${user.email}</span><br>

        <label>First Name:</label>
        <span>${user.firstName}</span><br>

        <label>Last Name:</label>
        <span>${user.lastName}</span><br>

        <label>Date of Birth:</label>
        <span>${user.dateOfBirth}</span><br>

        <label>Heard From:</label>
        <span>${survey.heardFrom}</span><br>

        <label>Updates:</label>
        <span>${survey.wantsUpdates}</span><br>

        <label>Email OK:</label>
        <span>${survey.emailOK}</span><br>

        <c:if test="${survey.wantsUpdates != 'No'}">
                <label>Contact Via:</label>
                <span>${survey.contactVia}</span><br>
        </c:if>
<!-- -->
        <p>To enter another email address, click on the Back
        button in your browser or the Return button shown 
        below.</p>
        <p>Nếu cần hỗ trợ, vui lòng liên hệ: <b>${initParam.custServEmail}</b></p>
        <form action="emailList" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>

<%@ include file="/includes/footer.jsp" %>
