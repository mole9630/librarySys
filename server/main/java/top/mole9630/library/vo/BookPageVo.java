package top.mole9630.library.vo;

import lombok.Data;
import top.mole9630.library.entity.BookAll;
import top.mole9630.library.entity.BookInfo;

import java.util.List;

@Data
public class BookPageVo {
    BookInfo bookInfo;
    List<BookAll> bookAllList;
}
