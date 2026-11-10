package com.testapp.chapter2.controller;

import com.testapp.chapter2.data.UserDB;
import com.testapp.chapter2.dto.SurveyDTO;
import com.testapp.chapter2.dto.UserDTO;
import com.testapp.chapter2.model.Survey;
import com.testapp.chapter2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String url = "/index.html";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // Perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html";
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

            UserDB.insert(user);
            UserDB.insertSurvey(survey);

            request.setAttribute("user", userDTO);
            request.setAttribute("survey", surveyDTO);
            url = "/thanks.jsp";
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
