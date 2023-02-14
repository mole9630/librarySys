package top.mole9630.library.entity;

import lombok.Data;

@Data
public class LendList {
    private Integer id;
    private Integer bookId;
    private Integer userId;
    private String lendDate;
    private String backDate;
    private Integer renewal;
}
