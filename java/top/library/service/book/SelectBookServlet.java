package top.library.service.book;

import top.library.pojo.book.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectBookServlet", value = "/SelectBook")
public class SelectBookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.selectBook(request.getParameter("b_name"));
        request.setAttribute("books", books);
        request.getRequestDispatcher("/adm/index_v3.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
