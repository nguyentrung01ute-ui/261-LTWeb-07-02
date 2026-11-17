package com.testapp.chapter2.controller;

import com.testapp.chapter2.dao.UserDB;
import com.testapp.chapter2.dto.SurveyDTO;
import com.testapp.chapter2.dto.UserDTO;
import com.testapp.chapter2.model.Survey;
import com.testapp.chapter2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String url = "/index.jsp";

        // Lấy năm hiện tại và lưu vào Request Scope (dùng cho footer.jsp)
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // Perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("add")) {
            // 1. Get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");

            String heardFrom = request.getParameter("heardFrom");
            String wantsUpdates = request.getParameter("wantsUpdates");
            String emailOK = request.getParameter("emailOK");
            String contactVia = request.getParameter("contactVia");

            if (wantsUpdates == null) {
                wantsUpdates = "No";
            }
            if (emailOK == null) {
                emailOK = "No";
            }

            UserDTO userDTO = new UserDTO(firstName, lastName, email, dateOfBirth);
            SurveyDTO surveyDTO = new SurveyDTO(heardFrom, wantsUpdates, emailOK, contactVia);

            String message;
            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes!";
                url = "/index.jsp";
            } else {
                message = "";

                User user = new User(
                        userDTO.getFirstName(),
                        userDTO.getLastName(),
                        userDTO.getEmail(),
                        userDTO.getDateOfBirth()
                );
                Survey survey = new Survey(
                        surveyDTO.getHeardFrom(),
                        surveyDTO.getWantsUpdates(),
                        surveyDTO.getEmailOK(),
                        surveyDTO.getContactVia()
                );

                // Đọc <init-param> riêng của EmailListServlet từ web.xml
                String relativePath = getServletConfig().getInitParameter("relativePathToFile");
                String realPath = getServletContext().getRealPath(relativePath);

                // Đọc <context-param> dùng chung của toàn bộ ứng dụng từ web.xml
                String custServEmail = getServletContext().getInitParameter("custServEmail");

                System.out.println("Đường dẫn file thật: " + realPath);
                System.out.println("Email CSKH: " + custServEmail);

                UserDB.insert(user);
                UserDB.insertSurvey(survey);
                url = "/thanks.jsp";
            }

            request.setAttribute("user", userDTO);
            request.setAttribute("survey", surveyDTO);
            request.setAttribute("message", message);
        }
        // Forward request and response objects to specified View URL

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                          throws ServletException, IOException {
        doPost(request, response);
    }
}
