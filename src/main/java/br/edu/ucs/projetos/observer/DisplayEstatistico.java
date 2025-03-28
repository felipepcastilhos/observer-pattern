package br.edu.ucs.projetos.observer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Essa classe é outra implementação concreta de Observador, que mostra as
 * temperaturas e umidades médias, mínimas e máximas com base nas últimas 10
 * atualizações.
 */
public class DisplayEstatistico implements Observador {

  private Queue<Double> temperaturas = new LinkedList<>();
  private Queue<Double> umidades = new LinkedList<>();
  private static final int MAX_REGISTROS = 10;

  @Override
  public void atualizar(double temperatura, double umidade, double pressao) {
    registrar(temperaturas, temperatura);
    registrar(umidades, umidade);
    exibir();
  }

  private void registrar(Queue<Double> fila, double valor) {
    if (fila.size() >= MAX_REGISTROS) {
      fila.poll(); // Remove o mais antigo
    }
    fila.offer(valor); // Adiciona o novo valor
  }

  private void exibir() {
    System.out.println("=== Estatísticas do Clima ===");
    System.out.printf("Temperatura -> Média: %.2f °C | Mín: %.2f °C | Máx: %.2f °C\n",
        media(temperaturas), minimo(temperaturas), maximo(temperaturas));
    System.out.printf("Umidade     -> Média: %.2f %% | Mín: %.2f %% | Máx: %.2f %%\n",
        media(umidades), minimo(umidades), maximo(umidades));
    System.out.println();
  }

  private double media(Queue<Double> fila) {
    if (fila.isEmpty())
      return 0.0;
    return fila.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
  }

  private double minimo(Queue<Double> fila) {
    return fila.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
  }

  private double maximo(Queue<Double> fila) {
    return fila.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
  }
}
