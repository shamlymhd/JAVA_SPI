package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.google.gson.Gson;
import com.shamly.service.api.account.Account;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;

@WebServlet("/Account-servlet")
public class Accountservlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        try {

            AccountService accountService = AccountService.getInstance();
            Iterator<Account> iterator = accountService.getLoader().iterator();
            List<AccountTO> accountList = new ArrayList<>();

            while(iterator.hasNext()) {
                Account next = iterator.next();
                AccountTO acc = new AccountTO();
                acc.setAccountId(next.getAccountId());
                acc.setAccountType(next.getAccountType());
                accountList.add(acc);
            }

            AccountTO[] accounts = accountList.toArray(new AccountTO[accountList.size()]);

            Gson gson = new Gson();
            String accountListAsString = gson.toJson(accounts);

            response.getOutputStream().write(getBytes(accountListAsString));

        }
        catch(Exception e) {

        }finally{
            response.getOutputStream().close();
        }

        response.setContentType("text/html");

        // Account
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}