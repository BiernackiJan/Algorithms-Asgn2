package Models;

public class BakedGoods {

    private String goodsType;
    private String goodsName;
    private String originCountry;
    private String URL;

    public BakedGoods(String goodsType, String goodsName, String originCountry, String URL) {
        this.goodsType = goodsType;
        this.goodsName = goodsName;
        this.originCountry = originCountry;
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Baked Goods: " + '\n' +
                "  " + goodsName + "  " + goodsType +
                "  Originated in " + originCountry + '\n' ;
    }
}
