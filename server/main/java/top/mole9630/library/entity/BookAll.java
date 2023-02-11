package top.mole9630.library.entity;

import lombok.Data;

@Data
public class BookAll {
    private Integer id;
    private Integer book_id;
    private String org_name;
    private String room_name;
    private Integer index_no;
    private String lend_status;
    private String create_time;
    private String update_time;

}
