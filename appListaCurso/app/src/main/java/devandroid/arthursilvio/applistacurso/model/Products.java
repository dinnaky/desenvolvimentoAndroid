// CLASSE PARA APLICAR CONHECIMENTOS

package devandroid.arthursilvio.applistacurso.model;

public class Products {
    //atributs

    private String NameProduct;
    private String brand;
    private Integer price;

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Products(){
    }
}
