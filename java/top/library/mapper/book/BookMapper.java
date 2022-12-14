package top.library.mapper.book;

import top.library.pojo.book.Book;

import java.util.List;

public interface BookMapper {
    List<Book> selectAll();

    int deleteBook(String bIBSN);

    List<Book> selectBook(String bName);
}
