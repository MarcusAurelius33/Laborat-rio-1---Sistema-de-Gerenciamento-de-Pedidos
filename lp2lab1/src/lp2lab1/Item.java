package lp2lab1;

public class Item {

 private String nome;
 private double preco;

 //construtor do item
 public Item(String nome, double preco) {
     this.nome = nome;
     this.preco = preco;
 }
 
//metodos get dos atributos
 public String getNome() {
     return nome;
 }

 public double getPreco() {
     return preco;
 }
}
