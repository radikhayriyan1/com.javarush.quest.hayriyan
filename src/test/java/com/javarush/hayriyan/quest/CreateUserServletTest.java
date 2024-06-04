package com.javarush.hayriyan.quest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserServletTest {

    @Test
    public void doGetTest() throws ServletException, IOException {
        CreateUserServlet userServlet = new CreateUserServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/step1.jsp")).thenReturn(dispatcher);
        when(request.getParameter("username")).thenReturn("testName");

        userServlet.doGet(request, response);

        verify(request, times(1)).getRemoteAddr();
        verify(servletContext, times(1)).getRequestDispatcher("/step1.jsp");
        verify(request, times(1)).getRemoteAddr();
        assertEquals("testName", request.getParameter("username"));
    }
}
