package restaurante;

public class Produto {
    private Long prod_id;
    private String prod_desc;
    private Double prod_price;
    private Categoria prod_cat;

    public Produto() {

    }

    public Produto(Long prod_id, String prod_desc, Double prod_price) {
        this.setProd_id(prod_id);
        this.setProd_desc(prod_desc);
        this.setProd_price(prod_price);
    }

    public Produto(Long prod_id, String prod_desc, Double prod_price, Categoria categoria) {
        this.setProd_id(prod_id);
        this.setProd_desc(prod_desc);
        this.setProd_price(prod_price);
        this.setProd_cat(categoria);
    }


    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public Double getProd_price() {
        return prod_price;
    }

    public void setProd_price(Double prod_price) {
        this.prod_price = prod_price;
    }

    public Categoria getProd_cat() {
        return prod_cat;
    }

    public void setProd_cat(Categoria prod_cat) {
        this.prod_cat = prod_cat;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "prod_id=" + prod_id +
                ", prod_desc='" + prod_desc + '\'' +
                ", prod_price=" + prod_price +
                ", prod_cat=" + prod_cat +
                '}';
    }

}
