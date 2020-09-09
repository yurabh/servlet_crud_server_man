package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.domain.Man;
import com.service.CrudService;
import com.service.ManService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "manServlet", urlPatterns = {"/save", "/get", "/update", "/delete"})
public class ServletMan extends HttpServlet {

    private CrudService<Man> manService;

    public ServletMan() {
        manService = new ManService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();

        ObjectMapper mapper = new ObjectMapper();

        Man man = mapper.readValue(reader, Man.class);

        manService.save(man);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Man manFound = manService.getById(id);

        resp.setHeader("Content-Type", "application/json");

        PrintWriter writer = resp.getWriter();

        ObjectMapper mapper = new ObjectMapper();

        String manAsString = mapper.writeValueAsString(manFound);

        writer.println(manAsString);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();

        ObjectMapper mapper = new ObjectMapper();

        Man man = mapper.readValue(reader, Man.class);

        manService.update(man);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int manId = Integer.parseInt(req.getParameter("id"));

        Man man = manService.deleteById(manId);

        resp.setHeader("Content-Type", "application/json");

        PrintWriter writer = resp.getWriter();

        ObjectMapper mapper = new ObjectMapper();

        String manAsString = mapper.writeValueAsString(man);

        writer.println(manAsString);
    }
}
