package EsercizioJavaStream;

public class Customer {Long id;
    String name;
    Integer tier;

    public Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }


    public Integer getTier() { return tier; }
    public String getName() { return name; }
}
