// Classe base Veiculo
class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int velocidade;

    public Veiculo(String marca, String modelo, int anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.velocidade = 0;
    }

    // Métodos comuns
    public void acelerar(int incremento) {
        velocidade += incremento;
        System.out.println("Acelerando. Velocidade atual: " + velocidade + " km/h");
    }

    public void frear(int decremento) {
        if (velocidade >= decremento) {
            velocidade -= decremento;
            System.out.println("Freando. Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("O veículo já está parado.");
        }
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getVelocidade() {
        return velocidade;
    }
}

// Subclasse Carro
class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String marca, String modelo, int anoFabricacao, int numeroPortas) {
        super(marca, modelo, anoFabricacao);
        this.numeroPortas = numeroPortas;
    }

    // Métodos específicos para Carro
    public void abrirPortas() {
        System.out.println("Abrindo as " + numeroPortas + " portas do carro.");
    }
}

// Subclasse Moto
class Moto extends Veiculo {
    private boolean temBau;

    public Moto(String marca, String modelo, int anoFabricacao, boolean temBau) {
        super(marca, modelo, anoFabricacao);
        this.temBau = temBau;
    }

    // Métodos específicos para Moto
    public void ligarFarol() {
        System.out.println("Ligando o farol da moto.");
    }
}

// Subclasse Bicicleta
class Bicicleta extends Veiculo {
    private int numeroMarchas;

    public Bicicleta(String marca, String modelo, int anoFabricacao, int numeroMarchas) {
        super(marca, modelo, anoFabricacao);
        this.numeroMarchas = numeroMarchas;
    }

    // Métodos específicos para Bicicleta
    public void trocarMarcha(int marcha) {
        System.out.println("Trocar para a marcha " + marcha);
    }
}

// Classe Executavel
public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 4);
        Moto moto = new Moto("Honda", "CBR 600", 2021, true);
        Bicicleta bicicleta = new Bicicleta("Caloi", "XRT", 2020, 18);

        carro.acelerar(100);
        carro.abrirPortas();

        moto.acelerar(70);
        moto.ligarFarol();

        bicicleta.acelerar(25);
        bicicleta.trocarMarcha(3);
    }
}
