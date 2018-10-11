package com.gupao.edu.auction;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2018/10/11
 */
public enum AuctionModelEnum {

    AUCTION_PRICE_MODEL(1, "PRICE_MODEL", "价格模式");

    private Integer code;

    private String Label;

    private String name;

    AuctionModelEnum(Integer code, String label, String name) {
        this.code = code;
        Label = label;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
