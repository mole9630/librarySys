package top.mole9630.library.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class BookSearchSimpleVo {
    @ApiModelProperty(value = "图书ID")
    private Integer id;

    @ApiModelProperty(value = "图书ISBN")
    private String ibsn;

    @ApiModelProperty(value = "图书名称")
    private String name;

    @ApiModelProperty(value = "出版日期")
    private String pubdate;

    @ApiModelProperty(value = "图书封面")
    private String source_image;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "出版社")
    private String publisher;

    @ApiModelProperty(value = "图书状态")
    private Integer status;
}
