package top.mole9630.library.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "图书信息")
@JsonIgnoreProperties(value = {"ordered", "status", "createTime", "updateTime"})
public class BookInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "图书ID")
    private Integer id;

    @ApiModelProperty(value = "图书ISBN")
    private String ibsn;

    @ApiModelProperty(value = "图书名称")
    private String name;

    @ApiModelProperty(value = "出版日期")
    private String pubdate;

    @ApiModelProperty(value = "图书封面")
    private String sourceImage;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "出版社")
    private String publisher;

    @ApiModelProperty(value = "图书价格")
    private String price;

    @ApiModelProperty(value = "图书页数")
    private String pages;

    @ApiModelProperty(value = "排序")
    private Integer ordered;

    @ApiModelProperty(value = "图书状态")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT) // 新增时自动填充
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE) // 新增或更新时自动填充
    private String updateTime;
}
