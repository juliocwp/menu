package restaurante;

public class Categoria {
    private Long cat_id;
    private String cat_desc;

    public Categoria () {}

    public Categoria (Long id, String desc) {
        this.cat_id = id;
        this.cat_desc = desc;
        // Teste descrição catego
    }

    public String getCat_desc() {
        return cat_desc;
    }

    public void setCat_desc(String cat_desc) {
        this.cat_desc = cat_desc;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "cat_id=" + cat_id +
                ", cat_desc='" + cat_desc + '\'' +
                '}';
    }
}
