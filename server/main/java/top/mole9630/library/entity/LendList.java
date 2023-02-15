package top.mole9630.library.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LendList implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "借阅单号")
    private String code;

    @ApiModelProperty(value = "图书ID")
    private Integer bookId;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "借阅日期")
    private String lendDate;

    @ApiModelProperty(value = "归还日期")
    private String backDate;

    @ApiModelProperty(value = "归还状态")
    private Integer backStatus;

    @ApiModelProperty(value = "续借次数")
    private Integer renewal;
}
