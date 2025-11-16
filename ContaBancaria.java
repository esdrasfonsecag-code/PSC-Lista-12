// Classe ContaBancaria
public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;

    // Getter e Setter numeroConta
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        if (numeroConta == null || numeroConta.isEmpty()) {
            System.out.println("Número da conta inválido!");
        } else {
            this.numeroConta = numeroConta;
        }
    }

    // Getter e Setter titular
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isEmpty()) {
            System.out.println("Nome do titular inválido!");
        } else {
            this.titular = titular;
        }
    }

    // Getter saldo (somente leitura)
    public double getSaldo() {
        return saldo;
    }

    // Métodos de transação
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido!");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque!");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        }
    }
}

// Classe de Teste
public class TesteEncapsulamento {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();

        // Tentativa de acesso direto (gera erro se tentar na prática)
        // conta.saldo = 500;  // ERRO: saldo é private

        // Inicializando com Setters
        conta.setNumeroConta("12345-6");
        conta.setTitular("Esdras Fonseca");

        // Testes de depósito
        conta.depositar(1000);
        conta.depositar(-50);

        // Testes de saque
        conta.sacar(200);
        conta.sacar(2000);
        conta.sacar(-10);

        // Exibindo saldo final
        System.out.println("Saldo final: R$" + conta.getSaldo());
    }
}
