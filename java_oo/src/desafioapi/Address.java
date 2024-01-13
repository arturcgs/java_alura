package desafioapi;

public class Address {
    public String cep;
    public String street;
    public String neighborhood;
    public String city;
    public String state;


    public Address(AddressApi myAddressApi) {
        this.cep = myAddressApi.cep();
        this.street = myAddressApi.logradouro();
        this.neighborhood = myAddressApi.bairro();
        this.city = myAddressApi.localidade();
        this.state = myAddressApi.uf();
    }

    @Override
    public String toString() {
        return "Address{" +
                "cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
