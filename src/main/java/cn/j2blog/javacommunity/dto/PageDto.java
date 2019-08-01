package cn.j2blog.javacommunity.dto;

import lombok.Data;

@Data
public class PageDto {

    private Integer countPage;
    private Integer startRow;
    private Integer countRow;
    public void startRow(Integer currentPage, Integer countRow, Integer count){
        countPage = count / countRow;
        if(count % countRow != 0) {
            countPage++;
        }
        this.countRow = countRow;
        this.startRow = (currentPage - 1) * countRow;
    }
}
