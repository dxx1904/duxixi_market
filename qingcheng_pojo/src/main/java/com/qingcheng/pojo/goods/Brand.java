package com.qingcheng.pojo.goods;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//因为本实体类是需要在网络上面传输的，需要实现可序列化。现在使用 dubbo 这个分布式的框架
@Table(name="tb_brand") //如果表名和类名一样只是首字母大写的问题中间的name可用省略，但现在因为表名前缀被省略了，故需要指定实体类所对应的表名
public class Brand implements Serializable {
    @Id  //标明该属性是数据库的主键字段
    private Integer id;
    private String name;
    private String image;
    private String letter;
    private Integer seq; //排序

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
