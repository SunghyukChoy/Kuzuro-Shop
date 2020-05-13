package my.likeaglow.kuzuroshop.controller;

import java.util.Date;

public class GoodsVO {

//    CREATE TABLE tbl_goods (
//            goodsNum INT NOT NULL,
//            goodsName VARCHAR(50) NOT NULL,
//            cateCode VARCHAR(30) NOT NULL,
//            goodsPrice INT NOT NULL,
//            goodsStock INT NULL,
//            goodsDes VARCHAR(500) NULL,
//            goodsImg VARCHAR(200) NULL,
//            goodsDate TIMESTAMP DEFAULT NOW(),
//            PRIMARY KEY(goodsName)
//            );

    private int goodsNum;
    private String goodsName;
    private String cateCode;
    private int goodsPrice;
    private int goodsStock;
    private String goodsDes;
    private String goodsImg;
    private Date goodsDate;

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Date getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(Date goodsDate) {
        this.goodsDate = goodsDate;
    }
}