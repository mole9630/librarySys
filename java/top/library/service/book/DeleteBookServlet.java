package top.library.service.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", value = "/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bIBSN = request.getParameter("bIBSN");
        int statusCode = bookService.deleteBook(bIBSN);
        if (statusCode == 1) {
            request.getRequestDispatcher("/BookAll").forward(request,response);
        } else {
            request.setAttribute("message", "删除失败");
            request.getRequestDispatcher("/test").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
