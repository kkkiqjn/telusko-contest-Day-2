package src;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        return products.stream()
            .filter(p -> p.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();
        products.stream()
        .filter(p -> p.getName().toLowerCase().contains(str)
                || p.getType().toLowerCase().contains(str)
                || p.getPlace().toLowerCase().contains(str))
        .forEach(prods::add);

        return prods;

    }


    
    public Product getProductbyPlace(String place){
        return products.stream()
            .filter(p -> p.getName().equals(place))
            .findFirst()
            .orElse(null);
    }

    public List<Product> getProductsOutofWarranty(){
       List<Product> prods=new ArrayList<>();
       products.stream()
       .filter(p -> p.getWarranty()-2024>=0)
.forEach(prods::add);

return prods;
           
            
    }




}
