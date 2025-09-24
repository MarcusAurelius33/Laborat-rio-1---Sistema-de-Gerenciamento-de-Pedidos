package lp2lab1;

import java.util.ArrayList;
import java.util.List;

//pedido feito que contem dados do cliente
public class Pedido {

    private int numero;
    private String nomeCliente;
    
    private List<Item> itens;

    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>(); 
    }
    
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }
 //calcula e retorna valor do pedido
    public double calcularValorTotal() {
        double total = 0.0;
        for (Item item : this.itens) {
            total += item.getPreco(); 
        }
        return total;
    }
     //metodos get
    public int getNumero() {
        return numero;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public List<Item> getItens() {
        return itens;
    }
}
