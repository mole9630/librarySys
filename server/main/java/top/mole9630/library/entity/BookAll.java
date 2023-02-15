package top.mole9630.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = {"lendStatus", "createTime", "updateTime"})
public class BookAll implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer bookId;
    private String orgName;
    private String roomName;
    private String indexNo;
    private Integer lendStatus;
    private String createTime;
    private String updateTime;

}
