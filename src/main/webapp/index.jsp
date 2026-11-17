<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="/includes/header.html" %>

        <img src="images.png" alt="Murach Logo" width="100">
        <h1>Survey</h1>
        <p>If you have a moment, we'd appreciate it if you would fill out this survey.</p>
        <c:if test="${message != null}">
            <p class="error-msg">
                <i><c:out value="${message}"/></i>
            </p>
        </c:if>
        <form action="emailList" method="post">
            <input type="hidden" name="action" value="add">

            <h2>Your information:</h2>
            <label>First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}"><br>

            <label>Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}"><br>

            <label>Email:</label>
            <input type="email" name="email" value="${user.email}"><br>

            <label>Date of Birth:</label>
            <input type="date" name="dateOfBirth"><br>

            <h2>How did you hear about us?</h2>
            <p>
                <input type="radio" name="heardFrom" value="Search Engine" checked>Search engine
                <input type="radio" name="heardFrom" value="Friend">Word of mouth
                <input type="radio" name="heardFrom" value="Social Media">Social Media
                <input type="radio" name="heardFrom" value="Other">Other
            </p>

            <h2>Would you like to receive announcements about new CDs and special offers?</h2>
            <p>
                <input type="checkbox" name="wantsUpdates" value="yes" ${survey.wantsUpdates == 'yes'? 'checked' :''}>YES, I'd like that.<br>
                <input type="checkbox" name="emailOK" value="yes" ${survey.emailOK == "yes"? 'checked':''}>YES, please send me email announcements.
            </p>

            <p>Please contact me by:
                <select name="contactVia">
                    <option value="Both" selected>Email or postal mail</option>
                    <option value="Email">Email only</option>
                    <option value="Postal Mail">Postal mail only</option>
                </select>
            </p>

            <input type="submit" value="Submit" id="submit">
        </form>

<%@ include file="/includes/footer.jsp" %>
