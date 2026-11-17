<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/includes/header.html"%>

        <h1>Join our email list</h1>

        <p>
            To join our email list, enter your
            name and email address below.
        </p>

        <form action="emailList" method="post">

            <input type="hidden" name="action" value="add">

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}">

            <label for="firstName">First Name:</label>
            <input type="text" id="firstName"
                   name="firstName" value="${user.firstName}">

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName"
                   name="lastName" value="${user.lastName}">
            <p><i>${message}</i></p>
            <button type="submit">Join Now</button>

        </form>
<%@ include file="/includes/footer.jsp"%>