package top.library.service.book;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.library.mapper.book.BookMapper;
import top.library.mapper.user.UserMapper;
import top.library.pojo.book.Book;
import top.library.pojo.user.User;
import top.library.util.db.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @author mole9630
 */
public class BookService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Book> selectAllBook() {
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //执行方法
        List<Book> books = bookMapper.selectAll();
        // 释放资源
        sqlSession.close();

        return books;
    }

    public int deleteBook(String bIBSN) {
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //执行方法
        int statusCode = bookMapper.deleteBook(bIBSN);
        // 提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();

        return statusCode;
    }

    public List<Book> selectBook(String bName) {
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //执行方法
        List<Book> books = bookMapper.selectBook(bName);
        // 释放资源
        sqlSession.close();

        return books;
    }

}
